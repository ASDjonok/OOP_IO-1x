/**
 * Class dedicate for splitting text onto constituents.
 * Provide methods for breaking sequence of characters onto
 *  either words and delimiters or sentences.
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter {

    /**
     * Obtain char sequence and REGEX, split text variable by REGEX
     * and return pairs of integers, that represents start and end indices of
     * every char sequence, which match given REGEX.
     * @param text char sequence to be divided
     * @param regExp REGEX used for dividing text
     * @return return list of constituents
     */
    private static ArrayList<ArrayList<Integer>> getLimits (
            String text, String regExp) {
        Pattern pat = Pattern.compile(regExp);
        Matcher mat = pat.matcher(text);
        ArrayList<ArrayList<Integer>> limits = new ArrayList<ArrayList<Integer>>();
        // try to match the entire input sequence against
        // the pattern using the loop
        while (mat.find()) {
            // get index for current iteration
            ArrayList<Integer> currLimits = new ArrayList<Integer>();
            currLimits.add(mat.start());
            currLimits.add(mat.end());
            if (!currLimits.get(0).equals(currLimits.get(1))) {
                limits.add(currLimits);
            }
        }
        return limits;
    }

    /**
     * Split given char sequence either onto word and delimiters, with distinct string
     * for each delimiter or onto sequence, where spaces after sentence
     * is included in that sentence.
     * @param phrase char sequence to be divided
     * @param splitType type of splitting: "word" or "sentence"
     * @return return list of string, that represent desired parts
     */
    public static ArrayList<String> getParts (String phrase, String splitType) {
        // chose appropriate regex
        String regExp;
        if (splitType.equals("word")) {
            regExp = "[a-zA-Z`]*";
        } else if (splitType.equals("sentence")) {
            regExp = "[.?!][\n ]*[A-Z]";
        } else {
            return new ArrayList<String>();
        }
        // split phrase onto appropriate constituents
        ArrayList<String> constituents = new ArrayList<String>();
        ArrayList<ArrayList<Integer>> limits = StringSplitter.getLimits(phrase, regExp);
        // print found limits
        /*
        for (ArrayList<Integer> numbers: limits) {
            for (int number: numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        */
        // process exceptional situations
        if (splitType.equals("sentence") && limits.isEmpty()) {
            constituents.add(phrase);
            return constituents;
        }
        // form constituents ArrayList
        int prev = 0;
        for (ArrayList<Integer> currLimits: limits) {
            int start = currLimits.get(0);
            int end = currLimits.get(1);
            // depends on what type of split is desired
            if (splitType.equals("sentence")) {
                // end - 1 to exclude first letter of next sentence
                String currConstituent = phrase.substring(prev, end - 1);
                constituents.add(currConstituent);
                prev = end - 1;
            } else {
                // if that is first pass try to add characters in front word
                constituents.addAll(StringSplitter.splitOntoLetters(
                        phrase.substring(prev, start)));
                constituents.add(phrase.substring(start, end));
                prev = end;
            }

        }

        if (splitType.equals("sentence")) {
            constituents.add(phrase.substring(prev));
        } else {
            if (prev<phrase.length()) {
                constituents.addAll(StringSplitter.splitOntoLetters(
                        phrase.substring(prev)));
            }
        }

        return constituents;
    }

    /**
     * Returns list of String. Each contains only one character.
     * @param phrase string to be divided onto single character string
     * @return list of sing character strings
     */
    private static ArrayList<String> splitOntoLetters (String phrase) {
        ArrayList<String> chars = new ArrayList<String>();
        for (int i=0; i<phrase.length(); i++) {
            chars.add(Character.toString(phrase.charAt(i)));
        }
        return chars;
    }
}
