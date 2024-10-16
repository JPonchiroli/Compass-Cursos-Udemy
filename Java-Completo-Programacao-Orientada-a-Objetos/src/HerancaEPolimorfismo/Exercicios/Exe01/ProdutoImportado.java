package HerancaEPolimorfismo.Exercicios.Exe01;

public class ProdutoImportado extends Produto{
    private double taxaAlfandega;

    public ProdutoImportado(){}

    public ProdutoImportado(String nome, double preco, double taxaAlfandega) {
        super(nome, preco);
        this.taxaAlfandega = taxaAlfandega;
    }

    @Override
    public String etiqueta(){
        return getNome() + " R$" + (getPreco() + getTaxaAlfandega()) + " (Taxa da Alfândega: R$ " + getTaxaAlfandega() + ")";
    }

    public double getTaxaAlfandega() {
        return taxaAlfandega;
    }

    public void setTaxaAlfandega(double taxaAlfandega) {
        this.taxaAlfandega = taxaAlfandega;
    }
}
