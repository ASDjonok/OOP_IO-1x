/**
 * C2 = 1106 % 2 = 0 ->
 * C3 = 1106 % 3 = 2 -> String
 * C5 = 1106 % 5 = 1 ->
 * C7 = 1106 % 7 = 0 ->
 * C11 = 1106 % 11 = 6 ->
 * C17 = 1106 % 17 = 1 ->
 * Вивести всі речення заданого тексту
 * в порядку зростання кількості слів у них.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    public static void main (String[] args) {
        // create new scanner
        Scanner scan = new Scanner(System.in);
        // get text from console
        String phrase = scan.nextLine();
        // split it onto sentences
        String[] sentences = phrase.split("[.!?;]\\W+");
        // create new ArrayList
        ArrayList<String> listSentences = new ArrayList<String>();
        // add all sentences in it
        for (int i=0; i<sentences.length; i++) {
            listSentences.add(sentences[i]);
        }
        // create new HashMap
        HashMap<String, Integer> lengthMap = buildMap(sentences);
        // sort ArrayList of sentences
        listSentences.sort(new byNumberOfWordsSorter(lengthMap));
        // loop over array anr print each element
        for (String currString: listSentences) {
            System.out.println(currString);
        }
    }

    public static HashMap<String, Integer> buildMap (
            String[] sentences) {
        // create new HashMap
        HashMap<String, Integer> newMap = new HashMap<String, Integer>();
        // loop over sentences
        for (int i=0; i<sentences.length; i++) {
            // get current string
            String currString = sentences[i];
            // count word in current string
            int number = currString.split("\\s+").length;
            // put this value into hashMap
            newMap.put(currString, number);
            // print all information on console for debugging
            System.out.format("Key: '%s' -> Value: '%s'\n", currString, number);
        }
        // return built HashMap
        return newMap;
    }
}

class byNumberOfWordsSorter implements Comparator<String> {

    HashMap<String, Integer> myMap;

    public byNumberOfWordsSorter (HashMap<String, Integer> strIntMap) {
        this.myMap = strIntMap;
    }

    public int compare (String s1, String s2) {
        return this.myMap.get(s1) - this.myMap.get(s2);
    }
}