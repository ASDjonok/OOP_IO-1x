package io12._04_vytvytskyy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lab2 {
    private static Double[][] defineMatrix(int rowcount, int colcount, BufferedReader bfr) throws IOException {
        String[] input;
        Double[][] res = new Double[rowcount][colcount];
        for (int i = 0; i < rowcount; i++) {
            System.out.printf("Уведіть через пробіл елементи рядка #%d матриці :\n", i);
            input = bfr.readLine().split(" ");
            if (input.length != colcount) {
                i--;
                System.out.println("Спробуйте ще раз");
                continue;

            }
            for (int j = 0; j < colcount; j++) {
                res[i][j] = Double.parseDouble(input[j]);
            }
        }
        return res;
    }

    private static double findMax(Double[] arr) {
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static double findMin(Double[] arr) {
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        System.out.printf("C5 = %d->C=A×B\n", 1204 % 5);
        System.out.printf("C7 = %d->double\n", 1204 % 7);
        System.out.printf("C11 = %d\nОбчислити суму найбільших елементів в рядках матриці з непарними номерами та найменших елементів в рядках матриці з парними номерами\n", 1204 % 11);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("При введені слід пам'ятати, що у матриці А має бути стільки стовпців, скільки рядків у матриці B!");
        System.out.println("Введіть к-сть рядків матриці A:");
        int rowA = Integer.parseInt(reader.readLine());//кількість рядків матриці А
        System.out.println("Введіть к-сть стовпців матриці A та кількість рядків матриці B:");
        int colARowB = Integer.parseInt(reader.readLine());
        System.out.println("Введіть к-сть стовпців матриці B:");
        int colB = Integer.parseInt(reader.readLine());//кількість стовпців матриці B

        System.out.print("Уведіть матрицю A:");
        Double[][] A = defineMatrix(rowA, colARowB, reader);    //спеціальна функція, аби двічі не вставляти код
        System.out.print("Уведіть матрицю B:");
        Double[][] B = defineMatrix(colARowB, colB, reader);
        reader.close();

        Double[][] C = new Double[rowA][colB];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                //Обсичлення склаярного добутку вектор-рядка матриці А на вектор-стовпець матриці B:
                double scalar = 0;
                for (int p = 0; p < colARowB; p++) {
                    scalar += A[i][p] * B[p][j];
                }
                //Закінчення обчислення скалярного добутку
                C[i][j] = scalar;
            }
        }

        double sumEven = 0;
        double sumOdd = 0;
        for (int j = 0; j < rowA - 1; j += 2) {
            sumEven += findMin(C[j]);
            sumOdd += findMax(C[j + 1]);
        }
        if (rowA % 2 == 1) {
            sumEven += findMin(C[rowA - 1]);
        }

        for (int i = 0; i < rowA; i++) {  //Виводжу матрицю С
            for (int j = 0; j < colB; j++) {
                System.out.printf("%f ", C[i][j]);
            }
            System.out.println();
        }
        System.out.printf("Сума з непарних рядків: %f, сума з парних рядків:%f", sumOdd, sumEven);
    }
}
