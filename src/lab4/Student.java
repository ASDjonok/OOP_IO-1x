package lab4;

import java.util.Objects;

/**
 * Це мій найулюбленіший клас студента, який краще від усіх
 * інших аналогів класів студент. Ніхто в світі не напише класу краще ніж цей.
 */
public class Student implements Comparable<Student> {
    /**
     * That's my name:)
     */
    private /*static*/ String name /*= "Oleksii"*/;
    private String surname;
    private int age;
    private Level level;
    private String faculty;
    private String group;

    /*private static boolean isSortedByName = true;

    public static void setIsSortedByName(boolean isSortedByName) {
        Student.isSortedByName = isSortedByName;
    }*/

    public Student(String name, String surname, int age, Level level, String faculty, String group) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.level = level;
        this.faculty = faculty;
        this.group = group;
    }

    public void setFaculty(String faculty, String newGroup) {
        this.faculty = faculty;
        group = newGroup;
    }

    /*{
        surname = "Aleshchenko";
    }*/
    /*public static void main(String[] args) {
        Student student = new Student();
        student.name = "B";
        System.out.println(student.name);
    }*/

    /**
     *
     * @param name ім'я (можна кирилицею адо латиницею)
     */
    public Student(String name) {
//        this.name = name;
//        setName(name);
        this(name, "Aleshchenko");
    }

    /**
     *
     * @param name ім'я (можна кирилицею адо латиницею)
     * @param name прізвище (можна кирилицею адо латиницею)
     */
    public Student(String name, String surname) {
//        this.surname = surname;
        setName(name);
        setSurname(surname);
    }

    public Student() {
//        name = "Oleksii";
        this("Oleksii");
    }

    /**
     * Повертає ім'я студента
     * @return ім'я
     */
    public String getName() {
        return name;
    }

    public void setName(String name, String password) {
        if ("1111".equals(password)) {
            setName(name);
        } else {
            System.out.println("Access denied!");
        }
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", level=" + level +
                ", faculty='" + faculty + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
//        return /*this.*/name.equals(((Student)o).name);
        Student student = (Student) o;
        return Objects.equals(name, student.name);
        /*if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

//    @Override
//    public int compareTo(Object o, boolean b) {
//        return /*this.*/name.compareTo(((Student)o).name);
//        return level.compareTo(((Student)o).level);
//    }


    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public int compareTo(Student/*Object*/ o) {
        /*return isSortedByName
                ? name.compareTo(((Student)o).name)
                : level.compareTo(((Student)o).level);*/
        /*final int nameCompareResult = name.compareTo(((Student) o).name);
        return nameCompareResult != 0 ? nameCompareResult : -level.compareTo(((Student)o).level);*/
        final int nameCompareResult = name.compareTo(o.name);
        return nameCompareResult != 0 ? nameCompareResult : -level.compareTo(o.level);
    }
}
