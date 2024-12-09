package com.pbcompass.mscreditassessor.domain.model;

public class DataEvaluation {
    private String cpf;
    private Long income;

    public DataEvaluation(){}

    public DataEvaluation(String cpf, Long income) {
        this.cpf = cpf;
        this.income = income;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }
}
