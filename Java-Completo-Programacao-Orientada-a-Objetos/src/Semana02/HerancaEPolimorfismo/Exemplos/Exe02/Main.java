package Semana02.HerancaEPolimorfismo.Exemplos.Exe02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Funcionario> funcionarios = new ArrayList<>();

        System.out.print("Informe a quantidade de funcionários: ");
        int qtdFuncionarios = s.nextInt();

        for (int i = 1; i <= qtdFuncionarios; i++){
            System.out.println("Dados do funcionário #" + i);

            System.out.print("Terceirizado (y/n): ");
            char terceirizado = s.next().charAt(0);
            System.out.print("Nome: ");
            s.nextLine();
            String nome = s.nextLine();
            System.out.print("Horas: ");
            int horas = s.nextInt();
            System.out.print("Valor por hora: ");
            double valorPorHora = s.nextDouble();
            if (terceirizado == 'y'){
                System.out.print("Valor Adicional: ");
                double valorAdicional = s.nextDouble();
                new FuncionarioTerceirizado(nome, horas, valorPorHora, valorPorHora);
                funcionarios.add(new FuncionarioTerceirizado(nome, horas, valorPorHora, valorPorHora));
            } else {
                funcionarios.add(new Funcionario(nome, horas, valorPorHora));
            }
        }

        System.out.println();

        System.out.println("Pagamentos");
        for (Funcionario func: funcionarios){
            System.out.println(func.getNome() + " - R$" + String.format("%.2f", func.pagamento()));
        }
    }
}
