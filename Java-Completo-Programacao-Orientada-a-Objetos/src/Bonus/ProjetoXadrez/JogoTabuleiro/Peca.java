package Bonus.ProjetoXadrez.JogoTabuleiro;

public abstract class Peca {
    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(){}

    public Peca(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        this.posicao = null;
    }

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public abstract boolean[][] movimentosPossiveis();

    public boolean movimentoPossivel(Posicao posicao){
        return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()];
    }

    public boolean existeUmMovimentoPossivel(){
        boolean[][] mat = movimentosPossiveis();

        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat.length; j++){
                if(mat[i][j]){
                    return true;
                }
            }
        }

        return false;
    }

}
