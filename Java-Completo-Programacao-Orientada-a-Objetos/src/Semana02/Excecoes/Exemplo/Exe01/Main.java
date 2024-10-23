package Semana02.Excecoes.Exemplo.Exe01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Numero quarto: ");
            int numeroQuarto = s.nextInt();
            System.out.print("Data check-in (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(s.next());
            System.out.print("Data check-out (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(s.next());

            Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Informe uma data para atualizar a antiga reserva ");
            System.out.print("Data check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(s.next());
            System.out.print("Data check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(s.next());

            reserva.atualizarDatas(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
        } catch (ParseException e){
            System.out.println("Data Inválida");
        } catch (DomainException e){
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Erro Inesperado");
        }
    }
}
