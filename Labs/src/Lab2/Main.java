package Lab2;

import java.util.Scanner;

public class Main
{
    private static Scanner scanner;

    public static void main(String[] args)
    {
        Main.scanner = new Scanner(System.in);

        String[] O = {"C=A+B", "type(matrix): double", "Дія: обчислити суму найбільших елементів в рядках матриці з " +
                "парними номерами та найменших елементів в рядках матриці з непарними номерами"};
        int[] Ci = {1302 % 5, 1302 % 7, 1302 % 11};
        int c = 5;

        for (int i = 0; i < Ci.length; i++) {
            if (i >= 2) {c += 2;}
            System.out.printf("C%s: %s %s\n", c, Ci[i], O[i]);
            c += 2;
        }

        System.out.println("Розмір матриці:");
        if (!scanner.hasNextInt())
        {
            throw new IllegalArgumentException("Throw me some numbers");
        }
        final int N = scanner.nextInt();
        if (N<0)
        {
            throw new IllegalArgumentException("Throw me some NATURAL numbers");
        }

        System.out.println("Введіть матрицю А:");
        final double[][] A = entermatrix(N);
        System.out.println("Введіть матрицю B:");
        final double[][] B = entermatrix(N);
        final double[][] C = new double[N][N];
        for (int i = 0; i<N; i++)
        {
            for (int j = 0; j<N; j++)
            {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        double summax = 0;
        double summin = 0;
        System.out.println(O[0]+":");
        for (int i = 1; i<=N; i++)
        {
            double max = Double.NEGATIVE_INFINITY;
            double min = Double.POSITIVE_INFINITY;
            for (int j = 1; j<=N; j++)
            {
                if (i%2==0) {if(C[i-1][j-1] > max) {max = C[i-1][j-1];}}
                else {if(C[i-1][j-1]<min) {min = C[i-1][j-1];}}
                System.out.printf("%s\s",C[i-1][j-1]);
            }
            if (i%2==0){ summax+=max; }
            else { summin+=min;}
            System.out.println();
        }

        System.out.printf("Сума найбільших елементів в рядках матриці з парними номерами: %s\s\n",summax);
        System.out.printf("Сума найменших елементів в рядках матриці з непарними номерами: %s\s\n",summin);
    }

    public static double[][] entermatrix(int N)
    {
        double[][] matrix = new double[N][N];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (!Main.scanner.hasNextDouble())
                {
                    throw new IllegalArgumentException("Throw me some DOUBLE numbers");
                }
                    matrix[i][j] = Main.scanner.nextFloat();
            }
        }
        return matrix;
    }
}
