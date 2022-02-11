package com.company;

public class Lab1 {
    public static void main(String[] args) {
        double result = 0;
        double fraction = 0;
        long numerator = 0L;
        long denominator = 0L;
        long c = 2L;
        long a = 2L;
        long n = 5L;
        long b = 1L;
        long m = 3L;
        for(long i = a;i <= n;i++)
        {
            for(long j = b;j <= m;j++)
            {
                numerator = (i-j);
                denominator = (i+c);
                if(numerator != 0 || denominator != 0)
                {
                    fraction += ((double)numerator/denominator);
                }
                else
                {
                    fraction += 0;
                }
            }
            result = result + fraction;
            fraction = 0;
        }
        System.out.printf("result = %.5f",result);
    }
}
