package io12._22_Pinchuk.Lab2;

import java.util.Arrays;
import java.util.Random;

public class Lab2 {
    public static void printMatrixChar(char title, char[][] matrixChar) {
        System.out.printf("Matrix %c of char:\n", title);
        for (char[] chars : matrixChar) {
            for (char aChars : chars)
                System.out.print(aChars + "\t");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random random = new Random();

        final int maxSize = 5;
        final int rowA = random.nextInt(maxSize) + 1;
        final int rowB = random.nextInt(maxSize) + 1;
        final int collA = random.nextInt(maxSize) + 1;
        final int collB = random.nextInt(maxSize) + 1;

        char[][] matrixCharA = new char[rowA][collA];
        char[][] matrixCharB = new char[rowB][collB];
        char[][] matrixCharC = new char[rowA+rowB][collA+collB];

        for (int i = 0; i < rowA; i++)
            for (int j = 0; j < collA; j++)
                matrixCharA[i][j] = (char) (random.nextInt(94) + '!');

        for (int i = 0; i < rowB; i++)
            for (int j = 0; j < collB; j++)
                matrixCharB[i][j] = (char) (random.nextInt(94) + '!');

        for (char[] chars : matrixCharC)
            Arrays.fill(chars, '0');

        printMatrixChar('A', matrixCharA);
        printMatrixChar('B', matrixCharB);

        //Direct matrix addition
        for (int i = 0; i < matrixCharC.length; i++) {
            if (i < matrixCharA.length)
                System.arraycopy(matrixCharA[i], 0, matrixCharC[i], 0, matrixCharA[i].length);
            else {
                System.arraycopy(matrixCharB[i- matrixCharA.length], 0, matrixCharC[i],
                        matrixCharA[0].length, matrixCharB[i - matrixCharA.length].length);
            }
        }

        printMatrixChar('C', matrixCharC);

        System.out.println("String representation of max chars:");

        int maxChar;
        int sumChar = 0;
        //Taking i-coll and last char
        for (int i = 0; i < matrixCharC[0].length; i++) {
            maxChar = matrixCharC[matrixCharC.length - 1][i];
            //Go through all previous elements to define max
            for (int j = 0; j < matrixCharC.length - 1; j++){
                maxChar = Math.max(maxChar, matrixCharC[j][i]);
            }
            //recording the sum and providing maxchar output for current column
            sumChar += maxChar;
            System.out.print((char)maxChar);
        }
        System.out.println("\nInteger sum of max char = " + sumChar);
    }
}
