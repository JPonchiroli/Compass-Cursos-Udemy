package GenericsSetMap.Set.Demo04;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Produto> set = new TreeSet<>();

        set.add(new Produto("TV", 900.0));
        set.add(new Produto("Notebook", 1200.0));
        set.add(new Produto("Tablet", 400.0));

        for (Produto produtos : set){
            System.out.println(produtos);
        }
    }
}
