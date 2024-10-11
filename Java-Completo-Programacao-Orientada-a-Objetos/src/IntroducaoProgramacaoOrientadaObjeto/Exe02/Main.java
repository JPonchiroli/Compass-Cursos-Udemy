package IntroducaoProgramacaoOrientadaObjeto.Exe02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Empregado empregado = new Empregado();

        System.out.print("Nome: ");
        empregado.nome = s.nextLine();

        System.out.print("Salário Bruto: ");
        empregado.salarioBruto = s.nextDouble();

        System.out.print("Imposto: ");
        empregado.imposto = s.nextDouble();

        empregado.salarioLiquido();

        System.out.println(empregado);

        System.out.print("Qual a porcentagem de aumento do salário: ");
        double porcentagem = s.nextDouble();

        empregado.aumentarSalario(porcentagem);

        System.out.println(empregado);
    }
}
