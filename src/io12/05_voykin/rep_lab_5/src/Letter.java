/**
 * Class dedicated for representing letters in words.
 */
public class Letter extends Symbol{

    /**
     * Constructor created new object from chat value,
     * that represents letter.
     * @param currentChar
     */
    public Letter (char currentChar) {
        super(currentChar);
    }

    /**
     * Constructor creates new instance from content of existing object
     * @param currentLetter Letter instance to be duplicated
     */
    public Letter (Letter currentLetter) {
        super(currentLetter);
    }

}
