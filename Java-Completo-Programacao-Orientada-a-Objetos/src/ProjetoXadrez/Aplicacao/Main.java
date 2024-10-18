package ProjetoXadrez.Aplicacao;

import ProjetoXadrez.JogoTabuleiro.Posicao;
import ProjetoXadrez.JogoTabuleiro.Tabuleiro;
import ProjetoXadrez.xadrez.PartidaXadrez;

public class Main {
    public static void main(String[] args) {
        PartidaXadrez partidaXadrez = new PartidaXadrez();

        UI.mostrarTabuleiro(partidaXadrez.getPecas());
    }
}
