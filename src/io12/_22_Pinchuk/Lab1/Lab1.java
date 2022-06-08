package io12._22_Pinchuk.Lab1;


public class Lab1 {
    public static void main(String[] args) {
        final int a = 7;
        final int b = 1;
        final int n = 1;
        final int m = 0;
        final int c = 2;
        float s = 0;

        if (m<=2 && 2<=b){
            System.out.println("Division by zero");
        } else {
            for (int i = m; i<=b; i++) {
                for (int j = n; j<=a; j++){
                    s += (i+j)/(i-c);
                }
            }
            System.out.println("s = " + s);
        }

    }
}
