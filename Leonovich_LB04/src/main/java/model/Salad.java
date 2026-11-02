package model;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private List<Vegetable> vegetables = new ArrayList<>();

    public void addVegetable (Vegetable vegetable) {
        vegetables.add(vegetable);
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }
}
