package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircleTest {

    @Test
    public void testRationalCreation() {
        Rational r = new Rational(2, 4);
        assertEquals(1, r.getNumerator());
        assertEquals(2, r.getDenominator());
    }

    @Test
    public void testRationalZeroDenominator() {
        //assertThrows(типожидаемогоисключения - класс, децйствие)
        assertThrows(IllegalArgumentException.class, () -> new Rational(1, 0));
    }

    @Test
    public void testCircleArea() {
        Circle c = new Circle(new Rational(0, 1), new Rational(0, 1), 2.0);
        // Площадь = PI * 4
        assertEquals(Math.PI * 4, c.getArea(), 0.0001);
    }

    @Test
    public void testCirclePerimeter() {
        Circle c = new Circle(new Rational(0, 1), new Rational(0, 1), 2.0);
        // Периметр = 2 * PI * 2 = 4 * PI
        assertEquals(4 * Math.PI, c.getPerimeter(), 0.0001);
    }

    @Test
    public void testCollinearGroups() {
        java.util.List<Circle> list = new java.util.ArrayList<>();
        // Точки (0,0), (1,1), (2,2) лежат на прямой y=x
        list.add(new Circle(new Rational(0, 1), new Rational(0, 1), 1));
        list.add(new Circle(new Rational(1, 1), new Rational(1, 1), 1));
        list.add(new Circle(new Rational(2, 1), new Rational(2, 1), 1));

        CircleManager manager = new CircleManager(list);
        assertFalse(manager.findCollinearGroups().isEmpty());
    }
}