package IntroducaoProgramacaoOrientadaObjeto.Exe04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Qual é o preço do dólar: ");
        double precoDolar = s.nextDouble();

        System.out.print("Quantos dólares você quer comprar: ");
        double qtdDolar = s.nextDouble();

        System.out.print("Preço em reais: " + ConversorMoeda.converterDolarParaReais(precoDolar, qtdDolar));
    }
}
