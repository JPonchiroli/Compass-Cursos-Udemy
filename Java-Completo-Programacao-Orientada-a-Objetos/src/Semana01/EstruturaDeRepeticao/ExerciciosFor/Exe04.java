package Semana01.EstruturaDeRepeticao.ExerciciosFor;

import java.util.Scanner;

public class Exe04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i=0; i<n; i++) {

            int x = s.nextInt();
            int y = s.nextInt();

            if (y == 0) {
                System.out.println("divisao impossivel");
            }
            else {
                double div = (double) x / y;
                System.out.printf("%.1f%n", div);
            }
        }
    }
}
