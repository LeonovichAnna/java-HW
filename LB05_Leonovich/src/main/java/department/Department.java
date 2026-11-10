package department;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    // Список должностей (наших внутренних классов)
    private List<Position> positions = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    // ВНУТРЕННИЙ КЛАСС (Inner Class)
    public class Position {
        private String positionName;
        private List<String> employees = new ArrayList<>();

        public Position(String positionName) {
            this.positionName = positionName;
        }

        // Метод для добавления сотрудника на эту должность
        public void addEmployee(String employeeName) {
            employees.add(employeeName);
        }

        // Метод для вывода информации
        public void printInfo() {
            System.out.println("Отдел: " + departmentName); // Обращаемся к полю внешнего класса!
            System.out.println("  Должность: " + positionName);
            System.out.println("  Сотрудники: " + employees);
        }
    }

    // Метод для добавления новой должности в отдел
    public void addPosition(String positionName) {
        // Создаем объект внутреннего класса
        Position newPosition = new Position(positionName);
        positions.add(newPosition);
    }

    // Метод, чтобы получить должность по имени
    public Position getPosition(String positionName) {
        for (Position p : positions) {
            if (p.positionName.equals(positionName)) {
                return p;
            }
        }
        return null;
    }
}