package EstruturaSequencial;

public class ExpressoesMatematicas {
  public static void main(String[] args) {
    // Expressoes Matematicas com biblioteca Math
    
    // Exemplo 1: Math.sqrt() - Calcula a raiz quadrada
    double numero = 25;
    double raizQuadrada = Math.sqrt(numero);
    System.out.println("A raiz quadrada de " + numero + " é " + raizQuadrada);
    
    // Exemplo 2: Math.pow() - Calcula a potência
    double base = 2;
    double expoente = 3;
    double resultado = Math.pow(base, expoente);
    System.out.println(base + " elevado a " + expoente + " é " + resultado);
    
    // Exemplo 3: Math.abs() - Retorna o valor absoluto
    int numeroNegativo = -15;
    int valorAbsoluto = Math.abs(numeroNegativo);
    System.out.println("O valor absoluto de " + numeroNegativo + " é " + valorAbsoluto);
  }
}
