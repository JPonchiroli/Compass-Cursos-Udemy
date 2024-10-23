package HerancaEPolimorfismo.Exemplos.Exe01;

public final class ContaPoupanca extends Conta{
    private double taxaJuros;

    public ContaPoupanca(){}

    public ContaPoupanca(Integer numero, String titular, Double saldo, double taxaJuros) {
        super(numero, titular, saldo);
        this.taxaJuros = taxaJuros;
    }

    public void atualizarSaldo(){
        saldo += saldo * taxaJuros;
    }

    @Override
    public void sacar(double valor){
        saldo -= valor;
    }


    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }
}
