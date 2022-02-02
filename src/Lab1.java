public class Lab1 {
    public static void main(String[] args) {
        final int a = 0;
        final int b = 1;
        final int n = 2;
        final int m = 2;
        final int C = 0;

        double s = 0;
        for (int i = a; i <= n; i++) {
            if (i + C == 0) {
                System.out.println("Error! Division by zero.");
                break;
            }
            for (int j = b; j <= m; j++) {
                s += (double) (i + j) / (i + C);
            }
        }
        System.out.println(s);
        /*System.out.println(1/2);
        int a = 1;
        int b = 2;
        System.out.println((double)a/b);
        double s = a/b;
        System.out.println(s);*/
    }
}
