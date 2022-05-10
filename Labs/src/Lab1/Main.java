package Lab1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println((float)1/2);

        String[] O = {"O1: +", "C: 0", "O2: %", "type(i,j): byte"};
        int[] C = {1302 % 2, 1302 % 3, 1302 % 5, 1302 % 7};
        int c = 2;

        for (int i = 0; i < C.length; i++) {
            if (i >= 2) {
                c += 1;
            }
            System.out.printf("C%s: %s %s\n", c, C[i], O[i]);
            c += 1;
        }

        Map<String, Byte> valuedict = new HashMap<>();
        String[] valkeys = {"a", "n", "b", "m"};

        for (String in : valkeys) {
            System.out.printf("Введіть число %s: \n", in);
            if (!scanner.hasNextInt()) {
                throw new IllegalArgumentException("Throw me some numbers");
            }
            valuedict.put(in, (byte) scanner.nextInt());
        }
        valuedict.put("C", (byte) 0);
        if (valuedict.get("a") > valuedict.get("n") || valuedict.get("b") > valuedict.get("m")) {
            throw new IllegalArgumentException("Last number < first number");
        }
        if (valuedict.get("a") <= -valuedict.get("C") && -valuedict.get("C") <= valuedict.get("n")) {
            throw new IllegalArgumentException("Function isn't defined on interval");
        }
        if (valuedict.get("b") <= 0 && 0 <= valuedict.get("m")) {
            throw new IllegalArgumentException("Function isn't defined on interval");
        }

        float sum = 0;
        for (byte i = valuedict.get("a"); i <= valuedict.get("n"); i++) {
            for (byte j = valuedict.get("b"); j <= valuedict.get("m"); j++) {
                sum += (float) (i % j) / (i + valuedict.get("C"));
            }
        }
        System.out.printf("Результат обчислення: %f", sum);
    }
}