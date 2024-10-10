package EstruturaCondicional;

public class CondicaoTernaria {
    public static void main(String[] args) {
        double preco = 34.5;
        double desconto = (preco < 20) ? preco * 0.1 : preco * 0.5;

        System.out.println(desconto);
    }
}
