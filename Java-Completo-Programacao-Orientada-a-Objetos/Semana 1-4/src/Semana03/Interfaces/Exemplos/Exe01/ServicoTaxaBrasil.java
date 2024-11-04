package Semana03.Interfaces.Exemplos.Exe01;

public class ServicoTaxaBrasil implements ServicoTaxa{
    public double taxa(double valor){
        if(valor <= 100.0){
            return valor * 0.2;
        }

        return valor * 0.15;
    }
}
