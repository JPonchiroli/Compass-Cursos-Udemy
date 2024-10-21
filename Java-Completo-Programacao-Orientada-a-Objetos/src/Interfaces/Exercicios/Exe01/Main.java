package Interfaces.Exercicios.Exe01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Informe os dados do contrato");
        System.out.print("Numero: ");
        int numero = s.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(s.next(), fmt);
        System.out.print("Valor Contrato: ");
        Double valorContrato = s.nextDouble();

        Contrato contrato = new Contrato(numero, data, valorContrato);

        System.out.print("Informe o numero de parcelas: ");
        int parcelas = s.nextInt();

        ServicoContrato servicoContrato = new ServicoContrato(new ServicoPayPal());

        servicoContrato.processarContrato(contrato, parcelas);

        System.out.println("Parcelas: ");
        for (Parcela parcela: contrato.getListaParcelas()){
            System.out.println(parcela);
        }
    }
}
