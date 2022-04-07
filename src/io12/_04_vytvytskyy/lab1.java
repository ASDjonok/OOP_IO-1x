import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lab1 {
    public static void main(String[] args) throws IOException {
        System.out.printf("C2 = %d->O1:+\n", 1204 % 2);
        final byte C = 1204 % 3;
        System.out.printf("C3 = C = %d\n", C);
        System.out.printf("C5 = %d->O2:-\n", 1204 % 5);
        System.out.printf("C7 = %d->i,j: byte\n", 1204 % 7);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        byte a = Byte.parseByte(reader.readLine());
        byte b = Byte.parseByte(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        reader.close();

        if(a<=-C && n>=-C){
            System.out.println("0 в знаменнику");
            return;
        }
        float finalSum = 0;
        for (byte i = a; i <= n; i++) {
            for (byte j = b; j <= m; j++) {
                finalSum += (float) (i - j) / (i + C);
            }
        }
        System.out.println(finalSum);
    }
}
