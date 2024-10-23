package EnumeracoesEComposicoes.Exercicio.Exe02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Comentario coment1 = new Comentario("Tenha uma boa viagem");
        Comentario coment2 = new Comentario("Uau isso é demais");

        Post p1 = new Post(
                sdf.parse("21/06/2018 13:05:44"),
                "Viajando para Nova Zelândia",
                "Viajando por esse pais",
                12);
        p1.adicionarComentario(coment1);
        p1.adicionarComentario(coment2);

        System.out.println(p1);
    }
}
