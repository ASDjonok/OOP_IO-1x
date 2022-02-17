package io10._00_Aleshchenko;

public class Lab1 {
    public static void main(String[] args) {
        int a = 0x7fffffff;
        if (a > Character.MAX_VALUE) {
            System.out.println(a);
            System.out.println((int)((char)a));
        }
    }
}
