package Semana01.EstruturaDeRepeticao;

import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char resp = 's';

        do {
            System.out.println("Escreva a temperatura em Celsius");
            double C = s.nextDouble();
            double F = (9.0 * C) / (5.0 + 32.0);
            System.out.printf("Equivalente a Fahrenheit: %.1f%n", F);
            System.out.println("Deseja Repetir o Programa?");
            resp = s.next().charAt(0);
        } while(resp != 'n');
    }
}
