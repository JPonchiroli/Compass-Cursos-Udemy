package LidandoComArquivos;

import java.io.File;

public class InfoArquivos {
    public static void main(String[] args) {
        String caminho = "C:\\Users\\joaop\\OneDrive\\Área de Trabalho\\out.txt";

        File path = new File(caminho);
        System.out.println("getPath: " + path.getPath());
        System.out.println("getParent: " + path.getParent());
        System.out.println("getName: " + path.getName());
    }
}
