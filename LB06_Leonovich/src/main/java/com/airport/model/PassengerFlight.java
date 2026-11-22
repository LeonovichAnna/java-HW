package com.airport.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PassengerFlight extends Flight {
    private static final Logger logger = LogManager.getLogger(PassengerFlight.class);

    private int passengerCapacity;
    private int currentPassengers;

    public PassengerFlight(String flightNumber, String destination, String vesselBrand,
                           double emptyWeight, double averageFlightTime,
                           int passengerCapacity) {
        super(flightNumber, destination, vesselBrand, emptyWeight, averageFlightTime);
        this.passengerCapacity = passengerCapacity;
        this.currentPassengers = 0;
        logger.debug("Пассажирский рейс {} создан, вместимость: {}", flightNumber, passengerCapacity);
    }

    public int getPassengerCapacity() { return passengerCapacity; }
    public void setPassengerCapacity(int passengerCapacity) { this.passengerCapacity = passengerCapacity; }

    public int getCurrentPassengers() { return currentPassengers; }

    // дополнительная возможность: посадка пассажиров
    public void boardPassengers(int count) {
        if (count <= 0) {
            logger.error("Попытка посадить недопустимое число пассажиров: {}", count);
            return;
        }
        if (currentPassengers + count <= passengerCapacity) {
            currentPassengers += count;
            logger.info("На рейс {} посажено {} пассажиров, всего: {}",
                    flightNumber, count, currentPassengers);
        } else {
            logger.warn("Недостаточно мест на рейсе {}, свободно: {}",
                    flightNumber, passengerCapacity - currentPassengers);
        }
    }

    // дополнительная возможность: высадка пассажиров
    public void disembarkPassengers() {
        logger.info("Рейс {}: высажено {} пассажиров", flightNumber, currentPassengers);
        currentPassengers = 0;
    }

    @Override
    public String getCargoInfo() {
        return String.format("Пассажирский рейс %s: пассажиров %d из %d",
                flightNumber, currentPassengers, passengerCapacity);
    }
}