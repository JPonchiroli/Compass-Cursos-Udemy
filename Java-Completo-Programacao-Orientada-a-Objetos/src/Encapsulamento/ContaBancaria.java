package Encapsulamento;

public class ContaBancaria {
    private int numeroConta;
    private String nomeTitular;
    private double saldo;
    private double depositoInicial;

    public ContaBancaria(int numeroConta, String nomeTitular, double depositoInicial) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = depositoInicial;
    }

    public ContaBancaria(int numeroConta, String nomeTitular){
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getDepositoInicial() {
        return depositoInicial;
    }

    public void setDepositoInicial(double depositoInicial) {
        this.depositoInicial = depositoInicial;
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public void sacar(double valor){
        int taxaSaque = 5;
        saldo -= valor;
        saldo -= taxaSaque;
    }

    @Override
    public String toString() {
        return "Dados da Conta: " + "\n" +
                "Numero Conta " + numeroConta +
                ", Nome Titular " + nomeTitular +
                ", Saldo: R$" + saldo;
    }
}
