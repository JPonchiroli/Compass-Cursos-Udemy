package Semana03.Interfaces.Exemplos.Exe02;

public class Circulo extends FormaAbstrata {
    private double raio;

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
