package ProjetoXadrez.Xadrez.Pecas;

import ProjetoXadrez.JogoTabuleiro.Tabuleiro;
import ProjetoXadrez.Xadrez.Cor;
import ProjetoXadrez.Xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

    public Torre(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString() {
        return "T";
    }
}
