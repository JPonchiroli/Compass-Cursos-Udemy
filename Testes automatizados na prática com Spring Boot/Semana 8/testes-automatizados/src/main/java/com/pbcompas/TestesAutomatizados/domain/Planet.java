package com.pbcompas.TestesAutomatizados.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String climate;
    private String terrain;

    public Planet(String name, String climate, String terrain) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    @Override
    public boolean equals(Object obj){
        return EqualsBuilder.reflectionEquals(obj, this);
    }

}
