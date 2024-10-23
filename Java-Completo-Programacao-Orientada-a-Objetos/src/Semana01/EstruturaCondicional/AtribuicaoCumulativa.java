package Semana01.EstruturaCondicional;

import java.util.Scanner;

public class AtribuicaoCumulativa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int minutos = s.nextInt();

        double conta = 50.0;

        if(minutos > 100){
            conta += (minutos - 100) * 2;
        }

        System.out.printf("Valor conta = R$ %.2f%n", conta);
    }
}
