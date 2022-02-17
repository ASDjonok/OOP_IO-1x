import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
//        System.out.println(scanner.hasNextInt());
        ensureInt(scanner);
        System.out.println(scanner.nextInt());
//        scanner.nextLine();
        ensureInt(scanner);
        System.out.println(scanner.nextInt());*/
//        int a = scanner.nextInt();
        /*boolean isNumberEntered = false;
        while (!isNumberEntered) {
            try {
                System.out.println(scanner.nextInt());
                isNumberEntered = true;
//            System.out.println("???");
            } catch (InputMismatchException e) {
//                System.out.println("***" + scanner.nextLine());
                System.out.println("***" + scanner.next());
                System.out.println("Please enter number (not other symbol(s)).");
            }
        }*/
//        System.out.println("!!!");

        final int a = 0;
        final int b = 1;
        final int n = 2;
        final int m = 2;
        final int C = 0;

//        System.out.println((double)1/2);

        double s = 0;
        boolean wasError = false;
        if (a <= -C && -C <= n) {
            System.out.println("Error! Division by zero.");
        } else {
            for (int i = a; i <= n; i++) {
                for (int j = b; j <= m; j++) {
                    s += (double) (i + j) / (i + C);
                }
            }
            System.out.println(s);
        }
       /* *//*myLabel:*//* for (int i = a; i <= n; i++) {
            if (i + C == 0) {
                System.out.println("Error! Division by zero.");
                wasError = true;
                break;
            }
            for (int j = b; j <= m; j++) {
                *//*if (i + C == 0) {
                    System.out.println("Error! Division by zero.");
//                    return;
//                    System.exit(0);
                    break myLabel;
                }*//*
                s += (double) (i + j) / (i + C);
            }
        }
        if (!wasError) {
            System.out.println(s);
        }*/
        /*System.out.println(1/2);
        int a = 1;
        int b = 2;
        System.out.println((double)a/b);
        double s = a/b;
        System.out.println(s);*/
    }

    private static void ensureInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("was in input buffer: \"" + scanner.next() + "\"");
            System.out.println("Please enter number (not other symbol(s)).");
        }
    }
}
