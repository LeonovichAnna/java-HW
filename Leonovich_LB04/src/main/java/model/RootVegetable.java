package model;

public class RootVegetable extends Vegetable {
    private int rootDepth;

    public RootVegetable(String name, double caloriesPer100g, double weight, int rootDepth) {
        super(name, caloriesPer100g, weight);
        this.rootDepth = rootDepth;
    }

    public int getRootDepth() { return rootDepth; }
}
