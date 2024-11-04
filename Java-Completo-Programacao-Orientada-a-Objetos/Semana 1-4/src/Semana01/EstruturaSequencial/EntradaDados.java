package Semana01.EstruturaSequencial;

import java.util.Scanner;

public class EntradaDados {
  public static void main(String[] args) {
    // Entrada de dados varios tipos
    
    Scanner s = new Scanner(System.in);

    String x;
    x = s.nextLine();
    System.out.println("Voce digitou: " + x);

    int y;
    y = s.nextInt();
    System.out.println("Voce digitou: " + y);
    
    double z;
    z = s.nextDouble();
    System.out.println("Voce digitou: " + z);

    s.close();
  }
}
