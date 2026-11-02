package factory;

import model.LeafVegetable;
import model.RootVegetable;
import model.Vegetable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VegetableFactory {
    private static final Logger logger = LogManager.getLogger(VegetableFactory.class);

    public static Vegetable createVegetable(String line) {
        if (line == null || line.trim().isEmpty()) {
            return null;
        }

        String[] parts = line.split(";");
        if (parts.length < 4) {
            // Демонстрация WARN (желтый цвет в логах) при неверном формате строки
            logger.warn("Пропущена некорректная строка (мало параметров): '{}'", line);
            return null;
        }

        try {
            String name = parts[0].trim();
            double calories = Double.parseDouble(parts[1].trim());
            double weight = Double.parseDouble(parts[2].trim());
            String extra = parts[3].trim();

            // Демонстрация ERROR (красный цвет в логах) при недопустимых значениях
            if (weight <= 0 || calories < 0) {
                logger.error("Критическая ошибка данных для '{}': вес ({}г) и калории ({}) не могут быть отрицательными или нулевыми!", name, weight, calories);
                return null;
            }

            // Пытаемся понять, корневой это овощ (число) или листовой (строка)
            try {
                double rootDepth = Double.parseDouble(extra);
                // Приводим к int, если в конструкторе RootVegetable требуется целое число
                return new RootVegetable(name, calories, weight, (int) rootDepth);
            } catch (NumberFormatException e) {
                return new LeafVegetable(name, calories, weight, extra);
            }

        } catch (NumberFormatException e) {
            // Демонстрация WARN при ошибке конвертации текста в числа
            logger.warn("Ошибка формата чисел в строке данных: '{}'", line);
            return null;
        }
    }
}