package ProgramacaoFuncExpressoesLamb.Exercicios.Exe02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String caminho = "C:\\Users\\joaop\\OneDrive\\Área de Trabalho\\in.txt";


        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
            List<Funcionario> funcionarios = new ArrayList<>();
            String linha = br.readLine();

            while(linha != null){

                String[] campos = linha.split(",");
                funcionarios.add(new Funcionario(campos[0], campos[1], Double.parseDouble(campos[2])));
                linha = br.readLine();
            }

            System.out.print("Informe o salario: ");
            double salario = s.nextInt();

            System.out.println("Pessoas com o salario maior que " + salario);

            Comparator<String> comp = (s1,s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> emails = funcionarios.stream()
                    .filter(f -> f.getSalario() > salario)
                    .map(f -> f.getEmail())
                    .sorted(comp)
                    .toList();

            emails.forEach(System.out::println);

            double soma = funcionarios.stream()
                    .filter(f -> f.getNome().charAt(0) == 'M')
                    .map(f -> f.getSalario())
                    .reduce(0.0, (x, y) -> x + y);

            System.out.println("Salario dos funcionario que comecam com a letra M: " + soma);

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
