package com.pbcompass.msclients.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;
    @Column
    private String name;
    @Column
    private Integer age;

    public Client(String cpf, String name, Integer age) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
