package org.example;

import java.util.*;

public class CircleManager {
    private final List<Circle> circles;

    public CircleManager(List<Circle> circles) { // Конструктор, готовый список окружностей сохраняет
        this.circles = circles;
    }

    // Ищем группы окружностей, центры которых лежат на одной прямой
    public List<List<Circle>> findCollinearGroups() {
        List<List<Circle>> resultGroups = new ArrayList<>();
        Set<String> processedTriples = new HashSet<>(); // Чтобы не хранить одинаковые группы

        for (int i = 0; i < circles.size(); i++) {
            for (int j = i + 1; j < circles.size(); j++) {
                for (int k = j + 1; k < circles.size(); k++) {
                    Circle c1 = circles.get(i);
                    Circle c2 = circles.get(j);
                    Circle c3 = circles.get(k);

                    if (areCollinear(c1, c2, c3)) {
                        // создаем ключ, чтобы понять, обрабатывали ли мы уже эту тройку
                        String key = i + "-" + j + "-" + k;
                        if (!processedTriples.contains(key)) {
                            List<Circle> group = new ArrayList<>();
                            group.add(c1);
                            group.add(c2);
                            group.add(c3);
                            resultGroups.add(group);
                            processedTriples.add(key);
                        }
                    }
                }
            }
        }
        return resultGroups;
    }

    // Проверка на коллинеарность (лежат ли 3 точки на одной прямой)
    private boolean areCollinear(Circle c1, Circle c2, Circle c3) {
        double x1 = c1.getX().toDouble();
        double y1 = c1.getY().toDouble();
        double x2 = c2.getX().toDouble();
        double y2 = c2.getY().toDouble();
        double x3 = c3.getX().toDouble();
        double y3 = c3.getY().toDouble();

        // Векторное произведение (x2-x1)*(y3-y1) - (x3-x1)*(y2-y1) должно быть = 0
        double left = (x2 - x1) * (y3 - y1);
        double right = (x3 - x1) * (y2 - y1);

        return Math.abs(left - right) < 0.000001;
    }

    public Circle findMaxAreaCircle() {
        return Collections.max(circles, Comparator.comparingDouble(Circle::getArea));
    }

    public Circle findMinAreaCircle() {
        return Collections.min(circles, Comparator.comparingDouble(Circle::getArea));
    }

    public Circle findMaxPerimeterCircle() {
        return Collections.max(circles, Comparator.comparingDouble(Circle::getPerimeter));
    }

    public Circle findMinPerimeterCircle() {
        return Collections.min(circles, Comparator.comparingDouble(Circle::getPerimeter));
    }
}