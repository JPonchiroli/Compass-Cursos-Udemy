package HerancaEPolimorfismo.Exemplos.Exe02;

public class FuncionarioTerceirizado extends Funcionario{
    private double valorAdicional;

    public FuncionarioTerceirizado(){
        super();
    }

    public FuncionarioTerceirizado(String nome, Integer horas, double valorPorHora, double valorAdicional) {
        super(nome, horas, valorPorHora);
        this.valorAdicional = valorAdicional;
    }

    @Override
    public double pagamento(){
        return super.pagamento() + valorAdicional * 1.1;
    }


    public double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }
}
