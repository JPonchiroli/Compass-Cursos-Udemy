package EstruturaCondicional.Exercicios;

import java.util.Scanner;

public class Exe04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int horaInicial = s.nextInt();
        int horaFinal = s.nextInt();

        int duracao;
        if (horaInicial < horaFinal) {
            duracao = horaFinal - horaInicial;
        }
        else {
            duracao = 24 - horaInicial + horaFinal;
        }

        System.out.println("O JOGO DUROU " + duracao + " HORA(S)");
    }
}
