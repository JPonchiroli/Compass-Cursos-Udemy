package ArraysEListas.Array.TipoReferencia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double somaPreco = 0;

        System.out.print("Informe a qunatidade de casas do array: ");
        int n = s.nextInt();

        Produtos[] vectProdutos = new Produtos[n];

        for (int i = 0; i < vectProdutos.length; i++){
            s.nextLine();
            String nome = s.nextLine();
            double preco = s.nextDouble();
            vectProdutos[i] = new Produtos(nome, preco);
            somaPreco += vectProdutos[i].getPreco();
        }

        double media = somaPreco / n;

        System.out.printf("Média de preços %.2f%n", media);
    }
}
