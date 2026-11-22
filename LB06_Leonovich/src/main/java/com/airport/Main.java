package com.airport;

import com.airport.model.*;
import com.airport.service.FlightService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Запуск системы управления авиарейсами");

        FlightService service = new FlightService();

        // грузовой рейс
        CargoFlight cargo = new CargoFlight("CF-101", "Москва", "Boeing 747F",
                180000, 180, CargoType.FRAGILE, 100000);
        cargo.load();
        cargo.refuel(50000);
        cargo.sendToDestination();

        // пассажирский рейс
        PassengerFlight passenger = new PassengerFlight("PF-202", "Санкт-Петербург",
                "Airbus A320", 42000, 95, 180);
        passenger.boardPassengers(150);
        passenger.load();
        passenger.refuel(8000);
        passenger.sendToDestination();

        service.addFlight(cargo);
        service.addFlight(passenger);

        logger.info("Информация о грузе: {}", cargo.getCargoInfo());
        logger.info("Информация о пассажирах: {}", passenger.getCargoInfo());
        logger.info("Среднее время рейсов: {} мин", service.getAverageFlightTimeAcrossAll());
        logger.info("Общее топливо: {} л", service.getTotalFuel());

        // демонстрация разных уровней логирования
        logger.debug("Отладочное сообщение — видно в консоли и info-файле");
        logger.warn("Предупреждение — видно в warn-файле");
        logger.error("Ошибка — видно в error-файле");

        logger.info("завершение работы");
    }
}