package lab4;

import java.util.Objects;

/**
 * Це мій найулюбленіший клас студента, який краще від усіх
 * інших аналогів класів студент. Ніхто в світі не напише класу краще ніж цей.
 */
public class Student implements Comparable {
    /**
     * That's my name:)
     */
    private /*static*/ String name/* = "Oleksii"*/;

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
        setName(name);
    }

    Student() {
        name = "Oleksii";
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
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

    @Override
    public int compareTo(Object o) {
        return /*this.*/name.compareTo(((Student)o).name);
    }
}
