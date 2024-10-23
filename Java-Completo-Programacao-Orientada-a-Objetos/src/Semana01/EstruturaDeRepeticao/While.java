package EstruturaDeRepeticao;

import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int numero = s.nextInt();
        int soma = 0;

        while (numero != 0) {
            numero = s.nextInt();
            soma += numero;
        }

        System.out.println(soma);
    }
}
