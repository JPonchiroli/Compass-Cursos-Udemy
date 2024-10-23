package EstruturaDeRepeticao.ExerciciosWhile;

import java.util.Scanner;

public class Exe01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int senha = 2022, tentativaSenha = 0;

        while (tentativaSenha != senha){
            tentativaSenha = s.nextInt();

            if(tentativaSenha != senha){
                System.out.println("Senha Inválida");
            } else {
                System.out.println("Senha Aceita");
            }
        }
    }
}
