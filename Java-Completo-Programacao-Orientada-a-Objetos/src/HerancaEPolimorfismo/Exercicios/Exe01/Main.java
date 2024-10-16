package HerancaEPolimorfismo.Exercicios.Exe01;

import HerancaEPolimorfismo.Exemplos.Exe02.Funcionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");

        List<Produto> produtos = new ArrayList<>();

        System.out.print("Informe a quantidade de produtos: ");
        int qtdProdutos = s.nextInt();

        for (int i = 1; i <= qtdProdutos; i++){
            System.out.println("Dados do produto #" + i);

            System.out.print("Comum, Usado ou Importado (c/u/i)?: ");
            char tipoProduto = s.next().charAt(0);
            System.out.print("Nome: ");
            s.nextLine();
            String nome = s.nextLine();
            System.out.print("Preco: ");
            double preco = s.nextDouble();
            if (tipoProduto == 'u'){
                System.out.print("Data de Fabricação (DD/MM/YYYY): ");
                LocalDate dataFabricacao = LocalDate.parse(s.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                produtos.add(new ProdutoUsado(nome, preco, dataFabricacao));
            } else if (tipoProduto == 'i'){
                System.out.println("Taxa alfândega: ");
                double taxaAlfandega = s.nextDouble();
                produtos.add(new ProdutoImportado(nome, preco, taxaAlfandega));
            } else {
                produtos.add(new Produto(nome, preco));
            }
        }

        System.out.println();

        System.out.println("Etiquetas");
        for (Produto prod: produtos){
            System.out.println(prod.etiqueta());
        }
    }
}
