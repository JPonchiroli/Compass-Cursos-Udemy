package IntroducaoProgramacaoOrientadaObjeto.Exe03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Aluno aluno = new Aluno();

        System.out.print("Infome o nome do aluno: ");
        aluno.nome = s.nextLine();

        System.out.print("Infome a primeira nota do " + aluno.nome + ": ");
        aluno.primeiraNota = s.nextDouble();

        System.out.print("Infome o segunda nota do " + aluno.nome + ": ");
        aluno.segundaNota = s.nextDouble();

        System.out.print("Infome o terceira nota do " + aluno.nome + ": ");
        aluno.terceiraNota = s.nextDouble();

        System.out.println("Média Final: " + aluno.somaNota());
        aluno.situacao();
    }
}
