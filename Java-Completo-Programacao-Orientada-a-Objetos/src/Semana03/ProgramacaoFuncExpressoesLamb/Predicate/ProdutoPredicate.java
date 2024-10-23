package Semana03.ProgramacaoFuncExpressoesLamb.Predicate;

import java.util.function.Predicate;

public class ProdutoPredicate implements Predicate<Produto> {
    @Override
    public boolean test(Produto p) {
        return p.getPreco() >= 100;
    }
}
