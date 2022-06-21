package Lab5.components;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Sentence implements RenderComponent {

    private final ArrayList<SentencePart> sentenceComponents;

    public Sentence(ArrayList<SentencePart> sentenceComponents) {
        this.sentenceComponents = sentenceComponents;
    }

    public String[] getWordList() {
        return sentenceComponents.stream().filter(component -> component.getType() == "word")
                .map(component -> component.render()).toArray(String[]::new);
    }

    public String render() {
        return sentenceComponents.stream().map(component -> component.render()).collect(Collectors.joining());
    }
}
