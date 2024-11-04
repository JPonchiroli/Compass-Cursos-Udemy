package Semana01.Date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataTime {
    public static void main(String[] args) {

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();

        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
        Instant d07 = Instant.parse("2022-07-20T01:30:26-03:00");

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);
        LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt2);
        LocalDate d10 = LocalDate.of(2022, 7, 20);

        System.out.println("D01: " + d01);
        System.out.println("D02: " + d02);
        System.out.println("D03: " + d03);

        System.out.println();

        System.out.println("D04: " + d04);
        System.out.println("D05: " + d05);
        System.out.println("D06: " + d06);
        System.out.println("D07: " + d07);

        System.out.println();

        System.out.println("D08: " + d08);
        System.out.println("D09: " + d09);
        System.out.println("D10: " + d10);
    }
}
