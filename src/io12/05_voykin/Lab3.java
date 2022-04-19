import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * C3 = 2; type of String variables: String
 * C13 = 15; operation to perform:
 * В заданому тексті замінити слова заданої довжини визначеним рядком.
 */

/**
 * Lab3 class contains methods required in lab 3 of OOP course
 * char[] delimiters is predefined
 * String dedicatedWord is predefined
 * String strToProcess is obtained from keyboard
 * @author Vadim Voykin
 * @version 0.2
 */
public class Lab3 {

    /**
     * Obtain String from console and process according to described operation
     * @param argv unused
     */
    public static void main(String[] argv) {
        String strToProcess;
        Scanner keyboard = new Scanner(System.in);

        try {
            strToProcess = keyboard.nextLine();
            System.out.format("Unprocessed phrase =>%1$s<=\n", strToProcess);
        }catch(NoSuchElementException e) {
            System.out.println("Empty input");
            return;
        }

        int index = 0;
        int leftCorner = 0;
        char[] delimiters = {' ', ',', '.', '!', '?', ':', ';'};
        String dedicatedWord = "Jason";
        int dedicatedLength = dedicatedWord.length();

        StringBuffer strBuffer = new StringBuffer(strToProcess);

        int strBufferLength = strBuffer.length();
        while(index < strBufferLength) {
            if(isDelimiter(delimiters, strBuffer.charAt(index))) {
                if(leftCorner != -1 && index - leftCorner == dedicatedLength) {
                    strBuffer.replace(leftCorner, index, dedicatedWord);
                }
                leftCorner = -1;
            } else {
                if(leftCorner == -1) {
                    leftCorner = index;
                }
            }
            index++;
        }
        if(index - leftCorner == dedicatedLength) {
            strBuffer.replace(leftCorner, index, dedicatedWord);
        }
        String resultString = strBuffer.toString();
        System.out.format("Processed phrase >=%1$s=<\n", resultString);
    }

    /**
     *
     * @param delimiters array of elements, considered as delimiters
     * @param charToProcess char to check, if it is delimiter or not
     * @return true if charToProcess is considered as delimiter else false
     */
    private static boolean isDelimiter(char[] delimiters, char charToProcess) {
        for(int i = 0; i < delimiters.length; i++) {
            if(delimiters[i] == charToProcess) {
                return true;
            }
        }
        return false;
    }
}
