package Semana02.HerancaEPolimorfismo.Exercicios.Exe02;

public class PessoaJuridica extends Pessoa{
    private int numeroFuncionarios;

    public PessoaJuridica(){
        super();
    }

    public PessoaJuridica(String nome, double rendaAnual, int numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public double calculoImposto() {
        double imposto = 0;
        if (getNumeroFuncionarios() > 10){
            imposto = getRendaAnual() * 0.14;
        } else {
            imposto = getRendaAnual() * 0.16;
        }
        return imposto;
    }

    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(int numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }
}
