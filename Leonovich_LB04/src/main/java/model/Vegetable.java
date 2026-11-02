package model;

public abstract class Vegetable {
    private String name;
    private double caloriesPer100g;
    private double weight; // в граммах

    public Vegetable(String name, double caloriesPer100g, double weight) {
        this.name = name;
        this.caloriesPer100g = caloriesPer100g;
        this.weight = weight;
    }

    public double calculateTotalCalories() {
        return (caloriesPer100g * weight) / 100.0;
    }

    // Обязательно с модификатором public, чтобы другие пакеты могли их читать!
    public String getName() {
        return name;
    }

    public double getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%s (вес: %.1fг, калории: %.1f ккал)", name, weight, calculateTotalCalories());
    }
}