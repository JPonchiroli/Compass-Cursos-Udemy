package GenericsSetMap.Exercicios.Exe03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\joaop\\OneDrive\\Área de Trabalho\\in.txt";

        Map<String, Integer> votos = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            votos = new LinkedHashMap<>();

            String line = br.readLine();
            while (line != null) {

                String[] campos = line.split(",");
                String nome = campos[0];
                Integer numeroVotos = Integer.parseInt(campos[1]);

                if (votos.containsKey(nome)){
                    int votosAteAgora = votos.get(nome);
                    votos.put(nome, numeroVotos + votosAteAgora);
                } else {
                    votos.put(nome, numeroVotos);
                }

                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (String candidatos : votos.keySet()) {
            System.out.println(candidatos + ": " + votos.get(candidatos));
        }
    }
}
