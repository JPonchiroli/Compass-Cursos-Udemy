package Semana03.GenericsSetMap.TipoCoringa.CoringaDelimitado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<Object>();

        copy(myInts, myObjs);
        printLista(myObjs);
        copy(myDoubles, myObjs);
        printLista(myObjs);
    }

    public static void copy(List<? extends Number> origem, List<? super Number> destino){
        for (Number numero : origem){
            destino.add(numero);
        }
    }

    public static void printLista(List<?> lista){
        for (Object obj: lista){
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
