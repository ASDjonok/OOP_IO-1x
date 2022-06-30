package lab4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

        Student student3 = new Student("Oleksii II", "Aleshchenko", 17, Level.LOW, "", "");

        Student[] students = {student3, student2, student};
        student2.setLevel(Level.LOW);
        student.setLevel(Level.HIGH);
        System.out.println("Not sorted:");
//        System.out.println(Arrays.deepToString(students));
        printArray(students);
//        System.out.println(students);
//        Arrays.sort(students/*, Collections.reverseOrder()*/);
//        Arrays.sort(students, new NameComparator());
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getLevel().compareTo(o2.getLevel());
            }
        });
        System.out.println("Sorted by name:");
//        System.out.println(Arrays.toString(students));
        printArray(students);

        Arrays.sort(students, new LevelComparator().reversed());
        System.out.println("Sorted by level reversed:");
        printArray(students);
//        System.out.println(student.compareTo("123"));
        /*Student.setIsSortedByName(false);
        Arrays.sort(students);
        System.out.println("Sorted by level in direct order:");
        printArray(students);*/

//        Student student3 = new Student("Oleksii III", "Aleshchenko I");

        // ...

//        student3.setFaculty("IPSA", "II-11");
        /*System.out.println(student.compareTo(student2));
        System.out.println((int)'A');
        System.out.println((int)'O');*/
        /*student.name = "Svitlana";
        System.out.println(student.name);*/
        /*System.out.println(student);
        System.out.println("Done!");*/
        /*for (;*//*false*//*;) {
            System.out.println("AAAA!!!");
        }*/
    }

    private static void printArray(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
