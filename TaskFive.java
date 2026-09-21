import java.util.Scanner;

public class TaskFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите p: ");
        int p = sc.nextInt();

        System.out.println("Введите количество чисел n: ");
        int n = sc.nextInt();

        // если p > 10 то хотябы одна цифра в этом числе будет повторятся
        if (p > 10) {
            for (int i = 0; i < n; i++) sc.nextInt();
            System.out.println("Найдено чисел: 0");
            return;
        }

        int count = 0;

        System.out.println("Введите " + n + " чисел:");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            // ищем p значное число
            if (countDigits(x) != p) continue;

            // проверяем, что цифры не повторяются
            if (hasUniqueDigits(x)) {
                //System.out.println(x);
                count++;
            }
        }

        System.out.println("Найдено чисел: " + count);
    }

    // количество цифр в числе
    static int countDigits(int x) {
        if (x == 0) return 1;
        int c = 0;
        while (x > 0) {
            c++;
            x /= 10;
        }
        return c;
    }

    // проверяем все ли цифры различны
    static boolean hasUniqueDigits(int x) {
        boolean[] seen = new boolean[10];
        while (x > 0) {
            int d = x % 10;
            if (seen[d]) return false;
            seen[d] = true;
            x /= 10;
        }
        return true;
    }
}