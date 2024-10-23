package Semana01.EstruturaSequencial;

public class ExercicioFixacaoSaidaDados {
  public static void main(String[] args) {

    /*Formatacao de saida de dados 
      %s: Para strings
      %d: Para números inteiros
      %f: Para números de ponto flutuante
      %c: Para caracteres
      %.2f: Para números de ponto flutuante com 2 casas decimais
      %n ou \n: Para adicionar uma nova linha
    */
    
    //Exemplo de saida de dados

    String produto1 = "Computer";
    String produto2 = "Office desk";

    double price1 = 2100.0;
    double price2 = 650.50;

    System.out.println("Products:");
    System.out.printf("%s, which price is $ %.2f\n", produto1, price1);
    System.out.printf("%s, which price is $ %.2f\n", produto2, price2);
    System.out.println();
    
    
  }
}
