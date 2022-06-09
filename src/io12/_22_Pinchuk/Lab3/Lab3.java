package io12._22_Pinchuk.Lab3;

import java.util.Locale;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {

        //Test string if I don't want to generate random text each time
        String str = "The Touhou Project 1995 (Japanese: 東方Project, Hepburn: Tōhō Purojekuto), " +
                "also known simply as Touhou (東方, literally \"Eastern direction\")";

        //Switch between manual and auto input (for testing purposes)
        boolean manualInput = false;
        Scanner scanner = new Scanner(System.in);
        String lastChar;

        if (manualInput) {
            System.out.println("Enter string:");
            str = scanner.nextLine();
        }
            scanner = new Scanner(str);

        //str is given to scanner input so, I can use this variable to generate new string according to the task
        str = "";

        //Defining the last char of each word and replacing all it's previous occurrences
        while (scanner.hasNext()) {
            str += scanner.next();
            lastChar = str.replaceAll("\\p{Punct}", "");
            lastChar = lastChar.substring(lastChar.length()-1);
            if (!lastChar.chars().allMatch(Character::isLetter)){
                continue;
            }
            str = str.replaceAll(lastChar.toLowerCase(Locale.ROOT), "");
            str = str.replaceAll(lastChar.toUpperCase(Locale.ROOT), "") + " ";
        }
        System.out.println(str.trim());
    }
}