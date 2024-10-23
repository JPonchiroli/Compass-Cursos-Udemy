package Interfaces.Exercicios.Exe01;

public interface ServicoPagamentoOnline {
    double taxaDePagamento(double valor);

    double jurosSimpes(double valor, int meses);
}
