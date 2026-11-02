package service;

import model.Salad;
import model.Vegetable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SaladService {

    // Подсчет общей калорийности салата
    public double calculateTotalCalories(Salad salad) {
        return salad.getVegetables().stream()
                .mapToDouble(Vegetable::calculateTotalCalories)
                .sum();
    }

    // Сортировка овощей в салате на основе Comparator (по весу)
    public void sortByWeight(Salad salad) {
        // Используем лямбду вместо ссылки на метод, чтобы Java точно поняла тип Vegetable
        salad.getVegetables().sort((v1, v2) -> Double.compare(v1.getWeight(), v2.getWeight()));
    }

    // Поиск овощей в заданном диапазоне калорийности
    public List<Vegetable> findByCaloriesRange(Salad salad, double minCalories, double maxCalories) {
        List<Vegetable> result = new ArrayList<>();
        for (Vegetable v : salad.getVegetables()) {
            double total = v.calculateTotalCalories();
            if (total >= minCalories && total <= maxCalories) {
                result.add(v);
            }
        }
        return result;
    }
}