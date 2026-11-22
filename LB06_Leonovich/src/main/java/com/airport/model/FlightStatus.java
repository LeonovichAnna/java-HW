package com.airport.model;

public enum FlightStatus {
    LOADING,       // загрузка
    UNLOADING,     // разгрузка
    REFUELING,     // заправка
    IN_FLIGHT,     // в пути
    IN_REPAIR,     // в ремонте
    READY,         // готов к вылету
    NEEDS_REPAIR   // требуется ремонт
}