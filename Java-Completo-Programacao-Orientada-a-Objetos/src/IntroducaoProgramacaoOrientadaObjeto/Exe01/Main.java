package IntroducaoProgramacaoOrientadaObjeto.Exe01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Retangulo retangulo = new Retangulo();

        System.out.println("Informe a altura do retângulo");
        retangulo.altura = s.nextDouble();

        System.out.println("Informe a largura do retângulo");
        retangulo.largura = s.nextDouble();

        System.out.println(retangulo.area());
        System.out.println(retangulo.perimetro());
        System.out.println(retangulo.diagonal());
    }
}
