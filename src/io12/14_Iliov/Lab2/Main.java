package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of lines matrix A: ");
        int lines_a = s.nextInt();
        System.out.println("Enter number of columns matrix A: ");
        int columns_a = s.nextInt();
        System.out.println("Enter number of lines matrix B: ");
        int lines_b = s.nextInt();
        System.out.println("Enter number of columns matrix B: ");
        int columns_b = s.nextInt();
        Lab2 obj = new Lab2(columns_a, lines_a, columns_b, lines_b);
        obj.multiplicator();
        int maxsum = obj.max_sum();
        System.out.println("Sum of maximum elements in rows - "+maxsum);
        int minsum = obj.min_sum();
        System.out.println("Sum of minimum elements in rows - "+minsum);
    }
}
