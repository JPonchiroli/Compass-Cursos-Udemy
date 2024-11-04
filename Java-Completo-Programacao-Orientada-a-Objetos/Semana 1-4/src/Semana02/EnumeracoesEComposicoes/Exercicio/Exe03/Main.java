package Semana02.EnumeracoesEComposicoes.Exercicio.Exe03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner s = new Scanner(System.in);

        System.out.println("Informe as informações do cliente");

        System.out.print("Nome: ");
        String nomeCliente = s.nextLine();
        System.out.print("Email: ");
        String emailCliente = s.nextLine();
        System.out.print("Data Aniversário: ");
        Date dataAniversarioCliente = sdf.parse(s.nextLine());

        Cliente cliente = new Cliente(nomeCliente, emailCliente, dataAniversarioCliente);

        System.out.println("Informe os dados do pedido");
        System.out.print("Status: ");
        String statusPedido = s.nextLine();

        Pedido pedido = new Pedido(new Date(),StatusPedido.valueOf(statusPedido), cliente);

        System.out.print("Quantos produtos para este pedido: ");
        int qtdProdutos = s.nextInt();



        for (int i = 0; i < qtdProdutos; i++){
            s.nextLine();

            System.out.println("Informe os dados do " + qtdProdutos + "° produto");

            System.out.print("Nome do Produto: ");
            String nomeProduto = s.nextLine();
            System.out.print("Preço do Produto: ");
            double precoProduto = s.nextDouble();
            System.out.print("Quantidade do Produto: ");
            int qtdProduto = s.nextInt();

            ItemPedido itemPedido = new ItemPedido(qtdProduto, precoProduto, new Produto(nomeProduto, precoProduto));
            pedido.adicionarItem(itemPedido);
        }

        System.out.println(pedido);

    }
}
