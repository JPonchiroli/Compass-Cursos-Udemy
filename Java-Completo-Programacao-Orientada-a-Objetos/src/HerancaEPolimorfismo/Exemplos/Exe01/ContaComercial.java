package HerancaEPolimorfismo.Exemplos.Exe01;

public class ContaComercial extends Conta{
    private double limiteEmprestimo;

    public ContaComercial(){
        super();
    }

    public ContaComercial(Integer numero, String titular, Double saldo, double limiteEmprestimo) {
        super(numero, titular, saldo);
        this.limiteEmprestimo = limiteEmprestimo;
    }

    public void emprestimo(double valor){
        if (valor <= limiteEmprestimo){
            saldo += valor - 10.0;
        }
    }

    @Override
    public void sacar(double valor){
        super.sacar(valor);
        saldo -= 2;
    }

    public double getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(double limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }
}
