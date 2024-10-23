package ProgramacaoFuncExpressoesLamb.Function;

import java.util.function.Function;

public class NomeCaixaAlta implements Function<Produto, String>{
    @Override
    public String apply(Produto p) {
        return p.getNome().toUpperCase();
    }
}
