package Semana03.GenericsSetMap.Exercicios.Exe02;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<Aluno> alunos = new HashSet<>();

        System.out.print("Quantos alunos existem na turma A? ");
        int qtdAlunosA = s.nextInt();
        for (int i = 0; i < qtdAlunosA; i++){
            int codigoAluno = s.nextInt();
            alunos.add(new Aluno(codigoAluno));
        }

        System.out.print("Quantos alunos existem na turma B? ");
        int qtdAlunosB = s.nextInt();
        for (int i = 0; i < qtdAlunosB; i++){
            int codigoAluno = s.nextInt();
            alunos.add(new Aluno(codigoAluno));
        }

        System.out.print("Quantos alunos existem na turma C? ");
        int qtdAlunosC = s.nextInt();
        for (int i = 0; i < qtdAlunosC; i++){
            int codigoAluno = s.nextInt();
            alunos.add(new Aluno(codigoAluno));
        }

        System.out.println("Total Alunos: " + alunos.size());
    }
}
