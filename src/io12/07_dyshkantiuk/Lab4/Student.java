package Lab4;

import java.util.Comparator;
import java.lang.String;

public class Student {
    private String name;
    private String surname;
    private String faculty;
    private String group;
    private int numberInGroup;

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getFaculty() { return faculty; }
    public String getGroup() { return group; }
    public int getNumberInGroup() { return numberInGroup; }

    public Student(String name, String surname, String faculty, String group, int numberInGroup) {
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.group = group;
        this.numberInGroup = numberInGroup;
    }

    @Override
    public String toString() { return this.name + this.surname + this.faculty + this.group + this.numberInGroup; }

    public static Comparator<Student> nameComparator = Comparator.comparing(Student::getName);

    public static Comparator<Student> numberComparator = (o1, o2) -> (o2.getNumberInGroup() - o1.getNumberInGroup());

}
