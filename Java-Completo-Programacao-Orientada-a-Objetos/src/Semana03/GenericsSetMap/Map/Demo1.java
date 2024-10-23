package GenericsSetMap.Map;

import java.util.Map;
import java.util.TreeMap;

public class Demo1 {
    public static void main(String[] args) {
        Map<String, String> cookies = new TreeMap<>();

        cookies.put("usuario", "Maria");
        cookies.put("email", "maria@gmail.com");
        cookies.put("telefone", "9685454718");

        cookies.remove("email");
        cookies.put("telefone", "9685454829");

        System.out.println("Contem a chave 'telefone'?: " + cookies.containsKey("telefone"));
        System.out.println("Numero telefone: " + cookies.get("telefone"));
        System.out.println("Email: " + cookies.get("email"));
        System.out.println("Tamanho: " + cookies.size());

        System.out.println();

        for (String key : cookies.keySet()){
            System.out.println(key + ": " + cookies.get(key));
        }
    }
}
