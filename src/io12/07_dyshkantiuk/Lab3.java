import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lab3 {
    static String StringToText(String[] str, int n) { // Метод для перетвореня String[] в String
        String text = "";
        for (int i = n; i < str.length; i++) {
            text += str[i]+" ";
        }
        return text;
    }
    public static void SplitText(StringBuilder sb) { // Метод для находження першого речення і всіх інших
        String text = sb.toString();
        String[] sentences;
        String[] fw;
        String[] aw;
        String text1 = "";
        String text2 = "";
        sentences = text.split("[\\.\\!\\?]");// Поділ на речення
        fw = sentences[0].split("(?U)\\W+");// Поділ першого речення на слова
        text1 = StringToText(fw, 0);
        text2 = StringToText(sentences, 1);
        aw = text2.split("(?U)\\W+");// Поділ інших реченнь на слова
        FindDifference(fw, aw, text1);
    }
    public static void FindDifference(String[] fw, String[] aw, String text1){ // Метод для находження різниці
        for (int i = 0; i < aw.length; i++) {
            text1 = text1.replaceAll(aw[i], "");// Находження різниці слів у реченнях
        }
        fw = text1.split("(?U)\\W+");
        Write(fw);
    }
    public static void Write(String[] str) { // Метод написання String[]
        System.out.print("Cлова в першому реченні заданого тексту, яких немає в жодному з наступних: ");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
    public static void main(String[] args) { // Введення даних
        String text;
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введіть текст: ");
            text = in.nextLine();
        } catch (InputMismatchException e) {
            System.out.print("Введіть всі дані правильно");
            return;
        } catch (NoSuchElementException e) {
            System.out.print("Введіть дані");
            return;
        }
        StringBuilder sb = new StringBuilder(text);
        SplitText(sb);
    }
}
