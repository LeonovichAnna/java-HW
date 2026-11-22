package com.airport.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CargoFlight extends Flight {
    private static final Logger logger = LogManager.getLogger(CargoFlight.class);

    private CargoType cargoType;
    private double maxCargoWeight;

    public CargoFlight(String flightNumber, String destination, String vesselBrand,
                       double emptyWeight, double averageFlightTime,
                       CargoType cargoType, double maxCargoWeight) {
        super(flightNumber, destination, vesselBrand, emptyWeight, averageFlightTime);
        this.cargoType = cargoType;
        this.maxCargoWeight = maxCargoWeight;
        logger.debug("Грузовой рейс {} создан, тип груза: {}", flightNumber, cargoType);
    }

    public CargoType getCargoType() { return cargoType; }
    public void setCargoType(CargoType cargoType) { this.cargoType = cargoType; }

    public double getMaxCargoWeight() { return maxCargoWeight; }
    public void setMaxCargoWeight(double maxCargoWeight) { this.maxCargoWeight = maxCargoWeight; }

    public boolean isSpecialCargo() {
        return cargoType == CargoType.FRAGILE || cargoType == CargoType.VALUABLE;
    }

    @Override
    public String getCargoInfo() {
        return String.format("Грузовой рейс %s: тип груза %s, макс. вес %.1f кг, хрупкий/ценный: %s",
                flightNumber, cargoType, maxCargoWeight, isSpecialCargo());
    }
}