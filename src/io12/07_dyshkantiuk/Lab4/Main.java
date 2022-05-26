package Lab4;

import java.util.Arrays;

public class Main {
    public static void write(Student[] students, String by) { // Метод написання
        System.out.println("Sorted by " + by + ":");
        System.out.println("_____________________________________________________");
        System.out.printf("|%-10s|%-10s|%-7s|%-5s|%-15s|\n", "Name", "Surname", "Faculty", "Group", "Number in group");
        System.out.println("_____________________________________________________");
        for (Student i: students){
            System.out.printf("|%-10s|%-10s|%-7s|%-5s|%-15s|\n", i.getName(), i.getSurname(), i.getFaculty(), i.getGroup() ,i.getNumberInGroup());
        }
        System.out.println("_____________________________________________________\n");
    }
    public static void main(String[] args) {
        Student[] students = {
                new Student("Oleksandr", "Yarchenko", "FIOT", "ІО-12", 14),
                new Student("Sergiy", "Pokidyuk", "FIOT", "ІО-12", 3),
                new Student("Ruslana", "Sidoruk", "FIOT", "ІО-12", 21),
        };
        int C11 = 1209 % 11;
        System.out.println("C11 = " + C11 + "\n");

        Arrays.sort(students, Student.nameComparator); // Сортування за name
        write(students, "name");

        Arrays.sort(students, Student.numberComparator); // Сортування за number
        write(students, "number");
    }
}
