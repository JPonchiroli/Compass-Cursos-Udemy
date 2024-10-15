package EnumeracoesEComposicoes.Exercicio.Exe03;

public class ItemPedido {
    private Integer quantidade;
    private Double preco;

    private Produto produto;

    public ItemPedido(){}

    public ItemPedido(Integer quantidade, Double preco, Produto produto) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
    }

    public double subTotal(){
        return quantidade * preco;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(produto.getNome() + ", ");
        sb.append("Quantidade: " + quantidade + ", ");
        sb.append("SubTotal: R$" + subTotal());
        return sb.toString();
    }
}
