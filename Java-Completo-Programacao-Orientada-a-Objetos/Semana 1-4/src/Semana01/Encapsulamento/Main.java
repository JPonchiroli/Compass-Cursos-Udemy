package Semana01.Encapsulamento;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ContaBancaria contaBancaria = null;

        System.out.print("Informe o numero da conta:");
        int numeroConta = s.nextInt();

        s.nextLine();

        System.out.print("Informe o nome do titular da conta: ");
        String nomeTitular = s.nextLine();

        System.out.print("Existe um depósito inicial? y/n: ");
        char resposta = s.next().charAt(0);

        if (resposta == 'y'){
            System.out.print("Informe valor do depósito inicial: ");
            double depositoInicial = s.nextDouble();

            contaBancaria = new ContaBancaria(numeroConta, nomeTitular, depositoInicial);
        } else {
            contaBancaria = new ContaBancaria(numeroConta, nomeTitular);
        }

        System.out.println(contaBancaria);

        System.out.println("Informe um valor para ser depositado");
        double deposito = s.nextDouble();
        contaBancaria.depositar(deposito);

        System.out.println(contaBancaria);

        System.out.println("Informe um valor para ser sacado");
        double saque = s.nextDouble();
        contaBancaria.sacar(saque);

        System.out.println(contaBancaria);
    }
}
