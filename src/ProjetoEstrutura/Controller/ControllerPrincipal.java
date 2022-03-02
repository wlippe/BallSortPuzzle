package ProjetoEstrutura.Controller;

import busca.Nodo;
import java.io.File;
import javax.swing.JLabel;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import ProjetoEstrutura.Bola;
import ProjetoEstrutura.Jogo;
import java.io.BufferedReader;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import ProjetoEstrutura.Tabuleiro;
import ProjetoEstrutura.View.ViewPadrao;
import java.io.FileNotFoundException;
import javax.swing.table.DefaultTableModel;
import ProjetoEstrutura.View.ViewSolucao;
import busca.BuscaLargura;
import busca.BuscaProfundidade;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Controlador principal do Projeto de Algoritmos e Estruturas de Dados   
 * @package Controller
 * @author Walter Felipe Bachmann
 * @since Dezembro/2021
 */
public class ControllerPrincipal {

    private ViewPadrao view;
    private ViewSolucao viewSolucao;
    private Tabuleiro tabuleiro;
    private Long tempoBusca;
    private int nohAtual;
    private int quantColunas;
    private int profundidade;
    private int profundidadeAtual;
    private ArrayList<Tabuleiro> caminhoSolucao = new ArrayList<>();

    public ControllerPrincipal(ViewPadrao view) {
        this.view = view;
    }

    private void resetAtributos() {
        caminhoSolucao.clear();
        caminhoSolucao = new ArrayList<>();
        tabuleiro = null;
        nohAtual = 0;
        quantColunas = 0;
        profundidade = 0;
        profundidadeAtual = 0;
    }

    public ImageIcon getImagemBola(int cor) {
        switch (cor) {
            case 0  : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/null.png"));
            case 1  : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/vermelho.png"));
            case 2  : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/amarelo.png"));
            case 3  : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/azul.png"));
            case 4  : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/verde.png"));
            case 5  : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/cinza.png"));
            case 6  : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/laranja.png"));
            case 7  : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/roxo.png"));
            case 8  : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/vinho.png"));
            case 9  : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/rosa.png"));
            case 10 : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/roxo_forte.png"));
            case 11 : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/azul_bebe.png"));
            case 12 : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/verde_claro.png"));
            default : return new ImageIcon(getClass().getResource("/ProjetoEstrutura/View/imagens/null.png"));
        }
    }

    public void loadFile() {
        File file = this.selectFile();
        if (file != null) {
            this.loadConfigPuzzle(file);
        }
    }

    public File selectFile() {
        JFileChooser seletorArquivo = new JFileChooser();
        seletorArquivo.setDialogTitle("Procurar arquivo");
        seletorArquivo.setFileSelectionMode(0);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo de texto", "txt");
        seletorArquivo.setFileFilter(filter);

        int retorno = seletorArquivo.showOpenDialog(view);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            File file = seletorArquivo.getSelectedFile();

            return file;
        }

        return null;
    }

    public void loadConfigPuzzle(File file) {
        File arq = file;
        quantColunas = 0;

        resetAtributos();

        try {
            FileReader     leitorArq   = new FileReader(arq);
            BufferedReader leitorTexto = new BufferedReader(leitorArq);

            String[] linhaConfiguracao = leitorTexto.readLine().split("x");

            quantColunas   = Integer.parseInt(linhaConfiguracao[0]);
            this.tabuleiro = new Tabuleiro(quantColunas);

            //loop das linhas
            for(int iLinha = 0; iLinha < 4; iLinha++) {
                String[] valoresLinha = leitorTexto.readLine().split(",");

                 //loop das colunas
                for(int iColuna = 0; iColuna < valoresLinha.length; iColuna++) {
                    this.tabuleiro.getBolas()[iLinha][iColuna] = new Bola(valoresLinha[iColuna], iLinha, iColuna);
                }
            }

            this.setaTabelaJogo(this.view, this.tabuleiro);
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo nao encontrado");
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo");
        }
    }

    private void setTableConfigDefault(ViewPadrao view) {
        view.getTableTubosEnsaio().setBackground(new java.awt.Color(255, 255, 255));
        view.getTableTubosEnsaio().setColumnSelectionAllowed(false);
        view.getTableTubosEnsaio().setRowSelectionAllowed(false);
        view.getTableTubosEnsaio().setRequestFocusEnabled(false);
        view.getTableTubosEnsaio().getTableHeader().setUI(null);
        view.getTableTubosEnsaio().setDragEnabled(false);
        view.getTableTubosEnsaio().setAutoscrolls(false);
        view.getTableTubosEnsaio().setEnabled(false);
        view.getTableTubosEnsaio().setRowHeight(62);
    }

    /* Remove as linhas e colunas da tabela */
    private void resetTabela(ViewPadrao view) {
        DefaultTableModel tabela = (DefaultTableModel) view.getTableTubosEnsaio().getModel();
        tabela.setColumnCount(0);
        while(tabela.getRowCount() > 0){
            tabela.removeRow(0);
        }
    }

    /* Renderiza as imagens nas colunas utilizando o Controlador */
    private void renderColumns(ViewPadrao view) {
        ControllerCellRender render = new ControllerCellRender();
        render.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableModel tabela = (DefaultTableModel) view.getTableTubosEnsaio().getModel();
        for(int i = 0; i < tabela.getColumnCount(); i++) {
            view.getTableTubosEnsaio().getColumnModel().getColumn(i).setCellRenderer(render);
        }
    }

    public void buscaEmLargura() {
        resetAtributosSolucao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(tabuleiro == null) {
                    JOptionPane.showMessageDialog(null, "É preciso carregar um Puzzle para começar!");
                    return;
                }

                Jogo newGame = new Jogo(2, tabuleiro);
                System.out.println("busca em Largura");
                Long horaInicio = new Date().getTime();
                Nodo n = new BuscaLargura<Jogo>().busca(newGame);
                Long horaFim = new Date().getTime();
                tempoBusca =  horaFim - horaInicio;

                exibeResultadoBusca(n);
            }
        }).start();
    }

    public void buscaProfundidade() throws Exception {
        resetAtributosSolucao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Jogo newGame = new Jogo(2, tabuleiro);
                    System.out.println("busca em Profundidade");
                    Nodo n;
                    Long horaInicio = new Date().getTime();
                    n = new BuscaProfundidade<Jogo>().busca(newGame);
                    Long horaFim = new Date().getTime();
                    tempoBusca =  horaFim - horaInicio;

                    exibeResultadoBusca(n);
                } 
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "É preciso carregar um Puzzle para começar!");
                }
            }
        }).start();
    }

    private void exibeResultadoBusca(Nodo n) {
        if (n == null) {
            System.out.println("sem solucao!");
            JOptionPane.showMessageDialog(null, "sem solucao");
        } 
        else {
            profundidade = n.getProfundidade();
            profundidadeAtual = profundidade;
            System.out.println(profundidade);

            Nodo w = n;

            while (w != null) {
                Jogo th = (Jogo)w.getEstado();
                System.out.println(th.tabuleiro);
                caminhoSolucao.add(th.tabuleiro);
                w = w.getPai();
            }

            System.out.println("solucao:\n" + n.montaCaminho() + "\n\n");
            System.out.println("Tempo: " + tempoBusca + " ms");

            abreJanelaSolucao();
        }
    }

    public void setaTabelaFirstNode() {
        int first = profundidade;
        nohAtual = first;
        profundidadeAtual = 1;
        Tabuleiro tabuleiroSolucao = caminhoSolucao.get(first);
        this.setaTabelaJogo(viewSolucao, tabuleiroSolucao);
    }

    public void setaTabelaLastNode() {
        nohAtual = 0;
        profundidadeAtual = profundidade;
        Tabuleiro tabuleiroSolucao = caminhoSolucao.get(0);
        this.setaTabelaJogo(viewSolucao, tabuleiroSolucao);
    }

    public void setaTabelaPreviousNode() {
        int previous = nohAtual + 1;
        nohAtual = previous;
        profundidadeAtual = profundidadeAtual - 1;
        Tabuleiro tabuleiroSolucao = caminhoSolucao.get(previous);
        this.setaTabelaJogo(viewSolucao, tabuleiroSolucao);
    }

    public void setaTabelaNextNode() {
        int next = nohAtual - 1;
        nohAtual = next;
        profundidadeAtual = profundidadeAtual + 1;
        Tabuleiro tabuleiroSolucao = caminhoSolucao.get(next);
        this.setaTabelaJogo(viewSolucao, tabuleiroSolucao);
    }

    private void abreJanelaSolucao() {
        viewSolucao = new ViewSolucao();
        viewSolucao.setController(this);
        setaTabelaLastNode();
        viewSolucao.setVisible(true);
    }

    private void setaTabelaJogo(ViewPadrao view, Tabuleiro tabuleiro) {
        this.resetTabela(view);

        DefaultTableModel tabela = (DefaultTableModel) view.getTableTubosEnsaio().getModel();

        for(int iLinha = 0; iLinha < 4; iLinha++) {
            Object oLinha[] = new Object[quantColunas];
            for(int iColuna = 0; iColuna < quantColunas; iColuna++) {
                if(iLinha==0) {
                    tabela.addColumn("");
                }
                Bola bola = tabuleiro.getBolas()[iLinha][iColuna];

                int iCor = 0;

                if(bola instanceof Bola) {
                    iCor = Integer.parseInt(bola.getCor());
                }

                oLinha[iColuna] = this.getImagemBola(iCor);
            }

            tabela.addRow(oLinha);
        }

        if(view instanceof ViewSolucao) {
            trataCamposViewSolucao();
        }

        this.renderColumns(view);
        this.setTableConfigDefault(view);
    }

    private void trataCamposViewSolucao() {
        viewSolucao.setTextoLabelInformacao(" Profundidade: " + profundidade + "  Tempo Total: "+ tempoBusca + " ms  Noh atual: "  + profundidadeAtual);

        if(nohAtual == 0) {
            viewSolucao.getBtnInicio().setEnabled(true);
            viewSolucao.getBtnVoltar().setEnabled(true);
            viewSolucao.getBtnAvancar().setEnabled(false);
            viewSolucao.getBtnFinal().setEnabled(false);
        }
        else if(nohAtual == profundidade) {
            viewSolucao.getBtnInicio().setEnabled(false);
            viewSolucao.getBtnVoltar().setEnabled(false);
            viewSolucao.getBtnAvancar().setEnabled(true);
            viewSolucao.getBtnFinal().setEnabled(true);
        }
        else {
            viewSolucao.getBtnInicio().setEnabled(true);
            viewSolucao.getBtnVoltar().setEnabled(true);
            viewSolucao.getBtnAvancar().setEnabled(true);
            viewSolucao.getBtnFinal().setEnabled(true);
        }
    }

    private void resetAtributosSolucao() {
        caminhoSolucao.clear();
        fechaJanelaSolucao();
    }

    private void fechaJanelaSolucao() {
        if(viewSolucao instanceof ViewSolucao) {
            viewSolucao.dispose();
        }
    }

}