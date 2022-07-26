package com.company;

import java.util.Scanner;
import java.lang.Math;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int C5 = 1329%5;  /*4 => Дія з матрицями       - C=A×B*/
        final int C7 = 1329%7;  /*6 => Тип елементів матриці - float*/
        final int C11 = 1329%11;/*9 => Дія з матрицею C      - Знайти середнє значення елементів
                                                               кожного стовпчика матриця*/
        final int rowsA;
        final int columnsA;
        final int rowsB;
        final int columnsB;
        final float[][] matrixA;
        final float[][] matrixB;
        final float[][] matrixC;
        final float bottomLimit;
        final float upperLimit;
        float sum = 0.0f;
        float res;

        System.out.print("Welcome! Please, type number of rows for matrix A: ");
        rowsA = checkPositiveInt(scanner);

        System.out.print("Type number of columns for matrix A: ");
        columnsA = checkPositiveInt(scanner);

        System.out.print("Type number of rows for matrix B: ");
        rowsB = checkPositiveInt(scanner);

        System.out.print("Type number of columns for matrix B: ");
        columnsB = checkPositiveInt(scanner);

        System.out.print("Please, type bottom limit of random numbers: ");
        checkFloat(scanner);
        bottomLimit = scanner.nextFloat();

        System.out.print("Type upper limit of random numbers: ");
        checkFloat(scanner);
        upperLimit = scanner.nextFloat();

        if (columnsA != rowsB){
            System.out.println("Oops...First matrix' number of columns must be " +
                               "equal to second matrix' number of rows! Try again.");
        } else if (bottomLimit > upperLimit){
            System.out.println("Oops...Upper limit of random numbers must be " +
                               "greater than the lower one! Try again.");
        } else {
            System.out.println("\nMatrix A:");
            matrixA = createMatrix(rowsA, columnsA, upperLimit, bottomLimit);

            System.out.println("\nMatrix B:");
            matrixB = createMatrix(rowsB, columnsB, upperLimit, bottomLimit);

            matrixC = new float[rowsA][columnsB];
            System.out.println("\nMatrix C:");
            for(int i = 0; i <= (rowsA-1); i++){
                System.out.print("| ");
                for(int j = 0; j <= (columnsB-1); j++){
                    for(int k = 0; k <= (rowsB-1); k++){
                        matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                    }
                    System.out.printf("%7.3f ", matrixC[i][j]);
                }
                System.out.println(" |");
            }

            System.out.print("\n");
            for(int i = 0; i <= (columnsB-1); i++){
                for(int j = 0; j <= (rowsA-1); j++){
                    sum += matrixC[j][i];
                }
                res = sum / rowsA;
                sum = 0.0f;
                System.out.printf("The average mean of the elements in the " +
                                  "column with [%d] index equals %.3f\n", i, res);
            }
        }
    }

    private static int checkPositiveInt(Scanner scanner){
        int number;

        while (true){
            if (scanner.hasNextInt()){
                number = scanner.nextInt();
                if (number <= 0){
                    System.out.print("Type > 0: ");
                    continue;
                }
                break;
            } else {
                System.out.print("Type integer: ");
                scanner.next();
            }
        }
        return number;
    }

    private static void checkFloat(Scanner scanner){
        while (!scanner.hasNextFloat()){
            System.out.print("Type a float number: ");
            scanner.next();
        }
    }

    private static float[][] createMatrix(int rows, int columns,
                                          float upperLimit, float bottomLimit){
        float[][] matrix = new float[rows][columns];

        for (int i = 0; i <= (rows-1); i++){
            System.out.print("| ");
            for (int j = 0; j <= (columns-1); j++){
                matrix[i][j] = (float)(Math.random() * (upperLimit - bottomLimit)
                        + bottomLimit);
                System.out.printf("%6.3f ", matrix[i][j]);
            }
            System.out.println(" |");
        }
        return matrix;
    }
}