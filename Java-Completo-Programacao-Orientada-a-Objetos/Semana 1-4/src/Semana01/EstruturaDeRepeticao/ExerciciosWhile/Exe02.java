package Semana01.EstruturaDeRepeticao.ExerciciosWhile;

import java.util.Scanner;

public class Exe02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int x = s.nextInt();
        int y = s.nextInt();

        while (x != 0 && y != 0) {
            if (x > 0 && y > 0) {
                System.out.println("primeiro");
            }
            else if (x < 0 && y > 0) {
                System.out.println("segundo");
            }
            else if (x < 0 && y < 0) {
                System.out.println("terceiro");
            }
            else {
                System.out.println("quarto");
            }
            x = s.nextInt();
            y = s.nextInt();
        }
    }
}
