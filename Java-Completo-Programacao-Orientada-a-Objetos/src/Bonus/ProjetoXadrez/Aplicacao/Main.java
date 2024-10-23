package Bonus.ProjetoXadrez.Aplicacao;

import Bonus.ProjetoXadrez.Xadrez.PartidaXadrez;
import Bonus.ProjetoXadrez.Xadrez.PecaXadrez;
import Bonus.ProjetoXadrez.Xadrez.PosicaoXadrez;
import Bonus.ProjetoXadrez.Xadrez.XadrezException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PartidaXadrez partidaXadrez = new PartidaXadrez();

        while(true){
            try {
                UI.limparTela();
                UI.mostrarTabuleiro(partidaXadrez.getPecas());
                System.out.println();

                System.out.print("Origem: ");
                PosicaoXadrez origem = UI.lerPosicaoXadrez(s);

                boolean[][] movimentosPossiveis = partidaXadrez.movimentosPosiveis(origem);
                UI.limparTela();
                UI.mostrarTabuleiro(partidaXadrez.getPecas(), movimentosPossiveis);

                System.out.println();
                System.out.print("Destino: ");
                PosicaoXadrez destino = UI.lerPosicaoXadrez(s);

                PecaXadrez pecaCapturada = partidaXadrez.fazerMovimentoXadrez(origem, destino);
            } catch (XadrezException e){
                System.out.println(e.getMessage());
                s.nextLine();
            } catch (InputMismatchException e){
                System.out.println(e.getMessage());
                s.nextLine();
            }
        }

    }
}
