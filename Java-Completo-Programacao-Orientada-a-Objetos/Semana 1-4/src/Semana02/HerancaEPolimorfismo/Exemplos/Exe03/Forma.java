package Semana02.HerancaEPolimorfismo.Exemplos.Exe03;

public abstract class Forma {
    private Cor cor;

    public Forma(){}

    public Forma(Cor cor) {
        this.cor = cor;
    }

    public abstract double area();

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
}
