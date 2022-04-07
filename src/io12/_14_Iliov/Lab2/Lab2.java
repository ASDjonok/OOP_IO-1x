package io12._14_Iliov.Lab2;

import java.util.Random;

public class Lab2 {
    private int columns_a = 0;
    private int lines_a = 0;
    private int columns_b = 0;
    private int lines_b = 0;
    private int[][] matrix_a;
    private int[][] matrix_b;
    private int[][] matrix_c;
    public Lab2(int columns_a, int lines_a, int columns_b, int lines_b) {
        this.columns_a = columns_a;
        this.lines_a = lines_a;
        this.columns_b = columns_b;
        this.lines_b = lines_b;
        this.matrix_a = new int [lines_a][columns_a];
        this.matrix_b = new int [lines_b][columns_b];
        this.matrix_c = new int [lines_a][columns_b];
    }
    public void multiplicator()
    {
        if(columns_a == lines_b)
        {
            matrix_a = matrix_creator(lines_a, columns_a);
            matrix_b = matrix_creator(lines_b, columns_b);
            matrix_printer(lines_a, columns_a, matrix_a, "matrix_a");
            matrix_printer(lines_b, columns_b, matrix_b, "matrix_b");
            for(int i=0;i<lines_a;i++)
            {
                for(int j=0;j<columns_b;j++)
                {
                    for(int k=0;k<columns_a;k++)
                    {
                        matrix_c[i][j] += matrix_a[i][k]*matrix_b[k][j];
                    }
                }
            }
            matrix_printer(lines_a, columns_b, matrix_c,"matrix_c");
        }
        else{
            System.out.println("Multiplication is impossible.");
        }
    }
    public int max_sum()
    {
        int sum = 0;
        int max = 0;
        for(int i=0;i<lines_a;i++)
        {
            max = matrix_c[i][0];
            for(int j=0;j<columns_b;j++)
            {
                if((i+1)%2==0 && j!= columns_b-1)
                {
                    if(max < matrix_c[i][j+1])
                    {
                        max = matrix_c[i][j+1];
                    }
                }
            }
            if((i+1)%2==0){sum+=max;}
            max = 0;

        }
        return sum;
    }
    public int min_sum()
    {
        int sum = 0;
        int min;
        for(int i=0;i<lines_a;i++)
        {
            min = matrix_c[i][0];
            for(int j=0;j<columns_b;j++)
            {
                if((i+1)%2!=0 && j!= columns_b-1)
                {
                    if(min > matrix_c[i][j+1])
                    {
                        min = matrix_c[i][j+1];
                    }
                }
            }
            if((i+1)%2!=0){sum+=min;}
            min = 0;

        }
        return sum;
    }
    private int[][] matrix_creator(int lines, int columns)
    {
        int[][] matrix = new int [lines][columns];
        Random random = new Random();
        for(int i=0;i<lines; i++)
        {
            for(int j=0;j<columns; j++)
            {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }
    private void matrix_printer(int lines, int columns, int[][] matrix, String m_name)
    {
        System.out.println(m_name + ": ");
        for(int i=0;i<lines; i++)
        {
            for(int j=0;j<columns; j++)
            {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println(" ");
        }
        System.out.println("--------------------------");
    }
}
