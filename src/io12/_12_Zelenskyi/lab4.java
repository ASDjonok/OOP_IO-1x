package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// C11 = 1213 % 11 = 3;
    // C11 = 3 => "Визначити клас літак, який складається як мінімум з 5-и полів.";
    //Створимо масив з об'єктів класу "Літак", який описали нижче
    Airplane[] planes = {
                new Airplane("Airbus A318", 132,5700, 31, 39500),
                new Airplane("Boeing 737-800", 160, 5400, 39.5, 63320),
                new Airplane("Boeing 777-300", 550, 11000, 73.9, 299370),
        };
    System.out.println("Наш невідсортований масив об'єктів типа 'літак'" + Arrays.toString(planes));
    Arrays.sort(planes);
    System.out.println("Вже відсортований за показником MaxRange масив об'єктів типа 'літак' " + Arrays.toString(planes));
    }

}
    //Створимо клас з 5 полів, та імплементуємо до нього інтерфес Comparable, а також метод CompareTo, задля сортування
    //масиву з об'єктів даного класу, додамо метод ToString для друку значень об'єктів на консоль
class Airplane implements Comparable<Airplane>{
    String AirplaneName;
    int SeatingCapacity;
    int MaxRange;
    double LengthOfAircraft;
    int MaxWeight;
    public Airplane(String AirplaneName, int SeatingCapacity,
                    int MaxRange, double LengthOfAircraft,
                    int MaxWeight)
    {
        this.AirplaneName = AirplaneName;
        this.SeatingCapacity = SeatingCapacity;
        this.MaxRange = MaxRange;
        this.LengthOfAircraft = LengthOfAircraft;
        this.MaxWeight = MaxWeight;
    }
    @Override
    public String toString() {
        return "Airplane{" +
                "AirplaneName='" + AirplaneName + '\'' +
                ", SeatingCapacity=" + SeatingCapacity +
                ", MaxRange=" + MaxRange +
                ", LengthOfAircraft=" + LengthOfAircraft +
                ", MaxWeight=" + MaxWeight +
                '}';
    }

    @Override
    public int compareTo(Airplane o) {
        return this.MaxRange - o.MaxRange;
    }
    // Щоб викликати сортування об'єктів за полем MaxRange за зворотнім порядком треба змінити код методу compareTo
    // таким чином:
    // @Override
    // public int compareTo(Airplane o) {
    //     return o.MaxRange - this.MaxRange;
    //    }
}
