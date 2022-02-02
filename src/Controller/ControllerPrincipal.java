package Controller;

import java.io.File;
import javax.swing.JTable;
import javax.swing.JLabel;
import View.ViewPrincipal;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.io.BufferedReader;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.FileNotFoundException;
import javax.swing.table.DefaultTableModel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Controlador principal do Projeto de Algoritmos e Estruturas de Dados   
 * @package Controller
 * @author Walter Felipe Bachmann
 * @since Dezembro/2021
 */
public class ControllerPrincipal {

    private ViewPrincipal view;

    public ControllerPrincipal(ViewPrincipal view) {
        this.view = view;
    }

    public ImageIcon getImagemBola(String nome) {
        switch (nome) {
            case "vermelho"   : return new ImageIcon(getClass().getResource("/View/imagens/vermelho.png"));
            case "amarelo"    : return new ImageIcon(getClass().getResource("/View/imagens/amarelo.png"));
            case "azul"       : return new ImageIcon(getClass().getResource("/View/imagens/azul.png"));
            case "azul_bebe"  : return new ImageIcon(getClass().getResource("/View/imagens/azul_bebe.png"));
            case "verde"      : return new ImageIcon(getClass().getResource("/View/imagens/verde.png"));
            case "verde_claro": return new ImageIcon(getClass().getResource("/View/imagens/verde_claro.png"));
            case "laranja"    : return new ImageIcon(getClass().getResource("/View/imagens/laranja.png"));
            case "roxo"       : return new ImageIcon(getClass().getResource("/View/imagens/roxo.png"));
            case "roxo_forte" : return new ImageIcon(getClass().getResource("/View/imagens/roxo_forte.png"));
            case "rosa"       : return new ImageIcon(getClass().getResource("/View/imagens/rosa.png"));
            case "vinho"      : return new ImageIcon(getClass().getResource("/View/imagens/vinho.png"));
            case "cinza"      : return new ImageIcon(getClass().getResource("/View/imagens/cinza.png"));
            default           : return null;
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
        int numeroColunas = 0;
        try {
            this.setTableConfigDefault();
            this.resetTabela();

            DefaultTableModel tabela = (DefaultTableModel) view.getTableTubosEnsaio().getModel();

            FileReader     leitorArq   = new FileReader(arq);
            BufferedReader leitorTexto = new BufferedReader(leitorArq);

            for(int i = 0; i < 4; i++) {
                String linha = leitorTexto.readLine(); 

                String[] valoresLinha = linha.split(", ");

                numeroColunas = valoresLinha.length + 2;

                Object oLinha[] = new Object[numeroColunas];

                for(int j = 0; j < valoresLinha.length; j++) {
                    if(i==0) {
                        tabela.addColumn("");
                    }
                    ImageIcon imagemBola = this.getImagemBola(valoresLinha[j]);
                    oLinha[j] = imagemBola;
                }
                oLinha[valoresLinha.length]   = null;
                oLinha[valoresLinha.length+1] = null;

                tabela.addRow(oLinha);
            }

            tabela.addColumn("");
            tabela.addColumn("");

            this.renderColumns(numeroColunas-2);
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo nao encontrado");
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo");
        }
    }

    private void setTableConfigDefault() {
        JTable tabelaTuboEnsaio = view.getTableTubosEnsaio();
        tabelaTuboEnsaio.setBackground(new java.awt.Color(255, 255, 255));
        tabelaTuboEnsaio.setColumnSelectionAllowed(false);
        tabelaTuboEnsaio.setRequestFocusEnabled(false);
        tabelaTuboEnsaio.setRowSelectionAllowed(false);
        tabelaTuboEnsaio.getTableHeader().setUI(null);
        tabelaTuboEnsaio.setDragEnabled(false);
        tabelaTuboEnsaio.setAutoscrolls(false);
        tabelaTuboEnsaio.setRowHeight(62);
    }

    /* Remove as linhas e colunas da tabela */
    private void resetTabela() {
        DefaultTableModel tabela = (DefaultTableModel) view.getTableTubosEnsaio().getModel();
        tabela.setColumnCount(0);
        while(tabela.getRowCount() > 0){
            tabela.removeRow(0);
        }
    }

    /* Renderiza as imagens nas colunas utilizando o Controlador */
    private void renderColumns(int numeroColunas) {
        ControllerCellRender render = new ControllerCellRender();
        render.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < numeroColunas; i++) {
            view.getTableTubosEnsaio().getColumnModel().getColumn(i).setCellRenderer(render);
        }
    }

    /* @todo Ajustar*/
    public void setValor(Object aValue, int row, int column) {
        DefaultTableModel tabela = (DefaultTableModel) view.getTableTubosEnsaio().getModel();
        tabela.setValueAt(aValue, row, column);
        this.renderColumns(tabela.getColumnCount());
    }

}