package ProgramacaoFuncExpressoesLamb.Demo03;

import java.util.function.Consumer;

public class AtualizarPreco implements Consumer<Produto> {

    @Override
    public void accept(Produto p) {
        p.setPreco(p.getPreco() * 1.1);
    }
}
