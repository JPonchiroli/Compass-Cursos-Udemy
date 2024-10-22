package GenericsSetMap.Exercicios.Exe01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String path = "C:\\Users\\joaop\\OneDrive\\Área de Trabalho\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Set<EntradaLog> set = new HashSet<>();

            String line = br.readLine();
            while (line != null) {

                String[] fields = line.split(" ");
                String nome = fields[0];
                Date momento = Date.from(Instant.parse(fields[1]));

                set.add(new EntradaLog(nome, momento));

                line = br.readLine();
            }
            System.out.println("Total usuarios: " + set.size());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
