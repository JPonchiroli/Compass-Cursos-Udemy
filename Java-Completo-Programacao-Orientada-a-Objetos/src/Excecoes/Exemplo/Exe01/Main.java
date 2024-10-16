package Excecoes.Exemplo.Exe01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero quarto: ");
        int numeroQuarto = s.nextInt();
        System.out.print("Data check-in (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(s.next());
        System.out.print("Data check-out (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(s.next());

        if (!checkOut.after(checkIn)){
            System.out.println("Erro na reserva: Data de check-out deve ser depois da data de check-in");
        } else {
            Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.print("Informe uma data para atualizar a antiga reserva: ");
            System.out.print("Data check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(s.next());
            System.out.print("Data check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(s.next());

            reserva.atualizarDatas(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);
        }
    }
}
