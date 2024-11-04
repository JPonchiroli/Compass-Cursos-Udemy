package Semana02.EnumeracoesEComposicoes.Exercicio.Exe03;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
    private String nome;
    private String email;
    private Date dataAniversario;

    public Cliente(){}

    public Cliente(String nome, String email, Date dataAniversario) {
        this.nome = nome;
        this.email = email;
        this.dataAniversario = dataAniversario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
}
