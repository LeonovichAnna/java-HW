import java.util.Scanner;

public class TaskThirtyFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество чисел: ");
        int n = sc.nextInt();

        int count = 0;

        System.out.println("Введите " + n + " чисел:");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            System.out.print(MaxNumber(x) + " ");
        }
    }

        static int MaxNumber(int x){
        // индекс i - это самам цифра числа, а count[i] - это то, сколько раз эта цифра встречается в числе
        int[] count = new int[10];

        if (x == 0){
            count[0] = 1;
        }
        else{
            while(x > 0){
                int d = x % 10;
                count[d]++;
                x /= 10;
            }
        }

        int res = 0;
        for (int d = 9; d >= 0; d--){
            while (count[d] > 0){
                res = res * 10 + d;
                count[d]--;
            }
        }
        return res;
        }
}
