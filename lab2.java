public class lab2 {
    public static void main(String[] args) {
        int [][] A ={
                {1,2,4},
                {4,5,3},
                {7,8,7}
        };

        int [][] B={
                {1,2,4},
                {4,5,2},
                {7,8,2}
        };

        int [][] C = new int [3][3] ;

        System.out.println("A matrix: ");

        for (int[] ints : A) {
            for (int j = 0; j < A.length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }


        System.out.println("\nB matrix: ");

        for (int[] ints : B) {
            for (int j = 0; j < B.length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }
        for (int i=0;i<C.length;i++){

            for (int j=0;j<C.length;j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        System.out.println("\nC matrix:");

        for (int[] ints : C) {

            for (int j = 0; j < C.length; j++) {
                System.out.print(ints[j] + "\t ");
            }
            System.out.println();
        }
        int temp;
        int sum_max = 0;
        for (int[] ints : C) {
            temp = ints[0];

            for (int j = 1; j < C.length; j++) {
                if (ints[j] > temp) {
                    temp = ints[j];
                }
            }
            sum_max += temp;

        }
        System.out.println();
        System.out.println("SUM_BIG = " + sum_max);

    }
}