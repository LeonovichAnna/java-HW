package com.airport.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Flight {
    private static final Logger logger = LogManager.getLogger(Flight.class);

    protected String flightNumber;
    protected String destination;
    protected String vesselBrand;
    protected FlightStatus status;
    protected double emptyWeight;      // снаряженная масса, кг
    protected double fuelAmount;       // топливо, литры
    protected double averageFlightTime; // среднее время рейса, минуты

    public Flight(String flightNumber, String destination, String vesselBrand,
                  double emptyWeight, double averageFlightTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.vesselBrand = vesselBrand;
        this.emptyWeight = emptyWeight;
        this.averageFlightTime = averageFlightTime;
        this.status = FlightStatus.READY;
        this.fuelAmount = 0;
        logger.info("Создан рейс {} в направлении {}", flightNumber, destination);
    }

    // геттеры и сеттеры для основных полей
    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getVesselBrand() { return vesselBrand; }
    public void setVesselBrand(String vesselBrand) { this.vesselBrand = vesselBrand; }

    public FlightStatus getStatus() { return status; }
    public void setStatus(FlightStatus status) { this.status = status; }

    public double getEmptyWeight() { return emptyWeight; }
    public void setEmptyWeight(double emptyWeight) { this.emptyWeight = emptyWeight; }

    public double getFuelAmount() { return fuelAmount; }
    public void setFuelAmount(double fuelAmount) { this.fuelAmount = fuelAmount; }

    public double getAverageFlightTime() { return averageFlightTime; }
    public void setAverageFlightTime(double averageFlightTime) { this.averageFlightTime = averageFlightTime; }

    // операции
    public void sendToDestination() {
        if (status == FlightStatus.READY) {
            status = FlightStatus.IN_FLIGHT;
            logger.info("Рейс {} отправлен в {}", flightNumber, destination);
        } else {
            logger.warn("Рейс {} не готов к вылету, текущий статус: {}", flightNumber, status);
        }
    }

    public void repair() {
        if (status == FlightStatus.NEEDS_REPAIR || status == FlightStatus.IN_REPAIR) {
            status = FlightStatus.READY;
            logger.info("Рейс {} отремонтирован и готов", flightNumber);
        } else {
            logger.warn("Рейс {} не требует ремонта, статус: {}", flightNumber, status);
        }
    }

    public void refuel(double amount) {
        if (amount <= 0) {
            logger.error("Попытка заправки недопустимым количеством: {}", amount);
            return;
        }
        if (status == FlightStatus.REFUELING || status == FlightStatus.READY) {
            fuelAmount += amount;
            status = FlightStatus.READY;
            logger.info("Рейс {} заправлен на {} л, всего: {} л", flightNumber, amount, fuelAmount);
        } else {
            logger.warn("Заправка невозможна, статус рейса {}: {}", flightNumber, status);
        }
    }

    public void load() {
        if (status == FlightStatus.READY || status == FlightStatus.LOADING) {
            status = FlightStatus.LOADING;
            logger.info("Рейс {}开始 загрузку", flightNumber);
        } else {
            logger.warn("Загрузка невозможна для рейса {} в статусе {}", flightNumber, status);
        }
    }

    public void unload() {
        if (status == FlightStatus.LOADING || status == FlightStatus.UNLOADING
                || status == FlightStatus.IN_FLIGHT) {
            status = FlightStatus.UNLOADING;
            logger.info("Рейс {}开始 разгрузку", flightNumber);
        } else {
            logger.warn("Разгрузка невозможна для рейса {} в статусе {}", flightNumber, status);
        }
    }

    // абстрактный метод — каждый тип рейса возвращает свою информацию о грузе
    public abstract String getCargoInfo();
}