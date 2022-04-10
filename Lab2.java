import java.util.Random;
import java.util.Scanner;

/*
    C5 = 4 (C=A×B)
    C7 = 5 (char)
    C11 = 1 (Обчислити суму найменших елементів кожного рядка матриці)
 */

public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // створюємо екземпляр "scanner" класу Scanner задля  ручного
        // задавання значення змінним

        Random random = new Random(); // те ж саме робимо з класом Random задля генерування значень матриць A та B

        System.out.println("Будемо використовувати дві матриці з розмірностями m x k та k x n");
        System.out.print("Введіть дані m: ");
        final int m = scanner.nextInt();

        System.out.print("Введіть дані n: ");
        final int n = scanner.nextInt();

        System.out.print("Введіть дані k: ");
        final int k = scanner.nextInt();

        char[][] A = new char[m][k]; // створюємо масив матриці A
        char[][] B = new char[k][n]; // створюємо масив матриці B
        char[][] C = new char[m][n]; // створюємо масив матриці C

        // Генеруємо та виводимо матрицю A
        System.out.println("Матриця A:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                A[i][j] = (char) (random.nextInt(10) + 1);
                System.out.printf("%4d", (int) A[i][j]); // Робимо форматування, задля візуального структування матриці
            }
            System.out.println();
        }

        // Генеруємо та виводимо матрицю B
        System.out.println("Матриця B:");
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = (char) (random.nextInt(10) + 1);
                System.out.printf("%4d", (int) B[i][j]);
            }
            System.out.println();
        }

        // Виконуємо операцію множення матриць AxB та отримуємо матрицю С
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int f = 0; f < k; f++) {
                    C[i][j] += (char) (A[i][f] * B[f][j]);
                }
            }
        }

        // Виводимо матрицю C
        System.out.println("Матриця C:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", (int) C[i][j]);
            }
            System.out.println();
        }

        int summa = 0;
        for (int i = 0; i < m; i++) {
            int b = C[i][0];
            for (int j = 0; j < n; j++) {
                if (C[i][j] <= b) {
                    b = C[i][j];
                }
            }
            summa += b;
        }
        System.out.println("\nСумма найменших елементів кожного рядка: " + summa);
    }
}