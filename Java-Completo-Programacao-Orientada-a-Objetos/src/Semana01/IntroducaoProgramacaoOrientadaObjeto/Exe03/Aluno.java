package Semana01.IntroducaoProgramacaoOrientadaObjeto.Exe03;

public class Aluno {
    public String nome;
    public double primeiraNota;
    public double segundaNota;
    public double terceiraNota;
    public double somaNotas;

    public double somaNota(){
        somaNotas = primeiraNota + segundaNota + terceiraNota;
        return somaNotas;
    }

    public void situacao(){
        if(somaNotas >= 60){
            System.out.println("Passou");
        } else {
            System.out.println("Falhou");
            System.out.println("Faltando " + (60 - somaNotas) + " pontos");
        }
    }


}
