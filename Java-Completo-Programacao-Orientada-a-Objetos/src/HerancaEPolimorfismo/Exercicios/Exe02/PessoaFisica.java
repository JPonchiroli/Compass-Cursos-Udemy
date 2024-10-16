package HerancaEPolimorfismo.Exercicios.Exe02;

public class PessoaFisica extends Pessoa{
    private double gastosComSaude;

    public PessoaFisica(){
        super();
    }

    public PessoaFisica(String nome, double rendaAnual, double gastosComSaude) {
        super(nome, rendaAnual);
        this.gastosComSaude = gastosComSaude;
    }

    @Override
    public double calculoImposto() {
        double imposto = 0;
        if (getRendaAnual() < 20000){
            if (getGastosComSaude() > 0){
                imposto = (getRendaAnual() * 1.15 ) - (getGastosComSaude() * 0.50);
            } else {
                imposto = (getRendaAnual() * 1.15 );
            }
        } else {
            if (getGastosComSaude() > 0){
                imposto = (getRendaAnual() * 0.25 ) - (getGastosComSaude() * 0.50);
            } else {
                imposto = (getRendaAnual() * 0.25 );
            }
        }
        return imposto;
    }

    public double getGastosComSaude() {
        return gastosComSaude;
    }

    public void setGastosComSaude(double gastosComSaude) {
        this.gastosComSaude = gastosComSaude;
    }
}
