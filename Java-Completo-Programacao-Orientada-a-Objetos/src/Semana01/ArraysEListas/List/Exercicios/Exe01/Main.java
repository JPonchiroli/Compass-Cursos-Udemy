package ArraysEListas.List.Exercicios.Exe01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Empregado> empregadosList = new ArrayList<>();

        System.out.println("Quantos empregadosList seram cadastrados?");
        int numeroEmpregados = s.nextInt();

        for (int i = 0; i < numeroEmpregados; i++){
            System.out.println("Informe o id do Empregado");
            int id = s.nextInt();

            s.nextLine();

            System.out.println("Informe o nome do Empregado");
            String nome = s.nextLine();

            System.out.println("Informe o salário do Empregado");
            double salario = s.nextDouble();

            Empregado emp = new Empregado(id, nome, salario);
            empregadosList.add(emp);
        }

        System.out.println("Informe o id do Empregado que terá um aumento no salário");
        int idEmpregado = s.nextInt();

        String idExistente = String.valueOf(empregadosList.stream().filter(x -> x.getId() == idEmpregado).findFirst().orElse(null));

        if(!idExistente.equals("null")){
            System.out.println("Informe a porcentagem de aumento");
            double percAumento = s.nextDouble();

            for (Empregado empregado: empregadosList){
                if(empregado.getId() == idEmpregado){
                    empregado.aumentarSalario(percAumento);
                }
            }
        } else {
            System.out.println("Esse id não existe");
        }

        System.out.println("Lista de empregados");
        for (Empregado empregado: empregadosList){
            System.out.println(empregado);
        }

    }
}
