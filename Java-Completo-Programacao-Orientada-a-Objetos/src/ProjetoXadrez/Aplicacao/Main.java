package ProjetoXadrez.Aplicacao;

import ProjetoXadrez.Xadrez.PartidaXadrez;

public class Main {
    public static void main(String[] args) {
        PartidaXadrez partidaXadrez = new PartidaXadrez();

        UI.mostrarTabuleiro(partidaXadrez.getPecas());
    }
}
