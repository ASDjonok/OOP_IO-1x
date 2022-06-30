/**
 * C2 = 1106 % 2 = 0 ->
 * C3 = 1106 % 3 = 2 ->
 * C5 = 1106 % 5 = 1 -> C = Bт
 * C7 = 1106 % 7 = 0 -> double
 * C11 = 1106 % 11 = 6 ->
 * Обчислити суму найбільших елементів в стовпцях матриці
 * з парними номерами та найменших елементів в стовпцях
 * матриці з непарними номерами
 * C17 = 1106 % 17 = 1 ->
 */

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // instantiate new Random object
        Random rand = new Random();
        // determine dimensions randomly
        int height = rand.nextInt(2) + 2;
        int length = rand.nextInt(4) + 4;
        // create matrix with desired dimensions
        double[][] matrix = new double[height][length];
        // initialize with random value
        for (int i=0; i<height; i++) {
            for (int j=0; j<length; j++) {
                matrix[i][j] = rand.nextDouble();
            }
        }
        // print randomly generated matrix
        printMatrix(matrix, height, length);
        // multiply matrix on number
        double[][] newMatrix = multiplyMatrix(matrix, height, length, 2);
        // print multiplied matrix
        printMatrix(newMatrix, height, length);
        // calculate appropriate statistics
        calculateStatistics(newMatrix, height, length);
    }

    public static void printMatrix (double[][] matrix, int height,
                             int length) {
        // loop over all matrix
        for (int i=0; i<height; i++) {
            for (int j=0; j<length; j++) {
                // print every element if 5 space-places
                System.out.format("%5.2f", matrix[i][j]);
            }
            // move caret to the next line
            System.out.println();
        }
        System.out.println();
    }

    public static double[][] multiplyMatrix (double[][] matrix, int height,
                                      int length, double num) {
        // create new matrix with same dimensions
        double[][] newMatrix = new double[height][length];
        for (int i=0; i<height; i++) {
            for (int j=0; j<length; j++) {
                // assign to element of matrix newMatrix element of
                // origin matrix , multiplied on number num
                newMatrix[i][j] = matrix[i][j] * num;
            }
        }
        return newMatrix;
    }

    public static void calculateStatistics (double[][] matrix, int height,
                                     int length) {
        // iterate through columns
        for (int j=0; j<length; j++) {
            // initialize temp values
            boolean isEven = j%2==0;
            // set total sum to zero
            double sum = 0;
            // assign to maxVal either min possible value if column is even
            // or max possible value if column is odd
            double maxVal = isEven ? Double.MIN_VALUE : Double.MAX_VALUE ;
            // iterate through line
            for (int i=0; i<height; i++) {
                double currElement = matrix[i][j];
                if (currElement == maxVal) {
                    sum += currElement;
                // if column is even
                } else if (currElement > maxVal && isEven) {
                    sum = currElement;
                    maxVal = currElement;
                // if column is odd
                } else if (currElement < maxVal && !isEven) {
                    sum = currElement;
                    maxVal = currElement;
                }
            }
            // chose phrase depending on either even column or not
            String phrase = isEven ? "Max" : "Min" ;
            // print calculated result for specific column
            System.out.format("%s element in %d column: %.2f\n",
                    phrase, j, sum);
        }
    }
}