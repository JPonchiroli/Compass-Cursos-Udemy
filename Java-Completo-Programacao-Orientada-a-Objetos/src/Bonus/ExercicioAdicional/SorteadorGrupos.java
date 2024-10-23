package Bonus.ExercicioAdicional;

import java.util.*;
import java.util.stream.Collectors;

public class SorteadorGrupos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] nomes = {"Sofia Mendes", "Lucas Silva", "Maria Oliveira", "Pedro Santos", "Ana Martins", "João Costa", "Carolina Pereira", "André Almeida", "Mariana Fernandes", "Tiago Rodrigues"};

        List<String> equipe = new ArrayList<>(Arrays.asList(nomes));
        Collections.shuffle(equipe); // shuffle() - randomiza lista
        int tamanhoEquipe = equipe.size();

        System.out.println("Informe em quantos grupos você quer dividir a equipe");
        int numeroGrupos = s.nextInt();

        int numeroDeIntegrantesPorGrupo = tamanhoEquipe / numeroGrupos;
        int resto = tamanhoEquipe % numeroGrupos;

        int equipesCompletas = 0;
        int indiceInicial = 0;

        while (equipesCompletas != numeroGrupos) {
            System.out.println("Grupo " + (equipesCompletas + 1));

            int tamanhoSubLista = numeroDeIntegrantesPorGrupo;

            if (equipesCompletas == numeroGrupos - 1 && resto > 0) {
                tamanhoSubLista++;
            }

            List<String> subLista = equipe.subList(indiceInicial, indiceInicial + tamanhoSubLista);
            System.out.println(subLista);

            equipesCompletas++;
            indiceInicial += tamanhoSubLista;
        }
    }
}
