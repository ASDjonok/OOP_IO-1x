public class Lab2 {
    public static void main(String[] args){
        //Варіант завдання
        final int C5 = 1314%5;   // 4 => C=AxB
        final int C7 = 1314&7;   // 5 => char
        final int C11 = 1314&11; // 5 => Cума max елементів в рядках з непарними номерами та min елементів в рядках матриці з парними номерами

        //Створення матриці А
        char A[][] = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'1', '0', '1'}
        };

        //Вивід+перевірка матриці А
        System.out.println("Matrix A:");
        int numberOfColumnsInA = A[0].length;
        int i, j;
        for(i = 0; i < A.length; i++){
            for(j = 0; j < A[i].length; j++){
                if (!Character.isDigit(A[i][j])){
                    throw new ArithmeticException("Matrix Should consist of numbers!");
                }
                System.out.print(A[i][j] + " ");
            }
            if (A[i].length != numberOfColumnsInA){
                throw new ArithmeticException("Matrix has rows of different lengths!");
            }
            System.out.println();
        }
        //Створення матриці B
        char B[][] = {
                {'1', '2', '3', '4'},
                {'5', '6', '7', '8'},
                {'9', '1', '0', '1'}
        };

        //Вивід+перевірка матриці B
        System.out.println("Matrix B:");
        int numberOfColumnsInB = B[0].length;
        for(i = 0; i < B.length; i++){
            for(j = 0; j < B[0].length; j++){
                if (!Character.isDigit(B[i][j])){
                    throw new ArithmeticException("Matrix Should consist of numbers!");
                }
                System.out.print(B[i][j] + " ");
            }
            if (B[i].length != numberOfColumnsInB){
                throw new ArithmeticException("Matrix A has rows of different lengths!");
            }
            System.out.println();
        }

        //Перевірка можливості множення матриць
        if(numberOfColumnsInA != B.length){
            throw new ArithmeticException("Number of columns in matrix A is not the same as number of rows in B!");
        }
        else{
            //Створення матриці С потрібного розміру
            int C[][]= new int[A.length][numberOfColumnsInB];
            int sum = 0;
            //С=AxB
            for (i=0;i<C.length;i++){
                for (j=0;j<C[i].length;j++){
                    for (int k = 0; k< A[i].length;k++){
                        sum += Character.getNumericValue(A[i][k])*Character.getNumericValue(B[k][j]);
                    }
                    C[i][j] = sum;
                    sum = 0;
                }
            }
            //Вивід матриці С
            System.out.println("Matrix C:");
            for(i = 0; i < C.length; i++){
                for(j = 0; j < C[i].length; j++){
                    System.out.print(C[i][j] + "\t");
                }
                System.out.println("\n");
            }

            //Сума найбільших членів непарних рядків
            int SumOfMax=0, maxInRow;
            for (i=0;i<C.length; i+=2){
                maxInRow = C[i][0];
                for (j=0; j<C[i].length; j++){
                    if(maxInRow < C[i][j]){
                        maxInRow = C[i][j];
                    }
                }
                SumOfMax += maxInRow;
            }
            System.out.printf("Sum(max) is %d\n", SumOfMax);

            //Сума найбільших членів парних рядків
            if (C.length>1){
                int SumOfMin=0, minInRow;
                for (i=1;i<C.length; i+=2){
                    minInRow = C[i][0];
                    for (j=0; j<C[i].length; j++){
                        if(minInRow > C[i][j]){
                            minInRow = C[i][j];
                        }
                    }
                    SumOfMin += minInRow;
                }
                System.out.printf("Sum(min) is %d", SumOfMin);
            }
            else{
                System.out.println("There only 1 row. Sum(min) is 0");
            }
        }
    }
}
