package ArraysEListas.List;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lista {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // Adicionando dados
        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Ana");
        list.add(2, "Marco");

        // Tamanho da lista
        System.out.println(list.size());

        // Remover da lista
        list.remove(2);

        // Remover com predicado
        list.removeIf(x -> x.charAt(0) == 'M');

        //Encontrar posição na lista
        list.indexOf("Bob");

        // Filtrar lista - todos da lista com a pirmeira letra A
        List<String> listaFiltrada = list.stream().filter(x -> x.charAt(0) == 'A').toList();

        // Filtrar lista - o primeiro nome da lista com a pirmeira letra J
        String nome = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);

        for (String pessoas: listaFiltrada){
            System.out.println(pessoas);
        }
    }
}
