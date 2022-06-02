package lab4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Student.name = "A";
        new Student();
        Student student = new Student("Oleksii III");
//        student.name = "Oleksii";
//        student.setName("Oleksii");
//        System.out.println(student.name);
        System.out.println(student.getName());
        String password = "11";
        String password2 = null;
        System.out.println(password);
        password += "11";
        System.out.println(password);
        student.setName("Oleksii II", password);
        System.out.println(student.getName());

        Student student2 = new Student("Aleksii II");
        System.out.println(student2.getName());
        System.out.println(student.getName());
        System.out.println(student == student2);
        System.out.println(student.equals(student2));
        System.out.println(student);
        System.out.println(student.equals("A"));
        System.out.println(student.equals(null));
        System.out.println(student.equals(student));
        System.out.println(student.hashCode());
        System.out.println(student2.hashCode());
//        ...

        Student[] students = {student, student2};
        Arrays.sort(students);
        /*student.name = "Svitlana";
        System.out.println(student.name);*/
        /*System.out.println(student);
        System.out.println("Done!");*/
        /*for (;*//*false*//*;) {
            System.out.println("AAAA!!!");
        }*/
    }
}
