import java.util.*;

public class LB02MatrixTools {
    // Ввод матрицы с клавиатуры
    public static int[][] inputMatrix(Scanner sc, int n, int m) {
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        return a;
    }

    // Вывод матрицы
    public static void printMatrix(int[][] a) {
        for (int[] row : a) {
            for (int x : row) {
                System.out.print(x + "\t");
            }
            System.out.println();
        }
    }

    // Сортировка строк матрицы по среднему баллу (по убыванию)
    public static void sortByAverage(int[][] a, int skipFirstCol) {
        Arrays.sort(a, (r1, r2) -> {
            double s1 = 0, s2 = 0;
            for (int j = skipFirstCol; j < r1.length; j++) {
                s1 += r1[j];
                s2 += r2[j];
            }
            double avg1 = s1 / (r1.length - skipFirstCol);
            double avg2 = s2 / (r2.length - skipFirstCol);
            return Double.compare(avg2, avg1);
        });
    }
}
