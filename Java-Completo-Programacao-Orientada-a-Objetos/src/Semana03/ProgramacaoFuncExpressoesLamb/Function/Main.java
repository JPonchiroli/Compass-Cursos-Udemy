package Semana03.ProgramacaoFuncExpressoesLamb.Function;

import java.util.ArrayList;
import java.util.List;

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
