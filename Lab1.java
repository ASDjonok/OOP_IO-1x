public class Lab1 {

    public static void main(String[] args) {
        double i , j;
        //int C2 = 0;
        //int C3 = 0;
        //int C5 = 2;
        //int C7 = 6;
        int C = 0;
        int n, m , a , b;
        n = 2;
        m = 2;
        a = 1;
        b = 1;
        double result1 = 0;
        double result2 = 0;
        if(a<=0 || a>n || b>m || b<=0){
            System.out.println("Виникла помилка!");
        }
        else{
            for(i=a;i<=n;i++){

                for(j=b;j <= m; j++){
                    result1 += (i%j)/(i+C);
                }
                result2 += result1;
            }
        }
        System.out.println(result2);
    }
}
