package Semana02.Excecoes.Exercicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        try{
            System.out.println("Informe os dados da conta");
            System.out.print("Número: ");
            long numeroConta = s.nextLong();
            System.out.print("Titular: ");
            s.nextLine();
            String titularConta = s.nextLine();
            System.out.print("Saldo Inicial: ");
            double saldoInicial = s.nextDouble();
            System.out.print("Limite de Depósito: ");
            double limiteDeposito = s.nextDouble();

            Conta conta = new Conta(numeroConta, titularConta, saldoInicial, limiteDeposito);

            System.out.print("Informe um valor para ser sacado: ");
            double valor = s.nextDouble();

            conta.saque(valor);
        } catch (SaqueException e){
            System.out.println("Erro no Saque: " + e);
        } catch (RuntimeException e){
            System.out.println("Erro inesperado");
        }
    }
}
