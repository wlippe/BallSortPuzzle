package ProjetoEstrutura;

import ProjetoEstrutura.Bola;
import ProjetoEstrutura.Tabuleiro;
import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Estado;
import busca.Nodo;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author danie
 */
public class Jogo implements Estado {

    public Tabuleiro tabuleiro;
    private int qtdColuna;

    public Jogo() { }

    public Jogo(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        this.qtdColuna = tabuleiro.getQtdeColuna();
    }

    public Jogo(int tipo, Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        this.qtdColuna = tabuleiro.getQtdeColuna();
        if(tipo == 1){
            this.criaBolas();
        } 
    }

    private void criaBolas(){
        /* Quantidade de cores a serem criadas*/
        int qtdCor = this.qtdColuna - 2;
        /* Quais cores serão utilizadas*/
        String[] cores = new String[qtdCor];
        /* Adiciona as cores que serão utilizadas */
        for (int a = 0; a < qtdCor; a++){
            cores[a] = this.cores()[a];
        }
        for(int x = 0; x < qtdCor; x++){
            for (int y = 0; y < 4; y++){
                String corDisponivel = this.corDisponivel(cores);
                Bola bola = new Bola(corDisponivel, y, x);
                this.tabuleiro.getBolas()[y][x] = bola;
            }
        }      
    }

    private String corDisponivel(String[] cor){
        embaralhar(cor);
        int quantidade = 0;
        for(int x = 0; x < this.qtdColuna; x++){
            for(int y = 0; y < 4; y++){
                if(this.tabuleiro.getBolas()[y][x] != null){
                    if(this.tabuleiro.getBolas()[y][x].getCor().equals(cor[0])){
                        quantidade ++;
                    }                   
                }
                if(quantidade == 4){
                    quantidade = 0;
                    this.corDisponivel(cor);
                }                
            }
        }

        return cor[0];
    }

    public static void embaralhar(String[] a){
        Random ran = new Random();

        for(int i = 0; i < a.length; i++){
          int pos = ran.nextInt(a.length);
          String temp = a[i];
          a[i] = a[pos];
          a[pos] = temp;
        }
    }

    private String[] cores(){
        String[] cores = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        return cores;
    }

    @Override
    public String getDescricao() {
        return null;
    }

    @Override
    public boolean ehMeta() {
         for(int x = 0; x < this.qtdColuna; x++){
            if(possuiBola(x)){
                if(contaBolasColuna(x) == 4){
                    if(todasBolasMesmaCor(x)){
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                } 
            }
        }

        return true;
    }

    @Override
    public int custo() {
        return 1;
    }

    @Override
    public List<Jogo> sucessores() {
        List<Jogo> suc = new LinkedList<>();
        
        for(int x = 0; x < this.qtdColuna; x++){
            if(possuiBola(x)){
                Bola bolaX =  this.buscaUltimaBola(x);
                for(int y = 0; y < this.qtdColuna; y++){
                    boolean mesmaColuna = x == y;
                    if(mesmaColuna){
                        continue;
                    }
                    if(possuiBola(y)){
                        if(todasBolasMesmaCor(y)){
                            if(contaBolasColuna(y) == 4){
                                continue;
                            }                         
                            Bola bolaY = this.buscaUltimaBola(y);
                            if(!bolaX.getCor().equals(bolaY.getCor())){
                                continue;
                            } 
                            Jogo novo = new Jogo(2,this.tabuleiro.copiaTabuleiro(this.tabuleiro, bolaX, linhaEmpilhar(y), y));
                            suc.add(novo);

                        } else {
                            if(contaBolasColuna(y) == 4){
                                continue;
                            }
                            Bola bolaY = this.buscaUltimaBola(y);
                            if(bolaX.getCor().equals(bolaY.getCor())){
                                Jogo novo = new Jogo(2,this.tabuleiro.copiaTabuleiro(this.tabuleiro, bolaX, linhaEmpilhar(y), y));
                                suc.add(novo);
                            } 
                        }                    
                    } 
                    else {
                        Tabuleiro novoTab = this.tabuleiro.copiaTabuleiro(this.tabuleiro, bolaX, linhaEmpilhar(y), y);
                        Jogo novo = new Jogo(2,novoTab);
                        suc.add(novo);
                    }
                }
            }            
        }

        return suc;        
    }

    @Override
    public String toString() {
        return this.tabuleiro.toString();
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Jogo outro = (Jogo) obj;
        for(int x = 0; x < this.qtdColuna; x++){
            for(int y = 0; y < 4; y++){
                Bola bolaX = this.tabuleiro.getBolas()[y][x];
                Bola bolaY = outro.tabuleiro.getBolas()[y][x];

                if(bolaX == null && bolaY == null){
                    continue;
                }

                if(bolaX == null || bolaY == null){
                    return false;
                }

                if(bolaX.getColuna()!= bolaY.getColuna() || bolaX.getLinha()!= bolaY.getLinha() || !bolaX.getCor().equals(bolaY.getCor())){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean todasBolasMesmaCor(int coluna){
        Bola[][] bolas = this.tabuleiro.getBolas();
        int qtdBolas = contaBolasColuna(coluna);
        String corBolaCima = null;
        if(qtdBolas != 1){
            int qtdLoop = qtdBolas - 1;
            for(int x = 3 ; x >= 0; x--){
                if(x != 0 && qtdLoop != 0){
                    if(corBolaCima == null){
                        corBolaCima = bolas[x][coluna].getCor();
                    }
                    String corBolaAbaixo = bolas[x-1][coluna].getCor();
                    if(corBolaCima.equals(corBolaAbaixo)){
                        corBolaCima = corBolaAbaixo;
                    } else {
                        return false;
                    }
                    qtdLoop--;
                }
            }
        }

        return true;
    }

    private boolean possuiBola(int coluna){
        return this.tabuleiro.getBolas()[3][coluna] != null;
    }

    private Bola buscaUltimaBola(int coluna){
        Bola[][] bolas = this.tabuleiro.getBolas();
        Bola ultimaBola = null;
        for(int x = 3; x >= 0; x--){
            if(bolas[x][coluna] != null){
                ultimaBola = bolas[x][coluna];
            } else {
                return ultimaBola;
            }
        }

        return ultimaBola;
    }

    private int contaBolasColuna(int coluna){
        Bola[][] bolas = this.tabuleiro.getBolas();
        int qtdBola = 0;
        for(int x = 0; x < 4; x++){
            if(bolas[x][coluna] != null){
                qtdBola++;
            }
        }

        return qtdBola;    
    }

    public int linhaEmpilhar(int coluna) {
        int quantidadeBolas = contaBolasColuna(coluna);
        if(quantidadeBolas == 3) {
            return 0;
        }
        if(quantidadeBolas == 2) {
            return 1;
        }
        if(quantidadeBolas == 1) {
            return 2;
        }
        return 3;
    }

    public static void main(String[] args) throws Exception {
        Jogo newGame = new Jogo(1, new Tabuleiro(6));
 
        System.out.println("busca em largura");
        BuscaLargura<Jogo> bLarg = new BuscaLargura<Jogo>();
        Nodo n = bLarg.busca(newGame);

        if (n == null) {
            System.out.println("sem solucao!");
        } else {
            System.out.println(n.getProfundidade());
            Nodo w = n;
            while (w != null) {
                Jogo th = (Jogo)w.getEstado();
                System.out.println(th.tabuleiro);
                w = w.getPai();
            }
            System.out.println("solucao:\n" + n.montaCaminho() + "\n\n");        
        }
    }

    public Nodo buscaLargura(Tabuleiro tabuleiro) {
        Jogo newGame = new Jogo(tabuleiro);

        System.out.println("busca em largura");

        Nodo n = new BuscaLargura<Jogo>().busca(newGame);

        imprimeResultado(n);
        
        return n;
    }

    public Nodo buscaProfundidade(Tabuleiro tabuleiro) throws Exception {
        Jogo newGame = new Jogo(tabuleiro);

        System.out.println("busca em profundidade");

        Nodo n = new BuscaProfundidade<Jogo>().busca(newGame);

        imprimeResultado(n);

        return n;
    }

    public static void imprimeResultado(Nodo n) {
        if (n == null) {
            System.out.println("sem solucao!");
        } 
        else {
            System.out.println(n.getProfundidade());

            Nodo w = n;

            while (w != null) {
                Jogo th = (Jogo)w.getEstado();
                System.out.println(th.tabuleiro);
                w = w.getPai();
            }

            System.out.println("solucao:\n" + n.montaCaminho() + "\n\n");
        }
    }

}
