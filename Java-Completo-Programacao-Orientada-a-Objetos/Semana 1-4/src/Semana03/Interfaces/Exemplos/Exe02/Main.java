package Semana03.Interfaces.Exemplos.Exe02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        FormaAbstrata s1 = new Circulo(Cor.PRETO, 2.0);
        FormaAbstrata s2 = new Retangulo(Cor.AZUL, 5.0, 5.0);

        System.out.println("Cor Circulo: " + s1.getCor());
        System.out.println("Area Circulo: " + String.format("%.3f", s1.area()));
        System.out.println("Cor Retangulo: " + s2.getCor());
        System.out.println("Area Retangulo: " + String.format("%.3f", s2.area()));
    }
}
