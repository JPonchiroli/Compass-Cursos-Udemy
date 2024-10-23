package Interfaces.Exemplos.Exe01;

import java.time.LocalDateTime;

public class AluguelVeiculo {
    private LocalDateTime entrada;
    private LocalDateTime saida;

    private Veiculo veiculo;
    private Fatura fatura;

    public AluguelVeiculo(){}

    public AluguelVeiculo(LocalDateTime entrada, LocalDateTime saida, Veiculo veiculo) {
        this.entrada = entrada;
        this.saida = saida;
        this.veiculo = veiculo;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
}
