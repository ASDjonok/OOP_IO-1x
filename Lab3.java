import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
//        int c3 = 1602 % 3; c3 = 0
//        int c13 = 1602 % 17; c13 = 4
//        System.out.printf("%d, %d", c3, c13);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть речення:");
        StringBuilder main_string = new StringBuilder(scanner.nextLine());
        int temp_index = 0;
        int counter = 0;
        for(int i=0; i<main_string.length(); i++) {
            if(main_string.charAt(i) == '.' || main_string.charAt(i) == '!' || main_string.charAt(i) == '?') {
                counter++;
                String substring = main_string.substring(temp_index, i);
                substring = substring.trim();
                if(substring.length() < 3){
                    break;
                }
                int first_word_index = substring.indexOf(" ");
                int last_word_index = substring.lastIndexOf(" ");
                int sequence_length = substring.length();
                String last_word = substring.substring(last_word_index + 1, sequence_length);
                String first_word = substring.substring(0, first_word_index);
                substring = substring.replaceFirst(last_word, first_word);
                substring = substring.replaceFirst(first_word, last_word);
                if(counter == 1){
                    main_string.replace(temp_index, i, substring);
                }
                else{
                    main_string.replace(temp_index + 1, i, substring);
                }
                temp_index = i+1;
            }
        }
        System.out.println(main_string);
    }
}
