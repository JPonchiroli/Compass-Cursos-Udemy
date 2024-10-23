package IntroducaoProgramacaoOrientadaObjeto.Exe02;

public class Empregado {
    public String nome;
    public double salarioBruto;
    public double imposto;
    public double salarioLiquido;

    public double salarioLiquido(){
        salarioLiquido = salarioBruto - imposto;
        return salarioLiquido;
    }

    public void aumentarSalario(double porcentagem){
        salarioLiquido = (salarioBruto * (1 + (porcentagem / 100)) - imposto);
    }

    @Override
    public String toString() {
        return "Empregado: " +
                nome + '\'' +
                ", R$" + salarioLiquido;
    }
}
