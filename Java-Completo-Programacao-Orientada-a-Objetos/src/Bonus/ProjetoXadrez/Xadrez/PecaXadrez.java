package Bonus.ProjetoXadrez.Xadrez;

import Bonus.ProjetoXadrez.JogoTabuleiro.Peca;
import Bonus.ProjetoXadrez.JogoTabuleiro.Posicao;
import Bonus.ProjetoXadrez.JogoTabuleiro.Tabuleiro;

public abstract class PecaXadrez extends Peca {
    private Cor cor;

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    protected boolean existeUmaPecaDoOponente(Posicao posicao){
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p != null && p.getCor() != cor;
    }
}
