package Semana02.LidandoComArquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscrevendoEmArquivoTxt {
    public static void main(String[] args) {
        String[] linhas = new String[] {"Bom dia", "Boa Tarde"};

        String caminho = "C:\\Users\\joaop\\OneDrive\\Área de Trabalho\\out.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))){
            for (String linha: linhas){
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
