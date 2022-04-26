import java.util.Scanner;

public class Lab2 {
    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть кількість рядків матриці: ");
        int a = in.nextInt();
        System.out.print("Введіть кількість стовпців матриці: ");
        int b = in.nextInt();
        System.out.print("Діапазон генерації матриці від 0 до ");
        int c = in.nextInt();
        if (c >= Character.MAX_VALUE){
            System.out.print("char не може бути більше 65535");
            return;
        }
        int[][] A = new int[a][b];
        int[][] B = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                A[i][j] = ((char)(Math.random()*c));
                B[i][j] = ((char)(Math.random()*c));
            }
        }
        System.out.println("Матриця А:");
        printMatrix(A);
        System.out.println("Матриця B:");
        printMatrix(B);
        int[][] C = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                for (int f = 0; f < a; f++) {
                    C[i][j] += A[i][f] * B[f][j];
                }
            }
        }
        System.out.println("Матриця C:");
        printMatrix(C);
        double sum = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                sum += C[i][j];
            }
        }
        System.out.println("Сумма елементів матриці С: " + sum);
        System.out.println("Середнє значення елементів матриці С: "+ (sum/(a*b)));
    }
}
