/* Номер заліковки: 1424
С2 - +
С3 - 2
С5 - -
С7 - long
 */
package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final long C2 = 1424 % 2;//1 - "+"
        System.out.println("C2 = " + C2 + " //O1 - \"+\"");
        final long C3 = 1424 % 3;//2
        System.out.println("C3 = " + C3);
        final long C5 = 1424 % 5;//4 - "-"
        System.out.println("C5 = " + C5 + " //O2 - \"-\"");
        final long C7 = 1424 % 7;//3 - "long"
        System.out.println("C7 = " + C7 + " //type - \"long\"");

        final long n;
        final long m;
        long chislivnyk;
        double znamennyk;
        long a, b;
        final double constanta = 1424 % 3;
        double res = 0;

        try {
            System.out.print("Введіть n:");
            n = scan.nextInt();
            System.out.print("Введіть m:");
            m = scan.nextInt();
            System.out.print("Введіть a:");
            a = scan.nextLong();
            System.out.print("Введіть b:");
            b = scan.nextLong();

        } catch (InputMismatchException exc){
            System.out.println("Введені дані не відповідають типу вказаному у завданні");
            return;
        }
        if (a > n || b > m) {
            System.out.println("a і b не можуть бути більше n и m відповідно.");
            return;
        }
        if (a <= 0 || b <= 0) {
            System.out.println("Порядковий номер суми ряду (a та b) не може бути меншим або рівним 0!");
            return;
        }
        for (long i = a; i<=n; i++) {
            for (long j = b; j <= m; j++) {
                znamennyk = i + constanta;
                if (znamennyk == 0){
                    System.out.println("Знаменник не може дорівнювати 0, так як на 0 ділити не можна.");
                    break;
                } else {
                    chislivnyk = i - j;
                    res += chislivnyk / znamennyk;
                }
            }
        }
        System.out.println("Результат обчислення: res = "+res);
    }
}

