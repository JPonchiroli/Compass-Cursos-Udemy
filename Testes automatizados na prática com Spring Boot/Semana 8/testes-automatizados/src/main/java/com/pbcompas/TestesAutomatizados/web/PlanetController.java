package com.pbcompas.TestesAutomatizados.web;

import com.pbcompas.TestesAutomatizados.domain.Planet;
import com.pbcompas.TestesAutomatizados.domain.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetService service;

    @PostMapping
    public ResponseEntity<Planet> create(@RequestBody Planet planet){
        Planet planetCreated = service.create(planet);
        return ResponseEntity.status(HttpStatus.CREATED).body(planetCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> findById(@PathVariable("id")  Long id) {
        return service.findById(id).map(planet -> ResponseEntity.ok(planet))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Planet> findByName(@PathVariable("name") String name){
        return service.findByName(name).map(planet -> ResponseEntity.ok(planet))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Planet>> findAll(@RequestParam(required = false) String terrain,
                                                @RequestParam(required = false) String climate){
        List<Planet> planets = service.findAll(terrain, climate);
        return ResponseEntity.ok(planets);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
