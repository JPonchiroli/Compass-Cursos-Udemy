package Interfaces.Exercicios.Exe01;

public class ServicoPayPal implements ServicoPagamentoOnline{

    private final double TAXA_PAGAMENTO = 0.02;
    private final double JUROS_MENSAL = 0.01;

    @Override
    public double taxaDePagamento(double valor) {
        return valor * TAXA_PAGAMENTO;
    }

    @Override
    public double jurosSimpes(double valor, int meses) {
        return valor * JUROS_MENSAL * meses;
    }
}
