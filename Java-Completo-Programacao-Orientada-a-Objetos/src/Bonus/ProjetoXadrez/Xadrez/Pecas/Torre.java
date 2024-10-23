package Bonus.ProjetoXadrez.Xadrez.Pecas;

import Bonus.ProjetoXadrez.JogoTabuleiro.Posicao;
import Bonus.ProjetoXadrez.JogoTabuleiro.Tabuleiro;
import Bonus.ProjetoXadrez.Xadrez.Cor;
import Bonus.ProjetoXadrez.Xadrez.PecaXadrez;

public class Torre extends PecaXadrez {

    public Torre(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
    }

    @Override
    public String toString() {
        return "T";
    }

    @Override
    public boolean[][] movimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];

        Posicao p  = new Posicao(0, 0);

        // Cima
        p.setValores(posicao.getLinha() - 1, posicao.getColuna());
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() - 1);
        }

        if (getTabuleiro().posicaoExiste(p) && existeUmaPecaDoOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Baixo
        p.setValores(posicao.getLinha() + 1, posicao.getColuna());
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() - 1);
        }

        if (getTabuleiro().posicaoExiste(p) && existeUmaPecaDoOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Esquerda
        p.setValores(posicao.getLinha(), posicao.getColuna() - 1);
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() - 1);
        }

        if (getTabuleiro().posicaoExiste(p) && existeUmaPecaDoOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }

        // Direita
        p.setValores(posicao.getLinha(), posicao.getColuna() + 1);
        while (getTabuleiro().posicaoExiste(p) && !getTabuleiro().temUmaPeca(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() - 1);
        }

        if (getTabuleiro().posicaoExiste(p) && existeUmaPecaDoOponente(p)){
            mat[p.getLinha()][p.getColuna()] = true;
        }


        return mat;
    }
}
