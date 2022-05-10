package Lab3;

import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] O = {"type: StringBuilder", "З кожного речення заданого тексту видалити " +
                "підрядок найбільшої довжини, що починається та закінчується заданими літерами."};
        int[] Ci = {1302 % 3, 1302 % 17};
        int c = 3;
        for (int i = 0; i < Ci.length; i++) {
            System.out.printf("C%s: %s %s\n", c, Ci[i], O[i]);
            c += 14;
        }

        System.out.println("Введіть текст");
        StringBuilder text = new StringBuilder(scanner.nextLine());
        System.out.println("Перша літера:");
        StringBuilder fl = new StringBuilder(scanner.next());
        System.out.println("Остання літера:");
        StringBuilder ll = new StringBuilder(scanner.next());
        if (fl.length() > 1 || ll.length() > 1) {
            System.out.println("More than 1 letter");
            return;
        }

        int from = 0, to;
        ArrayList<String> sentences = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == '?') {
                to = i;
                sentences.add(text.substring(from, to));
                from = i + 1;
            }
        }

        StringBuilder max;
        for (String sentence : sentences) {
            max = new StringBuilder();
            for (int j = 0; j < sentence.length(); j++) {
                if (sentence.charAt(j) == fl.charAt(0)) {
                    for (int k = j; k < sentence.length(); k++) {
                        if (sentence.charAt(k) == ll.charAt(0)) {
                            if (k - j > max.length()) {
                                max = new StringBuilder(sentence.substring(j, k + 1));
                            }
                        }
                    }
                }
            }
            System.out.println(sentence.replace(max.toString(), ""));
        }
    }
}
