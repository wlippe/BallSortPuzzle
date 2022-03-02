package ProjetoEstrutura;

/**
 *
 * @author danie
 */
public class Tabuleiro {

    private Bola[][] bolas;
    private int qtdeColuna;

    public Tabuleiro(int qtdeColuna) {
       this.qtdeColuna = qtdeColuna;
       this.criaTabuleiro();
    }

    private void criaTabuleiro(){
        Bola[][] bola = new Bola[4][this.qtdeColuna];
        this.bolas = bola;
    }

    public Bola[][] getBolas() {
        return bolas;
    }

    public void setBolas(Bola[][] bolas) {
        this.bolas = bolas;
    }

    public Tabuleiro copiaTabuleiro(Tabuleiro tabuleiroOrigem, Bola bolaTroca, int linhaDestino, int colunaDestino){
        Tabuleiro novo = new Tabuleiro(tabuleiroOrigem.qtdeColuna);
        for(int x = 0; x < novo.qtdeColuna; x++){
            for(int y = 0; y < 4; y++){
                if(tabuleiroOrigem.getBolas()[y][x] != null){
                    Bola bolaOrigem = tabuleiroOrigem.getBolas()[y][x];
                    Bola newBolaCopia = new Bola(bolaOrigem.getCor(), y, x);
                    if(x == bolaTroca.getColuna() && y == bolaTroca.getLinha()){
                        novo.getBolas()[y][x] = null;
                    } else {
                        novo.getBolas()[y][x] = newBolaCopia;
                    }
                }
                if(x == colunaDestino && y == linhaDestino){
                    Bola newBola = new Bola(bolaTroca.getCor(),y, x);
                    novo.getBolas()[y][x] = newBola;                
                }
            }
        
        }

        return novo;
    }

    public int getQtdeColuna() {
        return qtdeColuna;
    }
    
    @Override
    public String toString() {
        String descricao = "\n";
        for(int i = 0; i < this.bolas.length; i++) {
            for(int j = 0; j < this.qtdeColuna; j++) {
                Bola bola = this.bolas[i][j];

                if(bola instanceof Bola) {
                    if(j==0){
                        descricao = descricao + bola.toString();
                    }
                     else {
                        descricao = descricao + "  " + bola.toString();
                     }
                }
                else {
                    if(j==0){
                        descricao = descricao + "0";
                    } 
                    else {
                        descricao = descricao + "  " + "0";
                    }
                }
            }

            descricao = descricao + "\n";
        }

        return descricao;
    }

}