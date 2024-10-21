package ProjetoXadrez.Xadrez;

import ProjetoXadrez.JogoTabuleiro.Peca;
import ProjetoXadrez.JogoTabuleiro.Posicao;
import ProjetoXadrez.JogoTabuleiro.Tabuleiro;
import ProjetoXadrez.Xadrez.Pecas.Rei;
import ProjetoXadrez.Xadrez.Pecas.Torre;

public class PartidaXadrez {
    private int turno;
    private Cor jogadorAtual;
    private Tabuleiro tabuleiro;

    public PartidaXadrez() {
        tabuleiro = new Tabuleiro(8,8);
        turno = 1;
        jogadorAtual = Cor.BRANCO;
        setupInicial();
    }

    public int getTurno() {
        return turno;
    }

    public Cor getJogadorAtual() {
        return jogadorAtual;
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

    public boolean[][] movimentosPosiveis(PosicaoXadrez posicaoOrigem){
        Posicao posicao = posicaoOrigem.paraPosicao();
        validarPosicaoOrigem(posicao);
        return tabuleiro.peca(posicao).movimentosPossiveis();
    }

    public PecaXadrez fazerMovimentoXadrez(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino){
        Posicao origem = posicaoOrigem.paraPosicao();
        Posicao destino = posicaoDestino.paraPosicao();
        validarPosicaoOrigem(origem);
        validarPosicaoDestino(origem, destino);
        Peca pecaCapturada = fazerMovimento(origem, destino);
        proximoTurno();
        return (PecaXadrez)pecaCapturada;
    }

    private Peca fazerMovimento(Posicao origem, Posicao destino){
        Peca p = tabuleiro.removerPeca(origem);
        Peca pecaCapturada = tabuleiro.removerPeca(destino);
        tabuleiro.colocarPeca(p, destino);
        return pecaCapturada;
    }


    private void validarPosicaoOrigem(Posicao posicao){
        if(!tabuleiro.temUmaPeca(posicao)){
            throw new XadrezException("Não existe peca na posicao de origem");
        }
        if(jogadorAtual != ((PecaXadrez)tabuleiro.peca(posicao)).getCor()){
            throw new XadrezException("A peça escolhida nao e sua");
        }
        if(!tabuleiro.peca(posicao).existeUmMovimentoPossivel()){
            throw new XadrezException("Não existe movimentos possiveis para peca escolhida");
        }
    }

    private void validarPosicaoDestino(Posicao origem, Posicao destino){
        if (!tabuleiro.peca(origem).movimentoPossivel(destino)){
            throw new XadrezException("A peca escolhida nao pode se mover para posicao de destino");
        }
    }

    private void proximoTurno(){
        turno++;
        jogadorAtual = (jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
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
