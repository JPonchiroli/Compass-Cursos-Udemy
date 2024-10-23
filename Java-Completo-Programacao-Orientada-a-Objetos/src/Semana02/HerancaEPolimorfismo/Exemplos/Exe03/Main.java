package HerancaEPolimorfismo.Exemplos.Exe03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Forma> formas = new ArrayList<>();

        System.out.print("Informe o numero de figuras: ");
        int numFiguras = s.nextInt();



        for (int i = 1; i <= numFiguras; i++){
            System.out.println("Dados da fomra #" + i);

            System.out.print("Retangulo ou Circulo (r/c)? :");
            char tipoForma = s.next().charAt(0);

            s.nextLine();

            System.out.print("Cor (PRETO/AZUL/VERMELHO): ");
            String cor = s.nextLine();

            if (tipoForma == 'r'){
                System.out.print("Largura: ");
                double largura = s.nextDouble();
                System.out.print("Altura: ");
                double altura = s.nextDouble();
                formas.add(new Retangulo(Cor.valueOf(cor), largura, altura));
            } else {
                System.out.print("Raio: ");
                double raio = s.nextDouble();
                formas.add(new Circulo(Cor.valueOf(cor), raio));
            }
        }

        System.out.println();
        System.out.println("Areas das Formas");
        for (Forma f: formas){
            System.out.println(String.format("%.2f", f.area()));
        }
    }
}
