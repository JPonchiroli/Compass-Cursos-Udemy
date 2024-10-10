package EstruturaDeRepeticao.ExerciciosFor;

import java.util.Scanner;

public class Exe05 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int fat = 1;
        for (int i=1; i<=n; i++) {
            fat = fat * i;
        }

        System.out.println(fat);
    }
}
