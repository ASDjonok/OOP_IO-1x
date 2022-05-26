package io12._14_Iliov.Lab4;

import java.util.Scanner;
//Визначити клас морський човен, який складається як мінімум з 5-и полів.
// Створити клас із виконавчим методом, в якому створити масив з об’єктів класу визначеному варіантом (п. 2).
// Відсортувати масив, за одним з полів, за зростанням, а за іншим, за спаданням використавши при цьому
// стандартні засоби сортування. Всі змінні повинні бути описані та значення їх задані у виконавчому методі.
// Код повиненвідповідати стандартам JCC та бути детально задокументований.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter count of ships");
        int count = sc.nextInt();
        Port a = new Port(count);
        System.out.println("Default fleet :");
        a.print_fleet(a.fleet,count);
        System.out.println("-------------------------------------");
        a.fromBtoS_speed(a.fleet);
        System.out.println("From big to small SPEED fleet :");
        a.print_fleet(a.fleet,count);
        System.out.println("-------------------------------------");
        a.fromStoB_age(a.fleet);
        System.out.println("From small to big AGE fleet :");
        a.print_fleet(a.fleet,count);
        System.out.println("-------------------------------------");
    }
}
