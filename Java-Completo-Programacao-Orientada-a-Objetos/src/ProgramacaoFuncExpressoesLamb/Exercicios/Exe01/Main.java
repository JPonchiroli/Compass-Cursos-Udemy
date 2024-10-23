package ProgramacaoFuncExpressoesLamb.Exercicios.Exe01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String caminho = "C:\\Users\\joaop\\OneDrive\\Área de Trabalho\\in.txt";


        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
            List<Produto> produtos = new ArrayList<>();
            String linha = br.readLine();

            while(linha != null){

                String[] campos = linha.split(",");
                produtos.add(new Produto(campos[0], Double.parseDouble(campos[1 ])));
                linha = br.readLine();
            }

            double media = produtos.stream()
                    .map(p -> p.getPreco())
                    .reduce(0.0, (x, y) -> x + y) / produtos.size();

            System.out.println("Preco Medio: " + String.format("%.2f",media));

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> nomes = produtos.stream()
                    .filter(p -> p.getPreco() < media)
                    .map(p -> p.getNome())
                    .sorted(comp.reversed())
                    .toList();

            nomes.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
