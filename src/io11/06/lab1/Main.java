/**
 * C2 = 1106 % 2 = 0 -> +
 * C3 = 1106 % 3 = 2 -> 2
 * C5 = 1106 % 5 = 1 -> /
 * C7 = 1106 % 7 = 0 -> byte
 * C11 = 1106 % 11 = 6
 * C17 = 1106 % 17 = 1
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double total = 0;
        final byte c = 2;
        byte a = 0;
        byte n = 0;
        byte b = 0;
        byte m = 0;
        try {
            a = getNextByte(scan, "a");
            n = getNextByte(scan, "n");
            b = getNextByte(scan, "b");
            m = getNextByte(scan, "m");
        } catch (InputMismatchException e) {
            System.err.println("Non byte sequence obtained");
        }
        if (b <= 0 && m >= 0 || a + c <= 0 && n + c >= 0) {
            System.out.println("Zero division will occur.");
            System.exit(-1);
        }
        for (int i=a; i<=n; i++) {
            for (int j=b; j<=m; j++) {
                total += (double) i / j / (i + c);
            }
        }
        System.out.format("Result: %f\n", total);
    }

    public static byte getNextByte (Scanner scanner, String name) {
        byte temp = 0;
        System.out.format("Enter %s: ", name);
        temp = scanner.nextByte();
        return temp;
    }
}