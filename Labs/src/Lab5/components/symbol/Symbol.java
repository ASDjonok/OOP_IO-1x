package Lab5.components.symbol;

import Lab5.components.SentencePart;

abstract class Symbol implements SentencePart {

    protected char symbol;

    public String render() {
        return String.valueOf(symbol);
    }

    public String getType() {
        return "letter";
    }
}
