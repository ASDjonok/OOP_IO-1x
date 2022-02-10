package myPackage;

public class LogicOperations {
    public static void main(String[] args) {
        System.out.println(false && true);
//        System.out.println(false & 12);
        System.out.println(0 & 1);

        int a = 1;
        int b = 1;
        int n = 1;
        int m = 1;
        if (a > n & myMethod(b, m)) {
            System.out.println("Error!");
        }
    }

    private static boolean myMethod(int b, int m) {
        System.out.println("!!!");
        return b > m;
    }
}
