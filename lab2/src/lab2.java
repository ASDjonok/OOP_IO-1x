import java.util.Scanner;

public class lab2 {
    private static Scanner sc;

    public static void main(String[] args) {
        lab2.sc = new Scanner(System.in);
        final int C5 = 1301 % 5; // 1 => C = Bт
        final int C7 = 1301 % 7; // 6 => C = float;
        final int C11 = 1301 % 11; // 3 => Обчислити суму найбільших елементів кожного рядка матриці

        //Задамо розмір матриці
        System.out.println("Number of rows:");
        if (!sc.hasNextInt()) {
            System.out.println("Enter the number!");
            return;
        }
        final int m = sc.nextInt();
        if (m < 0) {
            System.out.println("The number is not natural -_-");
            return;
        }
        System.out.println("Number of columns:");
        if (!sc.hasNextInt()) {
            System.out.println("Enter the number!");
            return;
        }
        final int n = sc.nextInt();
        if (n < 0) {
            System.out.println("The number is not natural -_-");
            return;
        }

        //Задамо матрицю циклом
        final float[][] a = new float[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (float) (Math.random() + 1);
            }
        }

        System.out.println("Initial matrix: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%-6.3f", a[i][j]);
            }
            System.out.println();
        }
        final float[][] t = new float[n][m];
        {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    t[i][j] = a[j][i];
                }
            }
            //Протранспонуємо нашу матрицю
            System.out.println();
            System.out.println("Transposed matrix: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    System.out.printf("%-6.3f", t[i][j]);
                }
                System.out.println();
            }
        }
        //Сума найбільших елементів кожного рядка матриці
        float summax = 0, max;
        for (int i = 0; i < n; i++) {
            max = t[i][0];
            for (int j = 0; j < m; j++) {
                if (max < t[i][j]) {
                    max = t[i][j];
                }
            }
            summax += max;
        }
            System.out.println();
            System.out.printf("the sum of the largest elements of each row of the matrix: %f\n", summax);
    }
}

