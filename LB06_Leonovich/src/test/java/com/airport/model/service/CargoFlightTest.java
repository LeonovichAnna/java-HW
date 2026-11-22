package com.airport.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoFlightTest {

    @Test
    void shouldIdentifyFragileCargoAsSpecial() {
        CargoFlight f = new CargoFlight("C-1", "A", "B", 1000, 60,
                CargoType.FRAGILE, 5000);
        assertTrue(f.isSpecialCargo());
    }

    @Test
    void shouldIdentifyValuableCargoAsSpecial() {
        CargoFlight f = new CargoFlight("C-2", "A", "B", 1000, 60,
                CargoType.VALUABLE, 5000);
        assertTrue(f.isSpecialCargo());
    }

    @Test
    void shouldIdentifyStandardCargoAsNotSpecial() {
        CargoFlight f = new CargoFlight("C-3", "A", "B", 1000, 60,
                CargoType.STANDARD, 5000);
        assertFalse(f.isSpecialCargo());
    }

    @Test
    void shouldReturnCargoInfoContainingType() {
        CargoFlight f = new CargoFlight("C-4", "A", "B", 1000, 60,
                CargoType.VALUABLE, 5000);
        String info = f.getCargoInfo();
        assertTrue(info.contains("VALUABLE"));
        assertTrue(info.contains("C-4"));
    }
}