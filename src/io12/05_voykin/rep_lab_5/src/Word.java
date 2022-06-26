/**
 * Class dedicated to represent Word.
 */

import java.util.ArrayList;

public class Word implements SentencePart{

    private ArrayList<Letter> letters;

    /**
     * Constructor instantiate Word, that is composed of letters,
     * represented with Letter class objects.
     * @param currWord Word to be captured
     */
    public Word (String currWord) {
        this.letters = new ArrayList<Letter>();
        for (int i=0; i<currWord.length(); i++) {
            char currChar = currWord.charAt(i);
            letters.add(new Letter(currChar));
        }
    }

    /**
     * Instantiate Word from content of existing object.
     * @param currWord instance of Word, to be duplicated
     */
    public Word (Word currWord) {
        this.letters = new ArrayList<Letter>();
        for (Letter currLetter: currWord.letters) {
            this.letters.add(new Letter(currLetter));
        }
    }

    /**
     * Return length of word, captured inside the instance.
     * @return length of word
     */
    public int getLength () {
        return this.letters.size();
    }

    /**
     * @return String representation of Word instance
     */
    public String toString () {
        StringBuffer phrase = new StringBuffer();
        for(Letter currLetter: this.letters) {
            phrase.append(currLetter.toString());
        }
        return phrase.toString();
    }
}
