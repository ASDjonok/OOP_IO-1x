
public class Main {
    public static void main(String[] args) {
        
        final int myNumber = 1310;  // 01  = +
                                    // C   = 2
                                    // 02  = *
                                    // i,j = short

        final int c = myNumber % 3;
        final int a = 0;
        final int b = 0;
        final int n = 1;
        final int m = 2;

        double sum = 0;

        for (short i = a; i <= n; i++) {
            double denominator = i + c;

            if (denominator != 0) {
                for (short j = b; j <= m; j++) {
                    sum += i * j / denominator;
                }
            } else {
                System.out.println("Error! Division by zero.");
            }
        }

        System.out.printf("Your result: %f", sum);
    }
}