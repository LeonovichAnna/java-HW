package org.example;

public class Circle {
    private final Rational x; // Координата X центра (дробь)
    private final Rational y; // Координата Y центра (дробь)
    private final double radius;

    public Circle(Rational x, Rational y, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть больше нуля");
        }
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Rational getX() {
        return x;
    }
    public Rational getY() {
        return y;
    }
    //public double getRadius() {
    //    return radius;
    //}

    // Площадь π * r^2
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Периметр (длина окружности) 2 * π * r
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Окружность(центр=(%s, %s), R=%.2f)", x, y, radius);
    }
}