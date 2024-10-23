package Semana02.HerancaEPolimorfismo.Exercicios.Exe01;

public class Produto {
    private String nome;
    private double preco;

    public Produto(){}

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String etiqueta(){
        return getNome() + "R$ " + getPreco();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
