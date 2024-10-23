package HerancaEPolimorfismo.Exercicios.Exe01;

import java.time.LocalDate;

public class ProdutoUsado extends Produto{
    private LocalDate dataFabricacao;

    public ProdutoUsado(){}

    public ProdutoUsado(String nome, double preco, LocalDate dataFabricacao) {
        super(nome, preco);
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String etiqueta(){
        return getNome() + " (usado) R$" + getPreco() + " (Data de Fabricação: " + getDataFabricacao() + ")";
    }


    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }
}
