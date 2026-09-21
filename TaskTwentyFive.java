import java.util.Scanner;

public class TaskTwentyFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите p: ");
        int p = sc.nextInt();

        System.out.println("Введите количество чисел: ");
        int n = sc.nextInt();

        int count = 0;

        System.out.println("Введите " + n + " чисел:");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if (countDigits(x) == p && isAutomorphic(x)) {
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

        // проверяем является ли x автоморфным
        static boolean isAutomorphic(int x) {
            int x1 = x;
            long square = x * x;
            int mod = 1;

            while (x1 > 0) {
                mod *= 10;
                x1 /= 10;
            }

            return square % mod == x;
        }
}
