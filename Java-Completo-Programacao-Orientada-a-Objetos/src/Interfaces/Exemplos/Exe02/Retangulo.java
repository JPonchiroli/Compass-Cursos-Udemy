package Interfaces.Exemplos.Exe02;

public class Retangulo extends FormaAbstrata {
    private double altura;
    private double largura;

    public Retangulo(Cor cor, double altura, double largura) {
        super(cor);
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public double area() {
        return altura * largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }
}
