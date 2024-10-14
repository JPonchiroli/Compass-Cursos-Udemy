package ArraysEListas.List.Exercicios.Exe01;

public class Empregado {
    private int id;
    private String nome;
    private double salario;

    public Empregado(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public void aumentarSalario(double porcentagem){
        salario = salario * (1 + (porcentagem / 100));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return  "Id: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Salario: " + salario + "\n" +
                "------------------------------";
    }
}
