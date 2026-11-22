package com.airport.service;

import com.airport.model.Flight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightService {
    private static final Logger logger = LogManager.getLogger(FlightService.class);

    private final List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        if (flight == null) {
            logger.error("Попытка добавить null-рейс");
            return;
        }
        flights.add(flight);
        logger.info("В систему добавлен рейс {}", flight.getFlightNumber());
    }

    public Optional<Flight> findByNumber(String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equals(flightNumber))
                .findFirst();
    }

    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights);
    }

    // среднее время по всем рейсам
    public double getAverageFlightTimeAcrossAll() {
        if (flights.isEmpty()) {
            logger.warn("Список рейсов пуст, среднее время не вычислено");
            return 0;
        }
        double avg = flights.stream()
                .mapToDouble(Flight::getAverageFlightTime)
                .average()
                .orElse(0);
        logger.debug("Среднее время по всем рейсам: {}", avg);
        return avg;
    }

    // общее количество топлива во всех рейсах
    public double getTotalFuel() {
        double total = flights.stream().mapToDouble(Flight::getFuelAmount).sum();
        logger.debug("Общее количество топлива: {}", total);
        return total;
    }
}