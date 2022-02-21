
public class Main {
    public static void main(String[] args) {
        
        final int myNumber = 1310;  

        // 01  = +
        // C   = 2
        // 02  = *
        // i,j = short

        final int c = myNumber % 3;
        final int a = 1;
        final int b = 0;
        final int n = 5;
        final int m = 2;

        double sum = 0;

        if ( a <= -c && -c <= n ) {
            System.out.println("Error! Division by zero.");
        } else {
            for (short i = a; i <= n; i++) {
                for (short j = b; j <= m; j++) {
                    sum += (i * j) / (i + c);
                }
            }
    
            System.out.printf("Your result: %f", sum);
        }
    }
}