package Lab5.components;
import Lab5.components.symbol.Letter;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Word implements SentencePart {

    private ArrayList<Letter> letterList;

    public Word(ArrayList<Letter> receivedLetterList) {

        receivedLetterList.forEach((letter -> {
            if(letter.render().matches("[\\s!?.,]")) throw new IllegalArgumentException("Invalid letter value for word");
        }));

        letterList = receivedLetterList;
    }

    public String render() {
        return letterList.stream().map(Letter::render).collect(Collectors.joining());
    }

    public String getType() {
        return "word";
    }
}
