import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
    // C5= 1213 % 5 = 3; => C=A⊕B
    // C7= 1213 % 7 = 2; Matrix elements` type => short
    // C11= 1213 % 11 = 3; => "Обчислити суму найбільших елементів кожного рядка матриці"
    Scanner in = new Scanner(System.in);
    System.out.print("Введіть розмірність квадратної матриці A: ");
    int MatrixSizeA = in.nextInt();
    System.out.print("Введіть розмірність квадратної матриці B: ");
    int MatrixSizeB = in.nextInt();
    in.close();
    if (MatrixSizeA < 1 || MatrixSizeB < 1){
        System.out.println("Ви ввели недопустимі значення для розмірності матриці");
    }
    //Згенеруємо випадкові цілі числа за допомогою класа Random, попередньо імпортувавши його, та визначемо значення
    //елементів квадратних матриць  A і B.
    Random r = new Random(100);
    short A[][] = new short[MatrixSizeA][MatrixSizeA];
    int ran1 = 0;
    for (short j=0;j<MatrixSizeA;j++){
        for (short i=0;i<MatrixSizeA;i++){

            ran1 = r.nextInt(100);
            A[j][i] = (short) ran1;
        }
    }
    short B[][] = new short[MatrixSizeB][MatrixSizeB];
    for (short j=0;j<MatrixSizeB;j++){
        for (short i=0;i<MatrixSizeB;i++){

            ran1 = r.nextInt(100);
            B[j][i] = (short) ran1;
            }
        }
    //Роздрукуємо отримані матриці на екран консолі
        System.out.println("Квадратна матриця A: ");
        for (short j=0;j<MatrixSizeA;j++){
            for (short i=0;i<MatrixSizeA;i++){

                System.out.print(A[j][i]);
                System.out.print("\t");
            }
            System.out.println();
        }
        System.out.println("Квадратна матриця B: ");
        for (short j=0;j<MatrixSizeB;j++){
            for (short i=0;i<MatrixSizeB;i++){

                System.out.print(B[j][i]);
                System.out.print("\t");
            }
            System.out.println();
        }
    //Реалізуємо прямий добуток матриць A і B й отримаємо блочну матрицю C
        short[][] C = new short[MatrixSizeA + MatrixSizeB][MatrixSizeA + MatrixSizeB];
        for (int i=0; i<MatrixSizeA; i++) {
            for (int j=0; j<MatrixSizeA; j++) {

                C[i][j] = A[i][j];
            }
        }
        for (int i=0; i<MatrixSizeB; i++) {
            for (int j=0; j<MatrixSizeB; j++) {

                C[i+MatrixSizeA][j+MatrixSizeA] = B[i][j];
            }
        }
    //Роздрукуємо матрицю С на консолі
        System.out.println("Блочна матриця С: ");
        for (short j=0;j<(MatrixSizeA + MatrixSizeB);j++){
            for (short i=0;i<(MatrixSizeA + MatrixSizeB);i++){

                System.out.print(C[j][i]);
                System.out.print("\t");
            }
            System.out.println();
        }
    //Реалізуємо алгоритм знаходження суми найбільших елементів кожного рядка матриці С та раздрукуєсмо його на консолі
        short RowsMaxValueSummary = 0;
        short MaxValueInRow;
        for (int j = 0; j < C[1].length; j++) {
            MaxValueInRow = C[j][0];
            for (int i = 0; i < C.length; i++) {
                if (C[j][i] > MaxValueInRow) {
                    MaxValueInRow = C[j][i];
                }
            }
            RowsMaxValueSummary += MaxValueInRow;
        }
        System.out.println("Сума найбільших елементів кожного рядка матриці С: " + RowsMaxValueSummary);
    }
    }
