package Semana01.EstruturaDeRepeticao.ExerciciosFor;

import java.util.Scanner;

public class Exe02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int in = 0;
        int out = 0;

        for (int i=0; i<n; i++) {
            int x = s.nextInt();
            if (x >= 10 && x <= 20) {
                in = in + 1;
            }
            else {
                out = out + 1;
            }
        }

        System.out.println(in + " in");
        System.out.println(out + " out");
    }
}
