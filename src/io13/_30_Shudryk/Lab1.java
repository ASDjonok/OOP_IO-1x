package io13._30_Shudryk;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner value = new Scanner(System.in);
        // Номер залікової книги: №1330;
        final int C3 = 1330 % 3;

        /*
        final int C2 = 1330 % 2;
        final int C5 = 1330 % 5;
        final int C7 = 1330 % 7;
        O1 - "+"
        C = 1
        O2 - "*"
        type - byte
        */

        // Змінні для формули
        byte i, j;
        int a, n, b, m;

        // Користувач вводить значення змінних
        System.out.println("Enter a: ");
        a = value.nextInt();
        System.out.println("Enter n: ");
        n = value.nextInt();
        System.out.println("Enter b: ");
        b = value.nextInt();
        System.out.println("Enter m: ");
        m = value.nextInt();


        if (-C3 <= n && -C3 >= a) {
            System.out.println("Error");
            throw new ArithmeticException("Division by zero");
        }
        //Записуємо формулу
        else {
            byte result = 0;
            for (i = (byte) a; i <= n; i++) {
                for (j = (byte) b; j <= m; j++){
                    result += (i * j) / (i + C3);
                }
            }
            System.out.println(result);
        }
    }
}
