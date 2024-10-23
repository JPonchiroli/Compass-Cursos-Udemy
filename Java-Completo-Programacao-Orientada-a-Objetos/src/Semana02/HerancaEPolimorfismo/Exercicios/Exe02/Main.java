package HerancaEPolimorfismo.Exercicios.Exe02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();

        System.out.print("Informe o numero de pessoas: ");
        int qtdPessoas = s.nextInt();

        for (int i = 1; i <= qtdPessoas; i++){
            System.out.println("Pessoa #" + i);

            System.out.print("Pessoa Física ou Jurídica: ");
            char tipoPessoa = s.next().charAt(0);
            s.nextLine();
            System.out.print("Nome: ");
            String nome = s.nextLine();
            System.out.print("Renda Anual: ");
            double rendaAnual = s.nextDouble();

            if (tipoPessoa == 'f'){
                System.out.print("Gastos com saude: ");
                double gastosSaude = s.nextDouble();
                pessoas.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
            } else {
                System.out.print("Numero Funcionarios: ");
                int numeroFuncionarios = s.nextInt();
                pessoas.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
            }
        }

        System.out.println();

        System.out.println("Taxas a pagar");
        double taxasTotais = 0;
        for (Pessoa pessoa: pessoas){
            System.out.printf("%.2f%n", pessoa.calculoImposto());
            taxasTotais += pessoa.calculoImposto();
        }

        System.out.print("Taxas Totais: " + taxasTotais);
    }
}
