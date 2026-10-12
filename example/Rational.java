package org.example;

import java.util.Objects;

public class Rational {
    private final int numerator;   // Числитель // final как const
    private final int denominator; // Знаменатель

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        // делаем минус всегда в числителе
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        // НОД, упрощение дроби
        int gcd = gcd(Math.abs(numerator), denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    // Наибольший общий делитель (по алгоритму Евклида)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Переводим в double для вычислений площади и периметра
    public double toDouble() {
        return (double) numerator / denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}