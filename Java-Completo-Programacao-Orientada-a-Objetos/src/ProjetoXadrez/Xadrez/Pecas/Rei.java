package ProjetoXadrez.Xadrez.Pecas;

import ProjetoXadrez.JogoTabuleiro.Posicao;
import ProjetoXadrez.JogoTabuleiro.Tabuleiro;
import ProjetoXadrez.Xadrez.Cor;
import ProjetoXadrez.Xadrez.PecaXadrez;

public class Rei extends PecaXadrez {

    public Rei(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString() {
        return "R";
    }

    private boolean podeMover(Posicao posicao){
        PecaXadrez p = (PecaXadrez)getTabuleiro().peca(posicao);
        return p == null || p.getCor() != getCor();
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

        Posicao p = new Posicao(0,0);

        // Cima
        p.setValores(posicao.getLinha() - 1, posicao.getColuna());
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Baixo
        p.setValores(posicao.getLinha() + 1, posicao.getColuna());
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Esquerda
        p.setValores(posicao.getLinha(), posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Direta
        p.setValores(posicao.getLinha(), posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Diagonal Esquerda Cima
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Diagonal Direita Cima
        p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Diagonal Esquerda Baixo
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Diagonal Direita Baixo
        p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
        if (getTabuleiro().posicaoExiste(p) && podeMover(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }


        return mat;
    }
}
