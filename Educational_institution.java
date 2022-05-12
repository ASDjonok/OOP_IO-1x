package laba4;

public class Educational_institution {
    String name;
    String city;
    String country;
    int year;
    int students;

    public Educational_institution(String name, String city, String country, int year, int students) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.year = year;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public int getStudents() {
        return students;
    }
}