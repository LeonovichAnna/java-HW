package service;

import model.LeafVegetable;
import model.RootVegetable;
import model.Salad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SaladServiceTest {

    @Test
    void testCalculateTotalCalories() {
        Salad salad = new Salad();
        salad.addVegetable(new RootVegetable("Carrot", 40, 100, 10)); // 40 ккал
        salad.addVegetable(new LeafVegetable("Cabbage", 20, 200, "Green")); // 40 ккал

        SaladService service = new SaladService();
        double total = service.calculateTotalCalories(salad);

        assertEquals(80.0, total, 0.001);
    }

    @Test
    void testFindByCaloriesRange() {
        Salad salad = new Salad();
        salad.addVegetable(new RootVegetable("Carrot", 10, 100, 10)); // 10 ккал
        salad.addVegetable(new LeafVegetable("Cabbage", 100, 100, "Green")); // 100 ккал

        SaladService service = new SaladService();
        var result = service.findByCaloriesRange(salad, 5.0, 50.0);

        assertEquals(1, result.size());
        assertEquals("Carrot", result.get(0).getName());
    }
}
