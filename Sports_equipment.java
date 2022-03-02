/*
 * Sports equipment class
 */

import java.util.Arrays;

public class Sports_equipment {
    float price;
    int year;
    String country;
    String size;
    String sex;

    /*
     * Sports_equipment class constructor contains 5 fields:
     * price, year of manufacturing, manufacture country, size and sex
     */
    public Sports_equipment(float price, int year, String country, String size, String sex) {
        this.price = price;
        this.year = year;
        this.country = country;
        this.size = size;
        this.sex = sex;
    }

    //main executable method
    public static void main(String[] args) {
//        int c11 = 1602%11; c11=7
//        System.out.println(c11);
        /* Creating objects of Sports_equipment class */
        final Sports_equipment racket = new Sports_equipment(350, 2011, "USA", "medium", "neutral");
        final Sports_equipment ball = new Sports_equipment(500, 2015, "France", "large", "neutral");
        final Sports_equipment boots = new Sports_equipment(1299, 2021, "Italy", "small", "female");
        final Sports_equipment skates = new Sports_equipment(999, 2018, "Ukraine", "medium", "male");
        Sports_equipment[] sports_equipment_array = {racket, ball, boots, skates};

        // start array output
        System.out.println("Початковий масив:");
        for (Sports_equipment sports_equipment : sports_equipment_array) {
            System.out.printf("%.1f, %d\n", sports_equipment.price, sports_equipment.year);
        }

        // sort algorithm for sports_equipment_array by price raise
        System.out.println("Сортований масив за зростанням ціни:");
        for (int i = 0; i < sports_equipment_array.length; i++) {
            Sports_equipment swap_obj = sports_equipment_array[i];
            for (int j = i; j < sports_equipment_array.length; j++) {
                if (swap_obj.price > sports_equipment_array[j].price) {
                    swap_obj = sports_equipment_array[j];
                }
            }
            sports_equipment_array[Arrays.asList(sports_equipment_array).indexOf(swap_obj)] = sports_equipment_array[i];
            sports_equipment_array[i] = swap_obj;
            System.out.printf("[ %.1f ]", sports_equipment_array[i].price);
        }

        // sort algorithm for sports_equipment_array by year descending
        System.out.println("\nСортований масив за зменшенням року:");
        for (int i = 0; i < sports_equipment_array.length; i++) {
            Sports_equipment swap_obj = sports_equipment_array[i];
            for (int j = i; j < sports_equipment_array.length; j++) {
                if (swap_obj.year < sports_equipment_array[j].year) {
                    swap_obj = sports_equipment_array[j];
                }
            }
            sports_equipment_array[Arrays.asList(sports_equipment_array).indexOf(swap_obj)] = sports_equipment_array[i];
            sports_equipment_array[i] = swap_obj;
            System.out.printf("[%5d ]", sports_equipment_array[i].year);
        }
    }

}