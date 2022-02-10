import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        /*
            C5 = 0, C7 = 5, C11 = 9
            Дія з матрицею(ями): C = a x B, a - const
            Тип елементів: char
            Дія з матрицею C: Сер. значення елементів кожного стовчика матриці
        */
        //  створення матриці B
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть розмір матриці:");
        final int size_of_row = scan.nextInt();
        char[][] matrix_b = new char[size_of_row][size_of_row];
        for (int counter_of_row = 0; counter_of_row < size_of_row; counter_of_row++) {
            for (int counter_of_element = 0; counter_of_element < size_of_row; counter_of_element++) {
                matrix_b[counter_of_row][counter_of_element] = (char) ((Math.random() * (126 - 48)) + 48);
            }
        }
        int[] array_for_encoding = new int[size_of_row]; // масив для кодувань
        System.out.println("\nМатриця B у вигляді символів та матриця їхніх кодувань:");
        // виведення матриці В
        for (char[] chars : matrix_b) {
            System.out.print(Arrays.toString(chars));
            for (int index = 0; index < size_of_row; index++) {
                array_for_encoding[index] = chars[index];
            }
            System.out.println(" | " + Arrays.toString(array_for_encoding));
        }
        // створення матриці С
        System.out.println("\nВведіть константу для створення матриці С згідно умови 'C = a x B'");
        final int the_const = scan.nextInt();
        char[][] matrix_c = new char[size_of_row][size_of_row];
        for (int counter_of_row = 0; counter_of_row < size_of_row; counter_of_row++) {
            for (int counter_of_element = 0; counter_of_element < size_of_row; counter_of_element++) {
                matrix_c[counter_of_row][counter_of_element] = (char) (matrix_b[counter_of_row][counter_of_element] * the_const);
            }
        }
        System.out.println("\nМатриця С у вигляді символів та матриця їхніх кодувань:");
        for (char[] chars : matrix_c) {
            System.out.print(Arrays.toString(chars));
            for (int index = 0; index < size_of_row; index++) {
                array_for_encoding[index] = chars[index];
            }
            System.out.println(" | " + Arrays.toString(array_for_encoding));
        }
        // виконання дії з матрицею C: Сер. значення елементів кожного стовчика матриці
        int the_sum_of_elements = 0;
        char[] average = new char[size_of_row]; // масив для обчислених середніх значень
        for (int index_of_column = 0; index_of_column < size_of_row; index_of_column++) {
            for (int index_of_row = 0; index_of_row < size_of_row; index_of_row++) {
                the_sum_of_elements += matrix_c[index_of_row][index_of_column];
            }
            average[index_of_column] = (char) (the_sum_of_elements / size_of_row);
            the_sum_of_elements = 0;
        }
        System.out.println("\nСереднє значення елементів кожного стовпчика матриці:");
        System.out.print(Arrays.toString(average));
        for (int index = 0; index < size_of_row; index++) {
            array_for_encoding[index] = average[index];
        }
        System.out.println(" | " + Arrays.toString(array_for_encoding));
    }
}
