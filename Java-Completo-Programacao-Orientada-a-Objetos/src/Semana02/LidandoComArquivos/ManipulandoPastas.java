package LidandoComArquivos;

import java.io.File;

public class ManipulandoPastas {
    public static void main(String[] args) {

        String caminhoPasta = "C:\\";

        File caminho = new File(caminhoPasta);

        File[] pastas = caminho.listFiles(File::isDirectory);

        System.out.println("Pastas: ");
        for (File pasta: pastas){
            System.out.println(pasta);
        }

        File[] arquivos = caminho.listFiles(File::isFile);

        System.out.println("Arquivos: ");
        for (File arquivo: arquivos){
            System.out.println(arquivo);
        }
    }
}
