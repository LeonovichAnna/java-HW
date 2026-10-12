package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Circle> circles = new ArrayList<>();

        // Создаем окружности.
        // Для проверки групп сделаем так, чтобы несколько центров лежали на одной прямой.
        // Например, на прямой y = x:
        circles.add(new Circle(new Rational(1, 1), new Rational(1, 1), 5.0)); // (1, 1)
        circles.add(new Circle(new Rational(2, 1), new Rational(2, 1), 3.0)); // (2, 2)
        circles.add(new Circle(new Rational(3, 1), new Rational(3, 1), 7.0)); // (3, 3)
        // И одна в стороне:
        circles.add(new Circle(new Rational(10, 1), new Rational(5, 1), 2.0)); // (10, 5)

        CircleManager manager = new CircleManager(circles);

        System.out.println("Все окружности:");
        circles.forEach(System.out::println);

        System.out.println("\nГруппы окружностей на одной прямой:");
        List<List<Circle>> groups = manager.findCollinearGroups();

        if (groups.isEmpty()) { // если список пустой то true
            System.out.println("Групп не найдено");
        } else {
            int groupNum = 1;
            for (List<Circle> group : groups) {
                System.out.println("Группа " + groupNum + ":");
                for (Circle c : group) {
                    System.out.println("  " + c);
                }
                groupNum++;
            }
        }

        System.out.println("\nСтатистика:");
        System.out.println("Макс. площадь: " + manager.findMaxAreaCircle());
        System.out.println("Мин. площадь: " + manager.findMinAreaCircle());
        System.out.println("Макс. периметр: " + manager.findMaxPerimeterCircle());
        System.out.println("Мин. периметр: " + manager.findMinPerimeterCircle());
    }
}