package Semana02.Excecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {

        metedo();


        System.out.println("Fim do programa");
    }

    public static void metedo(){
        Scanner s = new Scanner(System.in);
        try {
            String[] vect = s.nextLine().split(" ");
            int posicao = s.nextInt();
            System.out.println(vect[posicao]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Posicao Invalida");
            e.printStackTrace();
        } catch (InputMismatchException e){
            System.out.println("Erro de entrada");
            e.printStackTrace();
        }
    }

}
