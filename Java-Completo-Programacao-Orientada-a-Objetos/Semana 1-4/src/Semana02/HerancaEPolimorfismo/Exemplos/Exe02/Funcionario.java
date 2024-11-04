package Semana02.HerancaEPolimorfismo.Exemplos.Exe02;

public class Funcionario {
    private String nome;
    private Integer horas;
    private double valorPorHora;

    public Funcionario(){}

    public Funcionario(String nome, Integer horas, double valorPorHora) {
        this.nome = nome;
        this.horas = horas;
        this.valorPorHora = valorPorHora;
    }

    public double pagamento(){
        return horas * valorPorHora;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }
}
