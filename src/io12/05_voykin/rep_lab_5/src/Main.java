/**
 * Main class that create instance of Text class and
 * invoke text processing method.
 * @author Vadim Voykin
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        String text = "Hey, how are you?\n" +
                      "Let`s get started! Do you have any questions?\n" +
                      "Dave, have you done you homework? Jackson, where is your gun?!\n" +
                      "Have you ever had a hangover? You are so careless!";
        Text wholeText = new Text(text);
        System.out.println(wholeText);
        wholeText.replaceSameLengthWords("Jake");
        System.out.println(wholeText);
    }
}