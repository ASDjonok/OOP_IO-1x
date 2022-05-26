package io12._20_maksymenko.lab_2_OOP.src;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("C5 is " + 1220 % 5 + " so C5 is  C=axB, a - const ");
        System.out.println("C7 is " + 1220 % 3 + " so C7 is short ");
        System.out.println("C11 is " + 1220 % 5 + " so C11 is calculate the sum of the lowest elements of each column");
        CalcClass A = new CalcClass();

        A.call_calcC5((short) 1);
        A.call_calcC11();
        A.call_out();

        CalcClass B = new CalcClass();

        B.call_calcC5((short) 26);
        B.call_calcC11();
        B.call_out();

    }
}
