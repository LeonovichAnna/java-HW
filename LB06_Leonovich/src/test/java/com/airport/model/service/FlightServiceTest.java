package com.airport.service;

import com.airport.model.CargoFlight;
import com.airport.model.CargoType;
import com.airport.model.Flight;
import com.airport.model.PassengerFlight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTest {

    private FlightService service;

    @BeforeEach
    void setUp() {
        service = new FlightService();
    }

    @Test
    void shouldAddFlightAndFindByNumber() {
        Flight f = new CargoFlight("A-1", "X", "Y", 1000, 60, CargoType.STANDARD, 5000);
        service.addFlight(f);

        Optional<Flight> found = service.findByNumber("A-1");
        assertTrue(found.isPresent());
        assertEquals("A-1", found.get().getFlightNumber());
    }

    @Test
    void shouldReturnEmptyWhenFlightNotFound() {
        assertTrue(service.findByNumber("NONE").isEmpty());
    }

    @Test
    void shouldNotAddNullFlight() {
        service.addFlight(null);
        assertTrue(service.getAllFlights().isEmpty());
    }

    @Test
    void shouldCalculateAverageFlightTime() {
        service.addFlight(new CargoFlight("A", "X", "Y", 1000, 60, CargoType.STANDARD, 1000));
        service.addFlight(new PassengerFlight("B", "X", "Y", 1000, 120, 100));

        assertEquals(90, service.getAverageFlightTimeAcrossAll(), 0.001);
    }

    @Test
    void shouldReturnZeroAverageForEmptyList() {
        assertEquals(0, service.getAverageFlightTimeAcrossAll(), 0.001);
    }

    @Test
    void shouldCalculateTotalFuel() {
        Flight f1 = new CargoFlight("A", "X", "Y", 1000, 60, CargoType.STANDARD, 1000);
        f1.refuel(500);
        Flight f2 = new PassengerFlight("B", "X", "Y", 1000, 60, 100);
        f2.refuel(300);

        service.addFlight(f1);
        service.addFlight(f2);

        assertEquals(800, service.getTotalFuel(), 0.001);
    }

    @Test
    void shouldReturnEmptyListInitially() {
        List<Flight> all = service.getAllFlights();
        assertTrue(all.isEmpty());
    }
}