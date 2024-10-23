package EnumeracoesEComposicoes.Exercicio.Exe01;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {
    private String nome;
    private NivelTrabalhador nivelTrabalhador;
    private Double salariobase;

    private Departamento departamento;
    private List<ContratoPorHora> contratos = new ArrayList<>();

    public Trabalhador(){}

    public Trabalhador(String nome, NivelTrabalhador nivelTrabalhador, Double salariobase, Departamento departamento) {
        this.nome = nome;
        this.nivelTrabalhador = nivelTrabalhador;
        this.salariobase = salariobase;
        this.departamento = departamento;
    }

    public void adicionarContrato(ContratoPorHora contrato){
        contratos.add(contrato);
    }

    public void removerContrato(ContratoPorHora contrato){
        contratos.remove(contrato);
    }

    public double rendimento(int ano, int mes){
        double soma = salariobase;
        Calendar cal = Calendar.getInstance();
        for (ContratoPorHora c: contratos){
            cal.setTime(c.getData());
            int c_ano = cal.get(Calendar.YEAR);
            int c_mes = 1 + cal.get(Calendar.MONTH);
            if (ano == c_ano && mes == c_mes){
                soma += c.valorTotal();
            }
        }
        return soma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelTrabalhador getNivelTrabalhador() {
        return nivelTrabalhador;
    }

    public void setNivelTrabalhador(NivelTrabalhador nivelTrabalhador) {
        this.nivelTrabalhador = nivelTrabalhador;
    }

    public Double getSalariobase() {
        return salariobase;
    }

    public void setSalariobase(Double salariobase) {
        this.salariobase = salariobase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoPorHora> getContratos() {
        return contratos;
    }

}
