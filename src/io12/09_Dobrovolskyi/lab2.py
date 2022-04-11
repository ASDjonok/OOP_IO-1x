'''
****************************************
Program to get a candy		        
Programmer : Fedir		            
Date : 11th April, 2022	            
Email : dobrovolskiy.fedir@gmail.com
Webpage : none		                
****************************************
'''
# C5 = 1210 % 5  # 0 - дія з матрицею: axB, a - const
# C7 = 1210 % 7  # 6 - тип елементів матриці: float
# C11 = 1210 % 11  # 0 - дія з матрицею С: Обчислити суму найменших елементів кожного стовпця матриц

class Target:
    @staticmethod
    def vikonavchiymethod():
        # ввод кількості рядків у матриці
        while True:
            try:
                n = int(input('Enter n of matrix: '))
                break
            except:
                print('you have to input integer number, try again')
        print('Enter rows:')
        # ввод змісту
        while True:
            try:
                matrix = []
                for i in range(n):
                    matrix.append(list(map(float, input().split())))
                for i in matrix:
                    if len(i) != len(matrix[0]):
                        raise
                break
            except:
                print('input matrix nxm with floats in it')

        # ввод константи
        while True:
            try:
                a = int(input('a = '))
                break
            except:
                print('you have to input integer number, try again')
        print('')
        table = []
        for i in matrix:
            table.append(list(map(lambda x: x * a, i)))
        print('C = axB =')
        for i in table:
            print(i)

        suma = 0
        x = len(table[0])
        for i in range(x):
            column = []
            for j in table:
                column.append(j[i])
            suma += min(column)

        print('Сума найменших елементів кожного стовпця матриці =', suma)


Target.vikonavchiymethod()
