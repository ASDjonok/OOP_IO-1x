/**
 * Class dedicated for storing and processing text.
 */

import java.util.ArrayList;

public class Text {
    String regExp = "[.?!][\n ]*[A-Z]";

    private ArrayList<Sentence> sentences;

    /**
     * Brake text onto sentences and store each in distinct Sentence instance.
     * @param text
     */
    public Text (String text) {
        this.sentences = new ArrayList<Sentence>();
        ArrayList<String> constituents = StringSplitter.getParts(
                text, "sentence");
        for (String constituent: constituents) {
            //System.out.format(">%s<\n", constituent);
            this.sentences.add(new Sentence(constituent));
        }
    }

    /**
     * Replace oll word of same length as given with given word.
     * @param word word to replace with
     */
    public void replaceSameLengthWords (String word) {
        for (Sentence constituent: this.sentences) {
            constituent.replaceSameLengthWords(word);
        }
    }

    /**
     * Returns string representation of text.
     * @return String representation of Text instance
     */
    public String toString () {
        StringBuffer strBuffer = new StringBuffer();
        for (Sentence constituent: this.sentences) {
            strBuffer.append(constituent.toString());
        }
        return strBuffer.toString();
    }

}
