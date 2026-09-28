/*
 * Задание 2.
 * Дана матрица A(n, m), которая содержит результаты сдачи сессии группы
 * из n студентов по m-1 предметам. Первый столбец матрицы содержит номер
 * зачётки (шестизначное уникальное число). Каждый следующий столбец
 * содержит оценку студентов группы по определённому предмету.
 * Отчислить задолжников. Отсортировать студентов по среднему баллу сессии.
 */

import java.util.*;

public class LB02Task15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n m (m включает столбец зачётки): ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = LB02MatrixTools.inputMatrix(sc, n, m);

        // Отчисляем задолжников (есть хотя бы одна оценка <= 3)
        List<int[]> alive = new ArrayList<>();
        for (int[] row : a) {
            boolean hasDebt = false;
            for (int j = 1; j < m; j++) {
                if (row[j] <= 3) {
                    hasDebt = true;
                    break;
                }
            }
            if (!hasDebt) alive.add(row);
        }

        int[][] result = alive.toArray(new int[0][]);
        LB02MatrixTools.sortByAverage(result, 1);

        System.out.println("Студенты после отчисления (отсортированы по среднему баллу):");
        LB02MatrixTools.printMatrix(result);
    }
}
