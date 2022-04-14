public class Lab2 {
    public static void main(String[] args) {
        int[] a = new int[3];
        System.out.println(a[0]);
        a[0] = 1;
        System.out.println(a[0]);

        int[][] matrix = new int[3][];
        int[][] matrix_null = {
                null,
                null,
                null
        };
        System.out.println("matrix.length = " + matrix.length);
        System.out.println(matrix[0]);
        matrix[0] = new int[]{1, 2};
        System.out.println("matrix[0][1] = " + matrix[0][1]);

        /*System.out.println(matrix[0][0]);
        matrix[0][0] = 1;
        System.out.println(matrix[0][0]);*/

        System.out.println(a.length);

        int[] a2 = {1, 2, 4};
        System.out.println("a2 = " + a2);
//test
        int[][] matrix2 = {
                {1000, 2, 3, 5},
                {4, 5, 6}
        };
        System.out.println("matrix2.length = " + matrix2.length);
        System.out.println("Columns quantity = " + matrix2[0].length);
        for (int[] ints : matrix2) {
            for (int anInt : ints) {
//                System.out.print(matrix2[i][j] + "\t");
                System.out.printf("%5d", anInt);
            }
            System.out.println();
        }
        /*for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
//                System.out.print(matrix2[i][j] + "\t");
                System.out.printf("%5d", matrix2[i][j]);
            }
            System.out.println();
        }*/
    }
}
