package GenericsSetMap.Generics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ServicoPrint<Integer> ps = new ServicoPrint<>();

        System.out.print("Quantos valores? ");
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            Integer value = s.nextInt();
            ps.adicionarValor(value);
        }

        ps.print();
        Integer x = ps.primeiro();
        System.out.println("Primeiro: " + x);
    }
}
