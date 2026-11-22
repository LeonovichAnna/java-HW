package com.airport.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerFlightTest {

    private PassengerFlight flight;

    @BeforeEach
    void setUp() {
        flight = new PassengerFlight("P-1", "A", "B", 5000, 90, 100);
    }

    @Test
    void shouldBoardPassengersWithinCapacity() {
        flight.boardPassengers(50);
        assertEquals(50, flight.getCurrentPassengers());
    }

    @Test
    void shouldNotBoardExceedingCapacity() {
        flight.boardPassengers(150);
        assertEquals(0, flight.getCurrentPassengers());
    }

    @Test
    void shouldNotBoardNegativeOrZero() {
        flight.boardPassengers(-5);
        assertEquals(0, flight.getCurrentPassengers());
        flight.boardPassengers(0);
        assertEquals(0, flight.getCurrentPassengers());
    }

    @Test
    void shouldDisembarkAllPassengers() {
        flight.boardPassengers(80);
        flight.disembarkPassengers();
        assertEquals(0, flight.getCurrentPassengers());
    }

    @Test
    void shouldReturnPassengerInfo() {
        flight.boardPassengers(30);
        String info = flight.getCargoInfo();
        assertTrue(info.contains("30"));
        assertTrue(info.contains("100"));
    }
}