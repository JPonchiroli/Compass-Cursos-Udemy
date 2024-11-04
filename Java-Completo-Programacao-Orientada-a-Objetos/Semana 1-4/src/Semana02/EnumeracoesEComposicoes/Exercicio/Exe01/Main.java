package Semana02.EnumeracoesEComposicoes.Exercicio.Exe01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Informe o nome do departamento: ");
        String nomeDepartamento = s.nextLine();

        System.out.println("Informe as informações do Trabalhador");

        System.out.print("Nome: ");
        String nomeTrabalhador = s.nextLine();
        System.out.print("Nível: ");
        String nivelTrabalhador = s.nextLine();
        System.out.print("Salário Base: ");
        double salarioBase = s.nextDouble();

        Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalhador.valueOf(nivelTrabalhador), salarioBase, new Departamento(nomeDepartamento));

        System.out.println("Informe a qunatidade de contratos");
        int qtdContratos = s.nextInt();

        for (int i = 0; i < qtdContratos; i++){
            System.out.println("Informe as informações do " + qtdContratos  + "° contrato");

            System.out.print("Data (DD/MM/YYYY): ");
            Date dataContrato = sdf.parse(s.next());
            System.out.print("Valor por hora: ");
            double valorPorHora = s.nextDouble();
            System.out.print("Duração (horas): ");
            int horas = s.nextInt();

            ContratoPorHora contrato = new ContratoPorHora(dataContrato, valorPorHora, horas);
            trabalhador.adicionarContrato(contrato);
        }

        System.out.println();

        System.out.print("Informe o mês e ano para calcular o salário (MM/YYYY): ");
        String mesEAno = s.next();
        int mes = Integer.parseInt(mesEAno.substring(0, 2));
        int ano = Integer.parseInt(mesEAno.substring(3));

        System.out.println("Nome: " + trabalhador.getNome());
        System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
        System.out.printf("Rendimento para " + mesEAno + ": " + String.format("%.2f", trabalhador.rendimento(ano, mes)));
    }
}
