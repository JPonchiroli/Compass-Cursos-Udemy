package ProjetoXadrez.Xadrez;

import ProjetoXadrez.JogoTabuleiro.Tabuleiro;
import ProjetoXadrez.Xadrez.Pecas.Rei;
import ProjetoXadrez.Xadrez.Pecas.Torre;

public class PartidaXadrez {
    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8,8);
        setupInicial();
    }

    public PecaXadrez[][] getPecas(){
        PecaXadrez[][] mat = new PecaXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];

        for (int i = 0; i < tabuleiro.getLinhas(); i++){
            for (int j = 0; j < tabuleiro.getColunas(); j++){
                mat[i][j] = (PecaXadrez) tabuleiro.peca(i,j);
            }
        }

        return mat;
    }

    private void colocarNovaPeca(char coluna, int linha, PecaXadrez peca){
        tabuleiro.colocarPeca(peca, new PosicaoXadrez(coluna, linha).paraPosicao());
    }

    private void setupInicial(){
        colocarNovaPeca('a',8,new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('h',8,new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e',8,new Rei(tabuleiro, Cor.PRETO));

        colocarNovaPeca('a',1,new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('h',1,new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e',1,new Rei(tabuleiro, Cor.BRANCO));

    }
}
