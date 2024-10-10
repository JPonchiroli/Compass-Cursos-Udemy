package EstruturaCondicional.Exercicios;

import java.util.Scanner;

public class Exe03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int A, B;

        A = s.nextInt();
        B = s.nextInt();

        if (A % B == 0 || B % A == 0) {
            System.out.println("Sao Multiplos");
        }
        else {
            System.out.println("Nao sao Multiplos");
        }
    }
}
