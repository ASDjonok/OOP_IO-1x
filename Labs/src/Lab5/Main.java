package Lab5;

import Lab5.components.Sentence;
import Lab5.components.Text;
import Lab5.components.Word;
import Lab5.components.symbol.Letter;
import Lab5.components.symbol.Separator;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть текст");
        StringBuilder text = new StringBuilder(scanner.nextLine());
        System.out.println("Перша літера:");
        StringBuilder firstLetter = new StringBuilder(scanner.next());
        System.out.println("Остання літера:");
        StringBuilder secondLetter = new StringBuilder(scanner.next());
        if (firstLetter.length() > 1 || secondLetter.length() > 1) {
            System.out.println("More than 1 letter");
            return;
        }
        Text renderedText = TextRender.get(text.toString());
        for (Sentence sentence : renderedText.getSentences()) {
            String sentenceText = sentence.render();
            int leftSliceIndex = sentenceText.toLowerCase().indexOf(firstLetter.toString().toLowerCase());
            int rightSliceIndex = new StringBuilder(sentenceText.toLowerCase()).reverse().toString().indexOf(secondLetter.toString().toLowerCase());
            if (leftSliceIndex == -1 || rightSliceIndex == -1 || leftSliceIndex > rightSliceIndex) {
                System.out.println(sentenceText);
            } else {
                System.out.println(sentenceText.substring(0, leftSliceIndex) + sentenceText.substring(sentenceText.length() - rightSliceIndex, sentenceText.length()));
            }
        }
   }

}