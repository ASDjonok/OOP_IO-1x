import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
/*
 * C5 = 0; operation: C=a×B, a - const
 * C7 = 1; type of matrix elements: byte
 * C11 = 6; action to perform:
 * Обчислити суму найбільших елементів в стовпцях матриці з парними номерами
 * та найменших елементів в стовпцях матриці з непарними номерами
 */

/**
 * Lab2 class contains methods required in lab 2 of OOP course
 * int number obtained from keyboard
 * byte matrixWidth obtained from keyboard
 * byte matrixLength obtained from keyboard
 *
 * @author Vadim Voykin
 * @version 0.2
 */

public class Lab2 {

    /**
     * Generate matrix and call other methods to perform operations on matrix
     *
     * @param argv Arguments vector is not used
     */

    public static void main(String[] argv) {

        byte number;
        byte matrixWidth;
        byte matrixLength;
        Scanner keyboard = new Scanner(System.in);

        try {
            System.out.print("number to multiply: ");
            number = keyboard.nextByte();
            System.out.print("MatrixLength: ");
            matrixLength = keyboard.nextByte();
            System.out.print("MatrixWidth: ");
            matrixWidth = keyboard.nextByte();
        } catch (InputMismatchException e) {
            System.out.println("Entered value does NOT corresponds to byte type");
            return;
        } catch (NoSuchElementException e) {
            System.out.println("Nothing is entered");
            return;
        }

        byte[][] matrix = new byte[matrixWidth][matrixLength];
        Random randomizer = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (byte) randomizer.nextInt(11); // from 0 to 10 inclusive
            }
        }

        System.out.println("Original matrix");
        printMatrix(matrix);
        System.out.println("Matrix multiplied on " + number);
        multiplyMatrix(matrix, number);
        printMatrix(matrix);
        countMatrix(matrix);
    }

    /***
     * Prints matrix with 3 mark places for each element
     * @param matrix matrix to be printed
     */
    private static void printMatrix(byte[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(String.format("%1$-3d", matrix[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }

    /***
     * Perform operations of multiplication matrix on scalar
     * @param matrix matrix to be processed
     * @param number number to multiply matrix on
     */
    private static void multiplyMatrix(byte[][] matrix, byte number) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= number;
            }
        }
    }

    /***
     * Prints sum of the largest elements of even columns
     * Prints sum of the smallest elements of odd columns
     * @param matrix matrix to be processed
     */
    private static void countMatrix(byte[][] matrix) {


        int sumOfLargestElements = 0;
        byte largestElement;
        for (int j = 0; j < matrix[0].length; j += 2) {
            largestElement = matrix[0][j];
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][j] > largestElement) {
                    largestElement = matrix[i][j];
                }
            }
            sumOfLargestElements += largestElement;
        }

        int sumOfLeastElements = 0;
        byte leastElement;
        for (int j = 1; j < matrix[0].length; j += 2) {
            leastElement = matrix[0][j];
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][j] < leastElement) {
                    leastElement = matrix[i][j];
                }
            }
            sumOfLeastElements += leastElement;

        }

        System.out.println(String.format("Sum of the least elements: %1$d", sumOfLeastElements));
        System.out.println(String.format("Sum of the largest elements: %1$d", sumOfLargestElements));

    }

}
