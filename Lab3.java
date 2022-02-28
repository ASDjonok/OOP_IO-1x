import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        int c3 = 1602 % 3; c3 = 0
//        int c13 = 1602 % 17; c13 = 4
//        System.out.printf("%d, %d", c3, c13);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть речення:");
        StringBuilder main_string = new StringBuilder(scanner.nextLine());
        int first_word_index = main_string.indexOf(" ");
        int last_word_index = main_string.lastIndexOf(" ");
        int sequence_length = main_string.length();
        CharSequence last_word = main_string.subSequence(last_word_index+1, sequence_length);
        CharSequence first_word = main_string.subSequence(0, first_word_index);
        main_string.replace(last_word_index, sequence_length, " "+first_word);
        main_string.replace(0, first_word_index, last_word+"");

        System.out.println(main_string);
    }
}
