package Lab5;

import Lab5.components.Sentence;
import Lab5.components.SentencePart;
import Lab5.components.Text;
import Lab5.components.Word;
import Lab5.components.symbol.Letter;
import Lab5.components.symbol.Separator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextRender {

    public static Text get(String stringText) {

        Pattern sentencePattern = Pattern.compile("[^.!?]+(\\?|\\!|\\.)");
        Matcher sentenceMatcher = sentencePattern.matcher(stringText);

        ArrayList<Sentence> sentenceList = new ArrayList<Sentence>();

        while (sentenceMatcher.find()) {
           sentenceList.add(renderSentence(sentenceMatcher.group()));
        }

        return new Text(sentenceList);
    }

    private static Sentence renderSentence(String stringSentence) {

        Pattern componentPattern = Pattern.compile("([а-яА-Яa-zA-ZЇїкєЕi]+)|([\\,|\\.|\\!|\\?|\\:|\\s])");
        Matcher componentMatcher = componentPattern.matcher(stringSentence);

        ArrayList<SentencePart> componentList = new ArrayList<SentencePart>();

        while (componentMatcher.find()) {
            componentList.add(renderComponent(componentMatcher.group()));
        }

        return new Sentence(componentList);
    }

    private static SentencePart renderComponent(String component) {



        if(component.matches("[а-яА-Яa-zA-ZЇїкєЕi]+")) {

            ArrayList<Letter> letterList = new ArrayList<Letter>();
            for (char letter : component.toCharArray()) letterList.add(new Letter(letter));
            return new Word(letterList);
        } else {
            return new Separator(component.charAt(0));
        }
    }
}
