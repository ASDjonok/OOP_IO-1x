package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class Lab3
{
    public String sort_second_letter()
    {
        char [] vowels = {'A', 'E', 'I', 'O', 'U', 'Y', 'a', 'e', 'i', 'o', 'u', 'y'};
        ArrayList<String> vow_words = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your text: ");
        String text = s.nextLine();
        String[] words = text.split(" ");
        for(String word: words)
        {
            char [] word_ca = word.toCharArray();
            for (char vowel : vowels) {
                if (word_ca[0] == vowel && word_ca.length > 1) {
                    String vow_word = new String(word_ca);
                    vow_words.add(vow_word);
                }
            }
        }
        for(int i = 0; i < vow_words.size(); i++)
        {
            for( int j=vow_words.size()-1; j > i; j--)
            {
                int number1 = 0;
                int number2 = 0;
                char [] word_ca1 = vow_words.get(j-1).toCharArray();
                char [] word_ca2 = vow_words.get(j).toCharArray();
                if (word_ca1.length > 1 && word_ca2.length > 1){
                    number1 = Character.codePointAt(word_ca1,1);
                    number2 = Character.codePointAt(word_ca2,1);
                    if ( number1 > number2 ) {
                        String word_1s = new String(word_ca1);
                        String word_2s = new String(word_ca2);
                        vow_words.set(j-1,word_2s);
                        vow_words.set(j,word_1s);
                    }
                }

            }
        }
        return String.valueOf(vow_words);
    }
}
