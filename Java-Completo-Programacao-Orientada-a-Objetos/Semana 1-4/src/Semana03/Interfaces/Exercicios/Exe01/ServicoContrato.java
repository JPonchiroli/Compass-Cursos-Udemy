package Semana03.Interfaces.Exercicios.Exe01;

import java.time.LocalDate;

public class ServicoContrato {
    private ServicoPagamentoOnline servicoPagamentoOnline;

    public ServicoContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
        this.servicoPagamentoOnline = servicoPagamentoOnline;
    }

    public void processarContrato(Contrato contrato, Integer meses){
        double cotaBasica = contrato.getValorTotal() / meses;

        for (int i = 1; i <= meses; i++){
            LocalDate dataVencimento = contrato.getData().plusMonths(i);
            double jurosMensal = servicoPagamentoOnline.jurosSimpes(cotaBasica,i);
            double taxaPagamento = servicoPagamentoOnline.taxaDePagamento(cotaBasica + jurosMensal);
            double cotaFinal = cotaBasica + jurosMensal + taxaPagamento;
            contrato.getListaParcelas().add(new Parcela(dataVencimento, cotaFinal));
        }
    }
}
