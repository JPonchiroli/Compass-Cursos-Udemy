package Semana01.EstruturaDeRepeticao.ExerciciosFor;

import java.util.Scanner;

public class Exe01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int x = s.nextInt();

        for (int i=1; i<=x; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}
