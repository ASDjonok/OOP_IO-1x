package lab3;

import java.util.Arrays;

public class TextSplitter {
    public static void main(String[] args) {
        String text = "Hello, world! I am program. How are you?";
        System.out.println(text);

        final String[] sentences = text.split("(?<=([!.?]))");
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
//        System.out.println(Arrays.toString(splitedSentences));

        /*System.out.println(Arrays.toString("a;b;c;d".split("(?<=;)")));
        System.out.println(Arrays.toString("a;b;c;d".split("(?=;)")));
        System.out.println(Arrays.toString("a;b;c;d".split("((?<=;)|(?=;))")));*/
    }
}
