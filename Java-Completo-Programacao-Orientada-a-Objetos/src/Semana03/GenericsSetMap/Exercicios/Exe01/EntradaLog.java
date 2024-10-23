package GenericsSetMap.Exercicios.Exe01;

import java.util.Date;
import java.util.Objects;

public class EntradaLog {
    private String nome;
    private Date momento;

    public EntradaLog(String nome, Date momento) {
        this.nome = nome;
        this.momento = momento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntradaLog that = (EntradaLog) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
