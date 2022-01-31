package Controller;

import java.io.File;
import View.ViewPrincipal;
import java.io.FileReader;
import javax.swing.JLabel;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.io.BufferedReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
    private ImageIcon bolaVermelha;
    private ImageIcon bolaAmarela;
    private ImageIcon bolaAzul;
    private ImageIcon bolaAzulBebe;
    private ImageIcon bolaVerde;
    private ImageIcon bolaVerdeClaro;
    private ImageIcon bolaLaranja;
    private ImageIcon bolaRoxa;
    private ImageIcon bolaRoxoForte;
    private ImageIcon bolaRosa;
    private ImageIcon bolaVinho;
    private ImageIcon bolaCinza;

    public ControllerPrincipal(ViewPrincipal view) {
        this.view = view;
        this.loadImageIcons();
    }

    private void loadImageIcons() {
        this.bolaVermelha   = new ImageIcon(getClass().getResource("/View/imagens/vermelho.png"));
        this.bolaAmarela    = new ImageIcon(getClass().getResource("/View/imagens/amarelo.png"));
        this.bolaAzul       = new ImageIcon(getClass().getResource("/View/imagens/azul.png"));
        this.bolaAzulBebe   = new ImageIcon(getClass().getResource("/View/imagens/azul_bebe.png"));
        this.bolaVerde      = new ImageIcon(getClass().getResource("/View/imagens/verde.png"));
        this.bolaVerdeClaro = new ImageIcon(getClass().getResource("/View/imagens/verde_claro.png"));
        this.bolaLaranja    = new ImageIcon(getClass().getResource("/View/imagens/laranja.png"));
        this.bolaRoxa       = new ImageIcon(getClass().getResource("/View/imagens/roxo.png"));
        this.bolaRoxoForte  = new ImageIcon(getClass().getResource("/View/imagens/roxo_forte.png"));
        this.bolaRosa       = new ImageIcon(getClass().getResource("/View/imagens/rosa.png"));
        this.bolaVinho      = new ImageIcon(getClass().getResource("/View/imagens/vinho.png"));
        this.bolaCinza      = new ImageIcon(getClass().getResource("/View/imagens/cinza.png"));
    }

    public void renderTableTubosEnsaioVazios() {
        view.getTableTubosEnsaio().setBackground(new java.awt.Color(255, 255, 255));
        view.getTableTubosEnsaio().setColumnSelectionAllowed(false);
        view.getTableTubosEnsaio().setRequestFocusEnabled(false);
        view.getTableTubosEnsaio().setRowSelectionAllowed(false);
        view.getTableTubosEnsaio().getTableHeader().setUI(null);
        view.getTableTubosEnsaio().setDragEnabled(false);
        view.getTableTubosEnsaio().setAutoscrolls(false);
        view.getTableTubosEnsaio().setRowHeight(62);
    }

    private ImageIcon getImagemBola(String nome) {
        switch (nome) {
            case "vermelho":
                return bolaVermelha;
            case "amarelo":
                return bolaAmarela;
            case "azul":
                return bolaAzul;
            case "azul_bebe":
                return bolaAzulBebe;
            case "verde":
                return bolaVerde;
            case "verde_claro":
                return bolaVerdeClaro;
            case "laranja":
                return bolaLaranja;
            case "roxo":
                return bolaRoxa;
            case "roxo_forte":
                return bolaRoxoForte;
            case "rosa":
                return bolaRosa;
            case "vinho":
                return bolaVinho;
            case "cinza":
                return bolaCinza;
            default:
                return null;
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

        try {
            this.renderTableTubosEnsaioVazios();

            ControllerCellRender render = new ControllerCellRender();

            render.setHorizontalAlignment(JLabel.CENTER);
            
            DefaultTableModel modelo = (DefaultTableModel) view.getTableTubosEnsaio().getModel();

            FileReader     leitorArq   = new FileReader(arq);
            BufferedReader leitorTexto = new BufferedReader(leitorArq);

            for(int i = 0; i < 4; i++) {
                String linha = leitorTexto.readLine();

                String[] valoresLinha = linha.split(", ");

                int numeroColunas = valoresLinha.length + 2;

                for(int j = 0; j < numeroColunas; j++) {
                    ImageIcon imagemBola = this.getImagemBola(valoresLinha[j]);

                    view.getTableTubosEnsaio().getColumnModel().getColumn(j).setCellRenderer(render);

                    modelo.setValueAt(imagemBola, i, j);
                }
            }
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo nao encontrado");
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo");
        }
    }
}