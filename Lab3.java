package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int C3 = 1329 % 3;  /*0 - Тип: StringBuilder.*/
        final int C13 = 1329 % 17;/*3 - Дія з рядком: В усіх питальних реченнях заданого тексту
                                                    знайти та надрукувати без повторень слова
                                                    заданої довжини.*/
        final StringBuilder text;
        int length;
        String[] words;
        String sentence;
        Pattern pattern;
        Matcher matcher;

        System.out.print("Welcome! Type some text: ");
        text = new StringBuilder(scanner.nextLine());

        System.out.print("Type length of words that will be searched: ");
        while (true) {
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                if (length <= 0) {
                    System.out.print("Type > 0: ");
                    continue;
                }
                break;
            } else {
                System.out.print("Type integer: ");
                scanner.next();
            }
        }
        pattern = Pattern.compile("[^.\\s][^!.?]*[?]");
        matcher = pattern.matcher(text);

        while (matcher.find()) {
            sentence = matcher.group();
            words = (sentence.substring(0, sentence.length() - 1).split("\\s"));
            for (int i = 0; i < words.length; i++){
                if(words[i].length() != length){
                    continue;
                }
                System.out.println(words[i]);
            }
        }
    }
}
