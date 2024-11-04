package Semana03.Interfaces.Exemplos.Exe03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> list = new ArrayList<>();
        String path = "C:\\Users\\joaop\\OneDrive\\Área de Trabalho\\in.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String funcionarioCSV = br.readLine();
            while (funcionarioCSV != null) {
                String[] campos = funcionarioCSV.split(",");

                list.add(new Funcionario(campos[0], Double.parseDouble(campos[1])));
                funcionarioCSV = br.readLine();
            }
            Collections.sort(list);
            for (Funcionario funcionario : list) {
                System.out.println(funcionario.getNome() + ", " + funcionario.getSalario());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
