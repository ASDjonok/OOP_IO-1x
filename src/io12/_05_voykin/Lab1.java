/*
 * Number of ZKS of student Vadim Voykin: 1205
 * C2 operator "-": 1205 % 2 = 1
 * C3 constant 2: 1205 % 3 = 2
 * C5 operator *: 1205 % 5 = 0
 * C7 type short: 1205 % 7 = 1
 */
package io12._05_voykin;

public class Lab1 {
    public static void main(String[] argv) {

        if (argv.length < 4) {
            System.out.println("Sorry not all parameters are given");
            return;
        }

        final byte C = 2;
        short a, b, n, m;
        float finSum = 0;

        try {
            a = Short.parseShort(argv[0]);
            n = Short.parseShort(argv[1]);
            b = Short.parseShort(argv[2]);
            m = Short.parseShort(argv[3]);
        } catch (Exception WrongNumber) {
            System.out.println("Sorry not all parameters are short type");
            return;
        }
        if (a <= C && n >= C) {
            System.out.println("Zero division");
            return;
        }
        for (short i = a; i <= n; i++) {
            for (short j = b; j <= m; j++) {
                finSum += (float) (i * j) / (i - C);
            }
        }
        System.out.println(finSum);
    }
}
