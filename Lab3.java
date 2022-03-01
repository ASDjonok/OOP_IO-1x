package com.company;
/*C3=0 StringBuilder
C17=16 В кожному слові заданого тексту, видалити всі попередні входження останньої літери цього слова.
 */


public class Lab3 {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder("Надворі весна вповні. Куди не глянь— скрізь розвернулося," +
                " розпустилося, зацвіло пишним цвітом." +
                " Ясне сонце, тепле й приязне, ще не вспіло наложити палючих" +
                " слідів на землю: як на Великдень дівчина," +
                " красується вона в своїм розкішнім убранні...");

        text = new StringBuilder(text.toString().replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", ""));
        String[] splittext = text.toString().split(" ");

        for (String word : splittext) {
            System.out.println("до: "+word);
            char c = word.charAt(word.length() - 1);
            StringBuilder s = new StringBuilder(String.valueOf(c));
            String word1 = word.replace(s, "");
            StringBuilder word2 = new StringBuilder(word1);
            word2.append(s);
            System.out.println("після: "+word2);

        }

    }
}
