import java.util.Scanner;
public class Lab1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        System.out.print("Enter m: ");
        int m = in.nextInt();
        System.out.print("Enter a: ");
        int a = in.nextInt();
        System.out.print("Enter b: ");
        int b = in.nextInt();
        int C = 1209 % 3;
        double S = 0;
        if (a > n || b > m) {
            System.out.println("Data entered incorrectly!");
        } else {
            for (float i = a; i <= n; i++) {
                if (i == 0) {
                    System.out.println("You can't divide by zero!");
                    S = 0;
                    break;
                } else {
                    for (float j = b; j <= m; j++) {
                        S += ((double) (i - j) / (i - C));
                    }
                }
            }
            System.out.println(S);
        }
    }
}
