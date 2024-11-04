package Semana03.ProgramacaoFuncExpressoesLamb.Consumer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();

        lista.add(new Produto("TV", 900.00));
        lista.add(new Produto("Notebook", 1200.00));
        lista.add(new Produto("Tablet", 50.00));

        //lista.removeIf(new ProdutoPredicate());

        lista.removeIf(p -> p.getPreco() >= 100);

        lista.forEach(System.out::println);
    }
}
