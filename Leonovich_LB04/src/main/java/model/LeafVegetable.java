package model;

public class LeafVegetable extends Vegetable {
    private String leafColor;

    public LeafVegetable(String name, double caloriesPer100g, double weight, String leafColor) {
        super(name, caloriesPer100g, weight);
        this.leafColor = leafColor;
    }

    public String getLeafColor() { return leafColor; }
}
