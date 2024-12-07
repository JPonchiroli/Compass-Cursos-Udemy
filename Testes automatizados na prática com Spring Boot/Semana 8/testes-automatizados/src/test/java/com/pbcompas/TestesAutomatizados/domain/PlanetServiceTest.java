package com.pbcompas.TestesAutomatizados.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;

import java.util.*;

import static com.pbcompas.TestesAutomatizados.domain.common.PlanetConstants.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlanetServiceTest {

    @InjectMocks
    private PlanetService service;

    @Mock
    private PlanetRepository repository;

    @Test
    public void createPlanet_withValidData_returnsPlanet(){
        when(repository.save(PLANET)).thenReturn(PLANET);
        Planet sut = service.create(PLANET);
        assertThat(sut).isEqualTo(PLANET);
    }

    @Test
    public void createPlanet_withInvalidData_throwsException(){
        when(repository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);
        assertThatThrownBy(() -> service.create(INVALID_PLANET)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void findPlanet_byExistingId_returnsPlanet(){
        when(repository.findById(anyLong())).thenReturn(Optional.of(PLANET));

        Optional<Planet> sut = service.findById(1L);

        assertThat(sut).isNotEmpty();
        assertThat(sut.get()).isEqualTo(PLANET);
    }


    @Test
    public void findPlanet_byUnexistingId_returnsEmpty(){
        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        Optional<Planet> sut = service.findById(1L);

        assertThat(sut).isEmpty();
    }

    @Test
    public void findPlanet_byExistingName_returnsPlanet(){
        when(repository.findByName(anyString())).thenReturn(Optional.of(PLANET));

        Optional<Planet> sut = service.findByName("Terra");

        assertThat(sut).isNotEmpty();
        assertThat(sut.get()).isEqualTo(PLANET);
    }


    @Test
    public void findPlanet_byUnexistingName_returnsEmpty(){
        final String name = "Unexisting name";
        when(repository.findByName(name)).thenReturn(Optional.empty());

        Optional<Planet> sut = service.findByName(name);

        assertThat(sut).isEmpty();
    }

    @Test
    public void listPlanets_ReturnsAllPlanets(){
        List<Planet> planets = new ArrayList<>(){
            {
                add(PLANET);
            }
        };
        Example<Planet> query = QueryBuilder.makeQuery(new Planet(PLANET.getClimate(), PLANET.getTerrain()));
        when(repository.findAll(query)).thenReturn(planets);

        List<Planet> sut = service.findAll(PLANET.getTerrain(), PLANET.getClimate());

        assertThat(sut).isNotEmpty();
        assertThat(sut).hasSize(1);
        assertThat(sut.get(0)).isEqualTo(PLANET);
    }

    @Test
    public void listPlanets_ReturnsNoPlanets(){
        when(repository.findAll(any())).thenReturn(Collections.emptyList());

        List<Planet> sut = service.findAll(PLANET.getTerrain(), PLANET.getClimate());

        assertThat(sut).isEmpty();
    }

    @Test
    public void deletePlanet_byExistingId_doesNotThrowAnyException() {
        assertThatCode(() -> service.deleteById(1L)).doesNotThrowAnyException();
    }


    @Test
    public void deletePlanet_byUnexistingId_throwException(){
        doThrow(new RuntimeException()).when(repository).deleteById(99L);
        assertThatThrownBy(() -> service.deleteById(99L)).isInstanceOf(RuntimeException.class);
    }
}
