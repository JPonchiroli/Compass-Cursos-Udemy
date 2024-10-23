package ProgramacaoFuncExpressoesLamb.Demo04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Produto> lista = new ArrayList<>();

        lista.add(new Produto("TV", 900.0));
        lista.add(new Produto("Notebook", 1200.0));
        lista.add(new Produto("Tablet", 50.0));

        List<String> nomes = lista.stream().map(new NomeCaixaAlta()).toList();

        nomes.forEach(System.out::println);
    }
}
