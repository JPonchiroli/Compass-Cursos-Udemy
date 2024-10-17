package LidandoComArquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LendoArquivoTxt {
    public static void main(String[] args) {
        File arquivo = new File("C:\\Users\\joaop\\OneDrive\\Área de Trabalho\\in.txt");
        Scanner s = null;
        try {
            s = new Scanner(arquivo);
            while (s.hasNextLine()){
                System.out.println(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (s != null){
                s.close();
            }
        }
    }
}
