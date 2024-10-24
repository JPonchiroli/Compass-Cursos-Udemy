package Bonus.ProjetoXadrez.Xadrez;

import Bonus.ProjetoXadrez.JogoTabuleiro.Posicao;

public class PosicaoXadrez {
    private char coluna;
    private int linha;

    public PosicaoXadrez(char coluna, int linha) {
        if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
            throw new XadrezException("Erros Instanciando PosicaoXadrez: Valores validos sao de a1 a h8");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    public char getColuna() {
        return coluna;
    }


    public int getLinha() {
        return linha;
    }

    protected Posicao paraPosicao() {
        return new Posicao(8 - linha, coluna - 'a');
    }

    protected static PosicaoXadrez dePosicao(Posicao posicao){
        return new PosicaoXadrez((char)('a' - posicao.getColuna()), 8 - posicao.getLinha());
    }

    @Override
    public String toString() {
        return "" + coluna + linha;
    }
}
