package io12._22_Pinchuk.Lab4;

import java.util.Comparator;

public class MyCar{
    String name;
    String colour;
    int year;
    int horsePower;
    int mileage;

    public MyCar(String name, String colour, int year, int horsePower, int drivenDist){
        setName(name);
        setColour(colour);
        setYear(year);
        setHorsePower(horsePower);
        setMileage(drivenDist);
    }

    public void printCar(){
        System.out.println("\n" + getName());
        System.out.println("Colour: " + getColour());
        System.out.println("Year of manufacture: " + getYear());
        System.out.println("Horse power: " + getHorsePower());
        System.out.println("Driven Distance: " +
                getMileage() + "km");
    }

    @Override
    public String toString(){
        return name + " " + horsePower + "HP " + mileage + "km";
    }

    public static Comparator<MyCar> compareName = Comparator.comparing(MyCar::getName);
    public static Comparator<MyCar> compareHP = Comparator.comparingInt(MyCar::getHorsePower);
    public static Comparator<MyCar> compareMileage = (km1, km2) -> (km2.getMileage() - km1.getMileage());

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour){
        this.colour = colour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower){
        this.horsePower = horsePower;
    }

    public int getMileage(){
        return mileage;
    }

    public void setMileage(int drivenDist){
        this.mileage = drivenDist;
    }
}
