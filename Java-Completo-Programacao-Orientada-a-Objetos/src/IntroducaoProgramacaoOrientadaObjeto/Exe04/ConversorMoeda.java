package IntroducaoProgramacaoOrientadaObjeto.Exe04;

public class ConversorMoeda {
    public static final double IOF = 0.06;

    public static double converterDolarParaReais(double precoDolar, double qtdDolarComprado){
        qtdDolarComprado += (qtdDolarComprado * IOF);
        return precoDolar * qtdDolarComprado;
    }


}
