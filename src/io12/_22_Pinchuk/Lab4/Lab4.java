package io12._22_Pinchuk.Lab4;

import java.util.Arrays;

public class Lab4 {
    public static void main(String[] args) {
        MyCar bmw = new MyCar("BMW X5", "Lime", 1998, 170, 268479);
        MyCar audi = new MyCar("Audi RX8", "Yellow", 2017, 200, 53594);
        MyCar subaru = new MyCar("Subaru K6", "Silver", 2005, 150, 128473);

        bmw.printCar();
        audi.printCar();
        subaru.printCar();

        MyCar[] car = {bmw, audi, subaru};

        System.out.println();
        Arrays.sort(car, MyCar.compareMileage);
        for (MyCar c : car) { System.out.println(c);}

        System.out.println();
        Arrays.sort(car, MyCar.compareHP);
        for (MyCar c : car) { System.out.println(c);}

        System.out.println();
        Arrays.sort(car, MyCar.compareName);
        for (MyCar c : car) { System.out.println(c);}
    }
}

