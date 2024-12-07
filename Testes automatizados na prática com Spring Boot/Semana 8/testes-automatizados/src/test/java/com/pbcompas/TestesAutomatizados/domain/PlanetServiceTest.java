package com.pbcompas.TestesAutomatizados.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import static org.assertj.core.api.Assertions.assertThat;
import static com.pbcompas.TestesAutomatizados.domain.common.PlanetConstants.PLANET;
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
}
