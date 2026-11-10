package department;

public class MainDepartment {
    public static void main(String[] args) {
        // 1. Создаем отдел
        Department itDepartment = new Department("IT-отдел");

        // 2. Добавляем должности
        itDepartment.addPosition("Программист");
        itDepartment.addPosition("Тестировщик");

        // 3. Получаем должность и добавляем на нее сотрудников
        Department.Position devPosition = itDepartment.getPosition("Программист");
        devPosition.addEmployee("Иван Иванов");
        devPosition.addEmployee("Петр Петров");

        Department.Position qaPosition = itDepartment.getPosition("Тестировщик");
        qaPosition.addEmployee("Анна Сидорова");

        // 4. Выводим информацию
        devPosition.printInfo();
        qaPosition.printInfo();

        // 5. АНОНИМНЫЙ КЛАСС
        System.out.println("Демонстрация анонимного класса:");

        Runnable greeting = new Runnable() {
            @Override
            public void run() {
                System.out.println("Привет! Я анонимный класс, созданный прямо внутри Main.");
                System.out.println("Я имею доступ к переменной itDepartment: " + itDepartment.getClass().getSimpleName());
            }
        };

        greeting.run();
    }
}