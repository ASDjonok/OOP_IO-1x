/**
 * Class dedicated for representing sentence.
 * For storing sentence it is broken onto delimiters and words.
 * That enables text processing methods.
 */

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Sentence {

    private ArrayList<SentencePart> parts;

    /**
     * Obtain sentence, brake it onto words and delimiters.
     * Store each sentence part in distinct SentencePart instance.
     * @param sentence sentence to be captured
     */
    public Sentence (String sentence) {
        this.parts = new ArrayList<SentencePart>();
        ArrayList<String> constituents = StringSplitter.getParts(
                sentence, "word");
        for (String constituent: constituents) {
            //System.out.format(">%s<\n", constituent);
            if (Pattern.matches("[a-zA-Z`]*", constituent)) {
                this.parts.add(new Word(constituent));
            } else {
                this.parts.add(new Delimiter(constituent));
            }
        }
    }

    /**
     * Replaces all words of same length as given word with given word.
     * @param word word, that same length words, will be replaced with
     */
    public void replaceSameLengthWords (String word) {
        for (int i=0; i<this.parts.size(); i++) {
            SentencePart part = this.parts.get(i);
            if (part.getLength() == word.length()) {
                this.parts.set(i, new Word(word));
            }
        }
    }

    /**
     * Return string representation of sentence, captured inside the instance.
     * @return string representation of sentence
     */
    public String toString () {
        StringBuffer strBuilder = new StringBuffer();
        for (SentencePart part: this.parts) {
            strBuilder.append(part.toString());
        }
        return strBuilder.toString();
    }
}
