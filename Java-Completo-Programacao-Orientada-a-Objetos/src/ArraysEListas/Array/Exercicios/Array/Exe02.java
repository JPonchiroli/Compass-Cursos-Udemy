package ArraysEListas.Array.Exercicios.Array;

import java.util.Scanner;

public class Exe02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n, nMenores;
        double alturaTotal, alturaMedia, percentualMenores;

        System.out.print("Quantas pessoas serao digitadas? ");
        n = s.nextInt();

        String[] nomes = new String[n];
        int[] idades = new int[n];
        double[] alturas = new double[n];

        for (int i=0; i<n; i++) {
            System.out.printf("Dados da %da pessoa:\n", i + 1);
            System.out.print("Nome: ");
            nomes[i] = s.next();
            System.out.print("Idade: ");
            idades[i] = s.nextInt();
            System.out.print("Altura: ");
            alturas[i] = s.nextDouble();
        }

        nMenores = 0;
        alturaTotal = 0;
        for (int i=0; i<n; i++) {
            if (idades[i] < 16) {
                nMenores++;
            }
            alturaTotal = alturaTotal + alturas[i];
        }

        alturaMedia = alturaTotal / n;
        percentualMenores = ((double)nMenores / n) * 100.0;

        System.out.printf("\nAltura media = %.2f\n", alturaMedia);
        System.out.printf("Pessoas com menos de 16 anos: %.1f%%\n", percentualMenores);

        for(int i=0; i<n; i++) {
            if (idades[i] < 16) {
                System.out.printf("%s\n", nomes[i]);
            }
        }
    }
}
