package com.pbcompas.TestesAutomatizados.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository repository;

    public Planet create(Planet planet){
        return repository.save(planet);
    }

    public Optional<Planet> findById(Long id){
        return repository.findById(id);
    }

    public Optional<Planet> findByName(String name){
        return repository.findByName(name);
    }

    public List<Planet> findAll(String terrain, String climate){
        Example<Planet> query = QueryBuilder.makeQuery(new Planet(climate, terrain));
        return repository.findAll(query);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
