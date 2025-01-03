package Semana02.HerancaEPolimorfismo.Exemplos.Exe03;

public class Circulo extends Forma{
    private double raio;

    public Circulo(){
        super();
    }

    public Circulo(Cor cor, double raio) {
        super(cor);
        this.raio = raio;
    }

    @Override
    public double area() {
        return Math.PI * (raio * raio);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}
