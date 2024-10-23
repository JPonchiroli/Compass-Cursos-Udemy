package Interfaces.Exemplos.Exe01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com dados do aluguel");

        System.out.print("Modelo do carro: ");
        String modelo = s.nextLine();
        System.out.print("Data de entrada (dd/MM/yyyy HH:mm): ");
        LocalDateTime entrada = LocalDateTime.parse(s.nextLine(), fmt);
        System.out.print("Data de saida (dd/MM/yyyy HH:mm): ");
        LocalDateTime saida = LocalDateTime.parse(s.nextLine(), fmt);

        AluguelVeiculo aluguelCarro = new AluguelVeiculo(entrada, saida, new Veiculo(modelo));

        System.out.print("Informe preco por hora: ");
        double precoPorHora = s.nextDouble();
        System.out.print("Informe preco por dia: ");
        double precoPorDia = s.nextDouble();

        ServicoAluguel servicoAluguel = new ServicoAluguel(precoPorHora, precoPorDia, new ServicoTaxaBrasil());

        servicoAluguel.processarFatura(aluguelCarro);

        System.out.println("Fatura: ");
        System.out.println("Pagamento Basico: " + aluguelCarro.getFatura().getPagamentoBasico());
        System.out.println("Imposto: " + aluguelCarro.getFatura().getTaxa());
        System.out.println("Pagamento Total: " + aluguelCarro.getFatura().getPagamentoTotal());
    }
}
