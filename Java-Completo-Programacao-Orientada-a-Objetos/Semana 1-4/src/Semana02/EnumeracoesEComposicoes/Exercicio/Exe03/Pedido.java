package Semana02.EnumeracoesEComposicoes.Exercicio.Exe03;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

    private Date momentoPedido;
    private StatusPedido statusPedido;

    private List<ItemPedido> itensPedido = new ArrayList<>();
    private Cliente cliente;

    public Pedido(){}

    public Pedido(Date momentoPedido, StatusPedido statusPedido, Cliente cliente) {
        this.momentoPedido = new Date();
        this.statusPedido = statusPedido;
        this.cliente = cliente;
    }

    public void adicionarItem(ItemPedido itemPedido){
        itensPedido.add(itemPedido);
    }

    public void removerItem(ItemPedido itemPedido){
        itensPedido.remove(itemPedido);
    }

    public double total(){
        double soma = 0;
        for (ItemPedido itens: itensPedido){
            soma += itens.subTotal();
        }
        return soma;
    }

    public Date getMomentoPedido() {
        return momentoPedido;
    }

    public void setMomentoPedido(Date momentoPedido) {
        this.momentoPedido = momentoPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public List<ItemPedido> getItemPedido() {
        return itensPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------------------------------");
        sb.append("Resumo do Pedido \n");
        sb.append("Momento do Pedido: " + sdf1.format(momentoPedido) + "\n");
        sb.append("Status Pedido: " + statusPedido + "\n");
        sb.append("Cliente: ");
        sb.append(cliente.getNome() + " ");
        sb.append("(" + sdf2.format(cliente.getDataAniversario()) + ") ");
        sb.append("- " + cliente.getEmail() + "\n");
        sb.append("Itens do Pedido \n");
        for (ItemPedido itens: itensPedido){
            sb.append(itens + "\n");
        }
        sb.append("Preço Total " + total());
        sb.append("-------------------------------------------------");
        return sb.toString();
    }
}
