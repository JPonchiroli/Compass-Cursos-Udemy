package ArraysEListas.Array.Exercicios;

import java.util.Scanner;

public class Exe01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Informe a qunatidade de casas do array: ");
        int n = s.nextInt();

        int[] vect = new int[n];

        for (int i = 0; i < vect.length; i++){
            vect[i] = s.nextInt();
        }

        System.out.println("Números Negativos");
        for (int i = 0; i < vect.length; i++){
            if(vect[i] < 0){
                System.out.println(vect[i]);
            }
        }
    }
}

