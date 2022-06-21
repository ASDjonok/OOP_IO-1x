package Lab5.components.symbol;

public class Letter extends Symbol {
    public Letter(char symbol) {
        if(Character.toString(symbol).matches("[^а-яА-Яa-zA-ZЇїєЄЕiІ]")) throw new IllegalArgumentException("Invalid symbol for letter");

        this.symbol = symbol;
    }
}


