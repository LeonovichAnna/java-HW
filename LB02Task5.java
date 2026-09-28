/*
 * Задание 1.
 * Дана целочисленная матрица размера A(n, m). Построить на основе её
 * «зубчатую матрицу», в которой каждая строка новой матрицы состоит
 * из элементов соответствующей строки исходной матрицы, взятых в
 * единственном экземпляре. Отсортировать строки матрицы по количеству
 * отрицательных элементов в ней.
 */

import java.util.*;

public class LB02Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n m: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = LB02MatrixTools.inputMatrix(sc, n, m);

        // Строим зубчатую матрицу: в каждой строке — уникальные элементы
        int[][] jagged = new int[n][];
        for (int i = 0; i < n; i++) {
            int[] temp = new int[m];
            int size = 0;
            for (int j = 0; j < m; j++) {
                boolean already = false;
                for (int k = 0; k < size; k++) {
                    if (temp[k] == a[i][j]) {
                        already = true;
                        break;
                    }
                }
                if (!already) {
                    temp[size] = a[i][j];
                    size++;
                }
            }
            jagged[i] = new int[size];
            for (int k = 0; k < size; k++) {
                jagged[i][k] = temp[k];
            }
        }

        // Сортируем строки по количеству отрицательных элементов (по убыванию)
        Arrays.sort(jagged, (r1, r2) -> {
            int c1 = 0, c2 = 0;
            for (int x : r1) if (x < 0) c1++;
            for (int x : r2) if (x < 0) c2++;
            return Integer.compare(c2, c1);
        });

        System.out.println("Результат:");
        LB02MatrixTools.printMatrix(jagged);
    }
}
