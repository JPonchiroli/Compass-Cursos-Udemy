package ProjetoXadrez.xadrez;

import ProjetoXadrez.JogoTabuleiro.Peca;
import ProjetoXadrez.JogoTabuleiro.Tabuleiro;

public class PecaXadrez extends Peca {
    private Cor cor;

    public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro);
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }
}
