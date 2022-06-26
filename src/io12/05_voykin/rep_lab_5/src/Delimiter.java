/**
 * Class dedicated for representing delimiters in sentence.
 */
public class Delimiter extends Symbol implements SentencePart {

    /**
     * @param currentChar char, which class will capture as delimiter
     */
    public Delimiter (String currentChar) {
        /*
         * Uses String type due to specifics of StringSplitter class
         * splitting return ArrayList of String,
         * each represent either word of single delimiter
         */
        super(currentChar.equals("\n") ? '\n' : currentChar.charAt(0));
    }

    /**
     * Constructor duplicate the content of existing object.
     * @param currentLetter
     */
    public Delimiter (Delimiter currentLetter) {
        super(currentLetter);
    }

    /**
     * Used to distinguish delimiter from word.
     * Used in text processing function.
     * @return value of -1
     */
    public int getLength () {
        return -1;
    }

}
