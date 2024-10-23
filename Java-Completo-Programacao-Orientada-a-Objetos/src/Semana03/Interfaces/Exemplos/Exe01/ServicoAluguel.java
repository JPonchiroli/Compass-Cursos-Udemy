package Semana03.Interfaces.Exemplos.Exe01;

import java.time.Duration;

public class ServicoAluguel {
    private double precoPorHora;
    private double precoPorDia;

    private ServicoTaxa servicoTaxa;

    public ServicoAluguel(double precoPorHora, double precoPorDia, ServicoTaxa servicoTaxa) {
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
        this.servicoTaxa = servicoTaxa;
    }

    public void processarFatura(AluguelVeiculo aluguelVeiculo){
        double minutos = Duration.between(aluguelVeiculo.getEntrada(), aluguelVeiculo.getSaida()).toMinutes();
        double horas = minutos / 60;

        double pagamentoBasico;

        if (horas <= 12){
            pagamentoBasico = precoPorHora * Math.ceil(horas);
        } else {
            pagamentoBasico = precoPorDia * Math.ceil(horas / 24);
        }

        double taxa = servicoTaxa.taxa(pagamentoBasico);

        aluguelVeiculo.setFatura(new Fatura(pagamentoBasico, taxa));
    }
}
