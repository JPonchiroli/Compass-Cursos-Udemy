package com.pbcompass.mscreditassessor.domain.model;

import java.math.BigDecimal;

public class DataSolicitationEmissionCard {

    private Long idCard;
    private String cpf;
    private String address;
    private BigDecimal approvedLimit;

    public DataSolicitationEmissionCard(){}

    public DataSolicitationEmissionCard(Long idCard, String cpf, String address, BigDecimal approvedLimit) {
        this.idCard = idCard;
        this.cpf = cpf;
        this.address = address;
        this.approvedLimit = approvedLimit;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getApprovedLimit() {
        return approvedLimit;
    }

    public void setApprovedLimit(BigDecimal approvedLimit) {
        this.approvedLimit = approvedLimit;
    }
}
