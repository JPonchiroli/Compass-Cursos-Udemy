package Semana02.LidandoComArquivos.Exercicio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String caminho = "C:\\Users\\joaop\\OneDrive\\Área de Trabalho\\in.txt";
        List<Produto> produtos = new ArrayList<>();

        File caminhoFonte = new File(caminho);
        String caminhoFonteStr = caminhoFonte.getParent();

        boolean sucesso = new File(caminhoFonteStr + "\\out").mkdir();
        String alvoParaAquivoStr = caminhoFonteStr + "\\out\\produtos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(alvoParaAquivoStr))){
            String linha = br.readLine();

            while (linha != null) {
                String[] campos = linha.split(",");
                String nome = campos[0];
                double preco = Double.parseDouble(campos[1]);
                int quantidade = Integer.parseInt(campos[2]);

                produtos.add(new Produto(nome, preco, quantidade));

                linha = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(alvoParaAquivoStr))){
                for (Produto item : produtos) {
                    bw.write(item.getNome() + "," + String.format("%.2f", item.precoTotal()));
                    bw.newLine();
                }

                System.out.println(alvoParaAquivoStr + " CREATED!");

            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }


        } catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
