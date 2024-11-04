package Semana02.EnumeracoesEComposicoes.Exemplo;

import java.util.Date;

public class Pedido {
    private int id;
    private Date momentoPedido;
    private StatusPedido statusPedido;

    public Pedido(){}

    public Pedido(int id, Date momentoPedido, StatusPedido statusPedido) {
        this.id = id;
        this.momentoPedido = momentoPedido;
        this.statusPedido = statusPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Pedido{" +
                "id: " + id +
                ", momentoPedido: " + momentoPedido +
                ", statusPedido: " + statusPedido +
                '}';
    }
}
