package ProgramacaoFuncExpressoesLamb.Demo01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();

        lista.add(new Produto("TV", 900.0));
        lista.add(new Produto("Notebook", 1200.0));
        lista.add(new Produto("Tablet", 400.0));

        //lista.sort(new MeuComparator());

        /* Comparator<Produto> comp = (p1, p2) -> p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase());
        lista.sort(comp); */

        lista.sort((p1, p2) -> p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase()));

        for (Produto produtos : lista){
            System.out.println(produtos);
        }
    }
}
