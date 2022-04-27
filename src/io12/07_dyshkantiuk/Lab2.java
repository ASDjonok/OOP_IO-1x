import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lab2 {
    public static void printMatrix(char matrix[][]) {
        for (char i = 0; i < matrix.length; i++) {
            for (char j = 0; j < matrix[i].length; j++) {
                System.out.print((int)matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        try {
            System.out.print("Введіть кількість рядків матриці: ");
            a = in.nextInt();
            System.out.print("Введіть кількість стовпців матриці: ");
            b = in.nextInt();
            System.out.print("Діапазон генерації матриці від 0 до ");
            c = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Введіть всі дані правильно");
            return;
        } catch (NoSuchElementException e) {
            System.out.print("Введіть дані");
            return;
        }
        if (c >= Character.MAX_VALUE){
            System.out.print("char не може бути більше " + (Character.MAX_VALUE+0));
            return;
        }
        char[][] A = new char[a][b];
        char[][] B = new char[a][b];
        for (char i = 0; i < a; i++) {
            for (char j = 0; j < b; j++) {
                A[i][j] = ((char)(Math.random()*c));
                B[i][j] = ((char)(Math.random()*c));
            }
        }
        System.out.println("Матриця А:");
        printMatrix(A);
        System.out.println("Матриця B:");
        printMatrix(B);
        char[][] C = new char[a][b];
        for (char i = 0; i < a; i++) {
            for (char j = 0; j < b; j++) {
                for (char f = 0; f < a; f++) {
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
