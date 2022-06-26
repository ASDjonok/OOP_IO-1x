/**
 * Abstract class dedicated to represent any character.
 */
public abstract class Symbol {
    protected char symbol;

    /**
     * Creates object from character passed in constructor.
     * @param currentChar char to be captured
     */
    public Symbol (char currentChar) {
        this.symbol = currentChar;
    }

    /**
     * Creates new instance form content of existing object.
     * @param currLetter instance to be duplicated
     */
    public Symbol (Symbol currLetter) {
        this.symbol = currLetter.symbol;
    }

    /**
     * Returns string representation of character,
     * that is captured in class.
     * @return string representation of character
     */
    public String toString () {
        return Character.toString(this.symbol);
    }
}
