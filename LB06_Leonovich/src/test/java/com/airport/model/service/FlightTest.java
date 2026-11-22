package com.airport.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    private CargoFlight flight;

    @BeforeEach
    void setUp() {
        flight = new CargoFlight("T-1", "Тест", "TestBrand", 1000, 60,
                CargoType.STANDARD, 5000);
    }

    @Test
    void shouldCreateFlightWithReadyStatus() {
        assertEquals(FlightStatus.READY, flight.getStatus());
        assertEquals(0, flight.getFuelAmount());
    }

    @Test
    void shouldSendToDestinationWhenReady() {
        flight.sendToDestination();
        assertEquals(FlightStatus.IN_FLIGHT, flight.getStatus());
    }

    @Test
    void shouldNotSendToDestinationWhenNotReady() {
        flight.setStatus(FlightStatus.NEEDS_REPAIR);
        flight.sendToDestination();
        assertEquals(FlightStatus.NEEDS_REPAIR, flight.getStatus());
    }

    @Test
    void shouldRepairAndBecomeReady() {
        flight.setStatus(FlightStatus.NEEDS_REPAIR);
        flight.repair();
        assertEquals(FlightStatus.READY, flight.getStatus());
    }

    @Test
    void shouldRefuelWhenReady() {
        flight.refuel(500);
        assertEquals(500, flight.getFuelAmount(), 0.001);
    }

    @Test
    void shouldNotRefuelWithNegativeAmount() {
        flight.refuel(-100);
        assertEquals(0, flight.getFuelAmount(), 0.001);
    }

    @Test
    void shouldLoadWhenReady() {
        flight.load();
        assertEquals(FlightStatus.LOADING, flight.getStatus());
    }

    @Test
    void shouldUnloadWhenLoading() {
        flight.load();
        flight.unload();
        assertEquals(FlightStatus.UNLOADING, flight.getStatus());
    }

    @Test
    void shouldUpdateFlightNumber() {
        flight.setFlightNumber("NEW-999");
        assertEquals("NEW-999", flight.getFlightNumber());
    }
}