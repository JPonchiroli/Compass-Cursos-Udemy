package ProgramacaoFuncExpressoesLamb.Demo02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();

        lista.add(new Produto("TV", 900.0));
        lista.add(new Produto("Notebook", 1200.0));
        lista.add(new Produto("Tablet", 50.0));

        //lista.removeIf(new ProdutoPredicate());

        lista.removeIf(p -> p.getPreco() >= 100);

        for (Produto produtos : lista){
            System.out.println(produtos);
        }
    }
}
