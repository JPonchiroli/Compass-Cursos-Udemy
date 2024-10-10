package EstruturaDeRepeticao;

public class For {
    public static void main(String[] args) {

        int multiplicador = 5;

        for (int i = 0; i <= 10; i++){
            int multiplicacao = i * multiplicador;
            System.out.println(multiplicador + " x " + i + " = " + multiplicacao);
        }
    }
}
