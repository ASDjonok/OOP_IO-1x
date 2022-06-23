package io12._12_Zelenskyi;

import java.util.Scanner;
public class Lab1 {
    public static void main(String[] args) {
        int GradeBookNumber = 1213;
        System.out.println("Номер залікової книжки" + GradeBookNumber);
        //Декларуємо змінні
        int C2, C5, C7;
        //Визначаємо іх як остачу від ділення номера залікової книжки на 2, 5 й 7 відповідно
        C2 = GradeBookNumber % 2;
        C5 = GradeBookNumber % 5;
        C7 = GradeBookNumber % 7;
        //Декларуємо й ініціалізуємо константу С. Виводимо на консоль результати попередніх обчислень
        final int C = GradeBookNumber % 3;
        System.out.println("Значення С2 = " + C2 + " Отже, операція О1 = -");
        System.out.println("Значення С5 = " + C5 + " Отже, операція О2 = +");
        System.out.println("Значення С7 = " + C7 + " Отже, тип індексів i та j = int");
        //Вилучаємо дані, які користувач ввів у консоль за допомогою класа Scanner(попердньо імпортувавши пакет java.util)
        // й об'єкта System.in та зберігаємо іх в однойменні змінні
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть цілочисленне значення a: ");
        int a = in.nextInt();
        System.out.print("Введіть цілочисленне значення n: ");
        int n = in.nextInt();
        System.out.print("Введіть цілочисленне значення b: ");
        int b = in.nextInt();
        System.out.print("Введіть цілочисленне значення m: ");
        int m = in.nextInt();
        in.close();
        //Вводимо перевірку на недопустимі значення
        if (a <= C && n >= C) {
            System.out.println("Айяйя, ділення на нуль!");
            return;
        }
        //Використовуємо вкладені цикли для обчислення формули й отримання фінального значення, яке виводимо на екран консолі
        float finalSum = 0;
        for (int i = a; i <= n; i++) {
            for (int j = b; j <= m; j++) {
                finalSum += (float) (i + j) / (i - C);
            }
        }
        System.out.println(finalSum);
    }
}
