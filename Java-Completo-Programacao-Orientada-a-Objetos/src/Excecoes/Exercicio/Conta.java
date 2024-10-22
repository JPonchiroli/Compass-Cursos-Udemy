package Excecoes.Exercicio;


import java.util.Objects;

public class Conta {
    private long numeroConta;
    private String titularConta;
    private double saldo;
    private double limiteSaque;

    public Conta(){}

    public Conta(long numeroConta, String titularConta, double saldo, double limiteSaque) {
        this.numeroConta = numeroConta;
        this.titularConta = titularConta;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public void deposito(double valor){
        saldo += valor;
    }

    public void saque(double valor) throws SaqueException {
        if(valor > getLimiteSaque()){
            throw new SaqueException("Valor de saque superior ao limite");
        }

        if(valor > getSaldo()){
            throw new SaqueException("Valor de saque superior ao saldo da conta");
        }

        saldo -= valor;
    }

    public long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitularConta() {
        return titularConta;
    }

    public void setTitularConta(String titularConta) {
        this.titularConta = titularConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }
}
