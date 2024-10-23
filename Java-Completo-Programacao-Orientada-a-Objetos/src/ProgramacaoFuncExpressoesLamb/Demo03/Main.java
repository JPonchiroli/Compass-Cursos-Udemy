package ProgramacaoFuncExpressoesLamb.Demo03;

import ProgramacaoFuncExpressoesLamb.Demo04.NomeCaixaAlta;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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
