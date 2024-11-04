package Semana01.EstruturaDeRepeticao.ExerciciosFor;

import java.util.Locale;
import java.util.Scanner;

public class Exe03 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i=0; i<n; i++) {

            double a = s.nextDouble();
            double b = s.nextDouble();
            double c = s.nextDouble();

            double media = (a * 2.0 + b * 3.0 + c * 5.0) / 10.0;

            System.out.printf("%.1f%n", media);
        }
    }
}
