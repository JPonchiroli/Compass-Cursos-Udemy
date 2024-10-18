package ProjetoXadrez.Aplicacao;

import ProjetoXadrez.Xadrez.PartidaXadrez;
import ProjetoXadrez.Xadrez.PecaXadrez;
import ProjetoXadrez.Xadrez.PosicaoXadrez;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PartidaXadrez partidaXadrez = new PartidaXadrez();

        while(true){
            UI.mostrarTabuleiro(partidaXadrez.getPecas());
            System.out.println();

            System.out.print("Origem: ");
            PosicaoXadrez origem = UI.lerPosicaoXadrez(s);

            System.out.println();
            System.out.print("Destino: ");
            PosicaoXadrez destino = UI.lerPosicaoXadrez(s);

            PecaXadrez pecaCapturada = partidaXadrez.fazerMovimentoXadrez(origem, destino);
        }

    }
}
