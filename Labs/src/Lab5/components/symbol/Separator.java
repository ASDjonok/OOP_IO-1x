package Lab5.components.symbol;

public class Separator extends Symbol {
    public Separator(char symbol) {
        if(Character.toString(symbol).matches("[^\\!|\\?|\\.|\\,|\\:|\\s]")) throw new IllegalArgumentException("Invalid symbol for separator");
        this.symbol = symbol;
    }
}
