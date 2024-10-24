package Bonus.ProjetoXadrez.Aplicacao;

import Bonus.ProjetoXadrez.Xadrez.Cor;
import Bonus.ProjetoXadrez.Xadrez.PecaXadrez;
import Bonus.ProjetoXadrez.Xadrez.PosicaoXadrez;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void limparTela(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("------------------------------------------------");
    }

    public static PosicaoXadrez lerPosicaoXadrez(Scanner s){
        try {
            String s1 = s.nextLine();
            char coluna = s1.charAt(0);
            int linha = Integer.parseInt(s1.substring(1));

            return new PosicaoXadrez(coluna, linha);
        } catch (RuntimeException e){
            throw new InputMismatchException("Erro lendo PosicaoXadrez. Posicao validas sao de a1 a h8");
        }
    }

    public static void mostrarTabuleiro(PecaXadrez[][] pecas){
        for (int i = 0; i < pecas.length; i++){
            System.out.print((8 - i)+ " ");
            for (int j = 0; j < pecas.length; j++){
                printarPeca(pecas[i][j], false);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    public static void mostrarTabuleiro(PecaXadrez[][] pecas, boolean[][] movimentosPossiveis){
        for (int i = 0; i < pecas.length; i++){
            System.out.print((8 - i)+ " ");
            for (int j = 0; j < pecas.length; j++){
                printarPeca(pecas[i][j], movimentosPossiveis[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    private static void printarPeca(PecaXadrez peca, boolean fundo){
        if (fundo){
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if (peca == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (peca.getCor() == Cor.BRANCO) {
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
            }
        }
        System.out.print(" ");

    }
}
