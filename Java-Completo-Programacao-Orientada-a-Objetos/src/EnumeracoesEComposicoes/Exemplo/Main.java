package EnumeracoesEComposicoes.Exemplo;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(1080, new Date(), StatusPedido.PROCESSANDO);

        StatusPedido statusPedido = StatusPedido.valueOf("ENTREGUE");

        System.out.println(pedido);
        System.out.println(statusPedido);
    }
}
