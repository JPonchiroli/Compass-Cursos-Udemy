package ArraysEListas.Array;

import java.util.Scanner;

public class TipoValor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double somaAltura = 0;

        System.out.print("Informe a qunatidade de casas do array: ");
        int n = s.nextInt();

        double[] vect = new double[n];

        for (int i = 0; i < vect.length; i++){
            System.out.print("Informe a " + (i + 1) + "° altura: ");
            vect[i] = s.nextDouble();
            somaAltura += vect[i];
        }

        for (int i = 0; i < vect.length; i++){
            System.out.println(vect[i]);
        }

        double media = somaAltura / n;

        System.out.printf("Média Alturas: %.2f", media);
    }
}
