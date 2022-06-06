import java.util.Scanner;
public class lab1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        final long n = in.nextInt();
        System.out.print("Enter m: ");
        final long m = in.nextInt();
        System.out.print("Enter a: ");
        final int a = in.nextInt();
        System.out.print("Enter b: ");
        final int b = in.nextInt();
        final int C = 1;
        float K = 0;


        if (a <= C && C <= n || b <= 0 && 0 <= m) {
            System.out.println("Ділення на нуль!!");
        } else {
            for (long i = a; i <= n; i++) {
                for (long j = b; j <= m; j++) {
                    K = K + (float) (i % j) / (i + C);
                }

            }
            System.out.println(K);
        }
    }
}