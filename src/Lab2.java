public class Lab2 {
    public static void main(String[] args) {
        int[] a = new int[3];
        System.out.println(a[0]);
        a[0] = 1;
        System.out.println(a[0]);

        int[][] matrix = new int[3][2];
        System.out.println(matrix[0][0]);
        matrix[0][0] = 1;
        System.out.println(matrix[0][0]);

        System.out.println(a.length);

        int[] a2 = {1, 2, 4};
//test
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6}
        };
    }
}
