package com.company;
import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int C2 = 1329 % 2;/*1 => Операція О1 (-)*/
        final int C5 = 1329 % 5;/*4 => Операція O2 (-)*/
        final int C7 = 1329 % 7;/*6 => Тип індексів i та j (double)*/
        final int C = 1329 % 3; /*0*/
        int a;
        final int n;
        final int b;
        final int m;
        double i;
        double j;
        double res = 0;

        System.out.print("Type a: ");
        while (true){
            if (scanner.hasNextInt()){
                a = scanner.nextInt();
                if (a == 0){
                    System.out.print("Please, type a != 0: ");
                    continue;
                }
                break;
            } else {
                System.out.print("Please, type an integer: ");
                scanner.next();
            }
        }

        System.out.print("Type n: ");
        checkInt(scanner);
        n = scanner.nextInt();

        System.out.print("Type b: ");
        checkInt(scanner);
        b = scanner.nextInt();

        System.out.print("Type m: ");
        checkInt(scanner);
        m = scanner.nextInt();

        if ((n < a) || (m < b)) {
            System.out.println("Result: " + res);
        } else {
            for (i = a; i <= n; i++) {
                for (j = b; j <= m; j++) {
                    res += (i - j) / (i - C);
                }
            }
            System.out.printf("Result: %.3f\n", res);
        }
    }

    private static void checkInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please, type an integer");
            scanner.next();
        }
    }
}