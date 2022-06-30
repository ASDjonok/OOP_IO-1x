/**
 * C2 = 1106 % 2 = 0 ->
 * C3 = 1106 % 3 = 2 ->
 * C5 = 1106 % 5 = 1 ->
 * C7 = 1106 % 7 = 0 ->
 * C11 = 1106 % 11 = 6 ->
 * Визначити клас косметика, який складається як мінімум з 5-и полів.
 * C17 = 1106 % 17 = 1 ->
 */

import java.util.Random;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cosmetics> list = new ArrayList<Cosmetics>();
        for (int i=0; i<10; i++) {
            list.add(new Cosmetics());
        }
        System.out.println("Sorted by price");
        list.sort(new PriceSorter());
        printArray(list);
        System.out.println("Sorted by year");
        list.sort(new YearSorter());
        printArray(list);
    }

    public static void printArray (ArrayList<Cosmetics> array) {
        System.out.format("%-8s%-7s%-6s%-20s%-20s\n",
                "price", "weight", "year",
                "containsAllergens", "manufacturer");
        for (Cosmetics currElement: array) {
            System.out.println(currElement);
        }
        System.out.println();
    }
}

class Cosmetics {
    final int weight;
    final int price;
    final int year;
    final boolean containsAllergens;
    final String manufacturer;

    final String[] manufacturers = {"Lor`eal", "Head&Shoulders"};

    final String[] templates = {"%-8s", "%-7s", "%-6s", "%-20s", "%-20s"};

    public Cosmetics () {
        Random rand = new Random();
        this.weight = rand.nextInt(200) + 1;
        this.price = rand.nextInt(50) + 1;
        this.year = rand.nextInt(8) + 2015;
        this.containsAllergens = rand.nextBoolean();
        this.manufacturer = this.manufacturers[rand.nextInt(
                this.manufacturers.length)];
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public boolean isContainsAllergens() {
        return containsAllergens;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String[] getManufacturers() {
        return manufacturers;
    }

    public String toString () {
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(String.format(this.templates[0],
                this.price));
        strBuffer.append(String.format(this.templates[1],
                this.weight));
        strBuffer.append(String.format(this.templates[2],
                this.year));
        strBuffer.append(String.format(this.templates[3],
                this.containsAllergens));
        strBuffer.append(String.format(this.templates[4],
                this.manufacturer));
        return strBuffer.toString();
    }
}

class PriceSorter implements Comparator<Cosmetics> {
    public int compare (Cosmetics  c1, Cosmetics c2) {
        return c1.getPrice() - c2.getPrice();
    }
}

class YearSorter implements Comparator<Cosmetics> {
    public int compare (Cosmetics  c1, Cosmetics c2) {
        return c2.getYear() - c1.getYear();
    }
}