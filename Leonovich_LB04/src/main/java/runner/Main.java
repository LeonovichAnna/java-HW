package runner;

import factory.VegetableFactory;
import model.Salad;
import model.Vegetable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.SaladService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Запуск программы 'Шеф-повар'");

        Salad salad = new Salad();
        SaladService service = new SaladService();

        // 1. Чтение данных из текстового файла (.txt)
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Lenovo\\IdeaProjects\\LB03_Leonovich\\Leonovich_LB04\\vegetables.txt"));
            for (String line : lines) {
                Vegetable v = VegetableFactory.createVegetable(line);
                if (v != null) {
                    salad.addVegetable(v);
                }
            }
        }
        catch (IOException e) {
            // Демонстрация ERROR (красный цвет)
            logger.error("Не удалось прочитать файл с данными: vegetables.txt. Проверьте, что он лежит в корне проекта!", e);
        }

        // Если салат пустой, выведем WARN (желтый цвет)
        if (salad.getVegetables().isEmpty()) {
            logger.warn("Внимание: Салат остался пустым! Проверьте содержимое файла vegetables.txt.");
        }

        logger.info("Все овощи в салате");
        for (Vegetable v : salad.getVegetables()) {
            logger.info("{}", v);
        }

        // 2. Подсчет калорийности
        double totalCalories = service.calculateTotalCalories(salad);
        logger.info("Общая калорийность салата: {} ккал", String.format("%.2f", totalCalories));

        // 3. Сортировка овощей (по весу)
        service.sortByWeight(salad);
        logger.info("Овощи после сортировки по весу");
        for (Vegetable v : salad.getVegetables()) {
            logger.info("{}", v);
        }

        // 4. Поиск по диапазону калорий
        double min = 10.0;
        double max = 50.0;
        List<Vegetable> filtered = service.findByCaloriesRange(salad, min, max);

        logger.info("Овощи в диапазоне калорий от {} до {}", min, max);
        if (filtered.isEmpty()) {
            // Еще один пример WARN (желтый цвет)
            logger.warn("Ни один овощ не попал в диапазон от {} до {} ккал!", min, max);
        } else {
            for (Vegetable v : filtered) {
                logger.info("{}", v);
            }
        }

        logger.info("Работа программы завершена");
    }
}