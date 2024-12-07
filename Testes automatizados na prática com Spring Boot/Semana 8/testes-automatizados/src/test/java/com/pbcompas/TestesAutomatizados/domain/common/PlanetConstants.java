package com.pbcompas.TestesAutomatizados.domain.common;

import com.pbcompas.TestesAutomatizados.domain.Planet;

public class PlanetConstants {
    public static final Planet PLANET = new Planet("Terra", "Tropical", "Fertil");
    public static final Planet INVALID_PLANET = new Planet("", "", "");
}
