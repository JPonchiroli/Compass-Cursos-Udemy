package Semana01.ArraysEListas.Matriz;

import java.util.Scanner;

public class Matriz {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[][] mat = new int[n][n];
        int numerosNegativos = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                mat[i][j] = s.nextInt();
                if(mat[i][j] < 0){
                    numerosNegativos++;
                }
            }
        }

        System.out.println("Diagonal Principal");
        for (int i = 0; i < n; i++){
            System.out.println(mat[i][i] + " ");
        }
        System.out.println();

        System.out.print("Numeros Negativos: " + numerosNegativos);
    }
}
