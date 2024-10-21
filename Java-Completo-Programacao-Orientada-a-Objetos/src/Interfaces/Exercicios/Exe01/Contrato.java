package Interfaces.Exercicios.Exe01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {
    private Integer numeroContrato;
    private LocalDate data;
    private Double valorTotal;

    private List<Parcela> listaParcelas = new ArrayList();

    public Contrato(Integer numeroContrato, LocalDate data, Double valorTotal) {
        this.numeroContrato = numeroContrato;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Integer getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(Integer numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Parcela> getListaParcelas() {
        return listaParcelas;
    }
}
