package HerancaEPolimorfismo.Exemplos.Exe01;

public class ContaPoupanca extends Conta{
    private double taxaJuros;

    public ContaPoupanca(){}

    public ContaPoupanca(Integer numero, String titular, Double saldo, double taxaJuros) {
        super(numero, titular, saldo);
        this.taxaJuros = taxaJuros;
    }

    public void atualizarSaldo(){
        saldo += saldo * taxaJuros;
    }


    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }
}
