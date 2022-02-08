package io10._00_Aleshchenko;

public class Lab2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6, 7}
        };
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(matrix[1].length);
        System.out.println(matrix[1][2]);

        int[][] matrix2 = new int[3][];
        matrix2[0] = new int[2];
        System.out.println(matrix2[0][1]);

    }
}
