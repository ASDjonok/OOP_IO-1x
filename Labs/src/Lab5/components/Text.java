package Lab5.components;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Text implements RenderComponent {

    private final ArrayList<Sentence> sentenceList;
    public Text(ArrayList<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }

    public ArrayList<Sentence> getSentences() {
        return sentenceList;
    }

    public String render() {
        return sentenceList.stream().map(Sentence::render).collect(Collectors.joining());
    }
}
