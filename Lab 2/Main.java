
public class Main {
  
  public static String beautifyMatrix(float matrix[][]) {

    // перевірка матриці на коректність
    int colsLength = matrix[0].length;

    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i].length != colsLength) {
        return "";
      }
    }

    // визначаємо ширину колонок для виводу матриці
    int colSizes[] = new int[matrix[0].length];

    for (int i = 0; i < matrix[0].length; i++) {
      colSizes[i] = String.valueOf(matrix[0][i]).length();


      for (int j = 1; j < matrix.length; j++) {
        int colSize = String.valueOf(matrix[j][i]).length();
        if (colSize > colSizes[i]) {
          colSizes[i] = colSize;
        }
      }
    }

    // виводимо матрицю
    String result = new String();

    for (int i = 0; i < matrix.length; i++) {
      String row = "|  ";

      for (int j = 0; j < matrix[0].length; j++) {
        String currentNumber = String.valueOf(matrix[i][j]);
        row +=  currentNumber;

        if (matrix[0].length - j > 1) {
          row += ", ";
        }
        
        for (int k = 0; k < (colSizes[j] - currentNumber.length()); k++) {
          row += " ";
        }
      }

      row += "  |\n";
      result += row;
    }   
    
    return result;
  }

  public static void checkMatrixValid(float matrix[][]) {

  }
  
  public static void main(String[] args) {

    // Визначення варіанту
    final int C5 = 1310%5;   // 0 => C=a×B, a - const
    final int C7 = 1310&7;   // 6 => float
    final int C11 = 1310&11; // 10 => Знайти середнє значення елементів матриці

    // вхідні данні
    float a = 5f;
    float B[][] = {
      { 1.2f, 2.4f,  3.55f },
      { 1.2f, 5.65f, 64.6f },
      { 4.5f, 8.6f,  9.4f  },
      { 1.8f, 0.5f,  1.1f  }
    };
    
    // вивід початкової матриці і її перевірка
    String formatedMatrix = beautifyMatrix(B);
    if (formatedMatrix != "") {
      System.out.println("\nMatrix B:\n");
      System.out.println(formatedMatrix);
    } else {
      System.out.println("\nMatrix B is invalid!\n");
      return;
    }

    // обчислення матриці С
    float C[][] = new float[B.length][B[0].length];

    for (int i = 0; i < B.length; i++) {
      for (int j = 0; j < B[0].length; j++) {
        C[i][j] = B[i][j] * a;
      }
    }
    
    System.out.println("\nMatrix C (C=axB):\n");
    System.out.println(beautifyMatrix(C));

    // обчисдення середнього значення елементів матриці
    System.out.println("\nThe average value of the elements of the matrix:");
    int matrixLength = B.length * B[0].length;
    float matrixSum = 0;

    for (int i = 0; i < B.length; i++) {
      for (int j = 0; j < B[0].length; j++) {
        matrixSum += B[i][j];
      }
    }

    float average = matrixSum / (float) matrixLength;
    System.out.println(average);
    System.out.println("\n");
  }
}