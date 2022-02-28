import java.util.Scanner;


public class Main {
    public static void main(String[] args){
//        int c5 = 1602 % 5; c5 = 2
//        int c7 = 1602 % 7; c7 = 6
//        int c11 = 1602 % 11; c11 = 7
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть кількість рядків: ");
        int rows = scanner.nextInt();
        System.out.println("Введіть кількість стовпців: ");
        int columns = scanner.nextInt();
        float[][] mainmatrix;
        float[][] matrixa;
        float[][] matrixb;
        mainmatrix = new float[rows][columns];
        matrixa = new float[rows][columns];
        matrixb = new float[rows][columns];
        System.out.println("Матриця А: \n");
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrixa[i][j] = (float)Math.random()*20-10;
                System.out.printf(" %5.2f ", matrixa[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("\nМатриця B:\n");
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrixb[i][j] = (float)Math.random()*20-10;
                System.out.printf(" %5.2f ", matrixb[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("\nМатриця А+В:\n");
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                mainmatrix[i][j] = matrixa[i][j] + matrixb[i][j];
                System.out.printf(" %5.2f ", mainmatrix[i][j]);
            }
            System.out.print("\n");
        }
        float swap_element, sum_odd, sum_even;
        sum_odd = 0;
        sum_even = 0;
        for(int i=0; i<columns; i++){
            swap_element = mainmatrix[0][i];
            if(i%2==0){
                for(int j=0; j<rows; j++){
                    if(mainmatrix[j][i]>swap_element)
                    {
                        swap_element = mainmatrix[j][i];
                    }
                }
                sum_odd += swap_element;
            }else{
                for(int j=0; j<rows; j++){
                    if(mainmatrix[j][i]<swap_element){
                        swap_element = mainmatrix[j][i];
                    }
                }
                sum_even += swap_element;
            }
        }
        System.out.printf("Сумма найбільших елементів в стовпцях матриці з непарними номерами: %.2f\n" +
                "Сумма найменших елементів в стовпцях матриці з парними номерами: %.2f", sum_odd, sum_even);

    }
}
