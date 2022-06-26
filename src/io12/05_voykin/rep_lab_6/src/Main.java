/**
 * Main class of lab program.
 */

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.stream.Collectors;

public class Main {

    /**
     * main method act as enter point of program
     * @param args not currently used
     */
    public static void main(String[] args) {
        ArrayList<Car> carPark = new ArrayList<Car>();
        Random ran = new Random(38);
        for (int i=0; i<10; i++) {
            carPark.add(new SportCar(
                    getRandomInt(800, 1500, 100, ran),
                    getRandomDouble(20, 50, 10, ran),
                    getRandomInt(1000000, 10000000, 100000, ran),
                    getRandomInt(1950, 2022, 1, ran),
                    "Lamborghini",
                    getRandomInt(250, 340, 10, ran),
                    getRandomInt(25, 50, 1, ran)
            ));
        }
        for (int i=0; i<10; i++) {
            carPark.add(new Truck(
                    getRandomInt(1100, 1700, 100, ran),
                    getRandomDouble(10, 50, 10, ran),
                    getRandomInt(100000, 2000000, 10000, ran),
                    getRandomInt(1970, 2022, 1, ran),
                    "Jeep",
                    getRandomInt(170, 250, 10, ran),
                    getRandomInt(100, 500,10, ran)
            ));
        }
        // sorting and printing ArrayList
        printCarPark(carPark);
        carPark.sort(new fuelConsumptionSort());
        printCarPark(carPark);
        long carParkPrice = getCarParkCost(carPark);
        System.out.format("total price: %d\n", carParkPrice);
        // promoting to enter filter parameter  value
        // and filter by that value and parameter
        Scanner keyboard = new Scanner(System.in);
        try {
            System.out.print("Enter minimal speed: ");
            int minVal = keyboard.nextInt();
            ArrayList<Car> filteredCars =
                    (ArrayList<Car>) carPark.stream()
                    .filter(c -> c.getMaxSpeed() > minVal)
                    .collect(Collectors.toList());
            printCarPark(filteredCars);
        } catch (InputMismatchException e) {
            System.out.println("No integer detected");
        }
    }

    /**
     * prints header with fields names
     * and values of instances in ArrayList list
     * @param list ArrayList of Car instances
     */
    public static void printCarPark (ArrayList<Car> list) {
        if (list.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        ArrayList<Integer> lengthList = new ArrayList<>();
        int[] lengthArray = {8, 17, 10, 16, 14, 10 ,10, 14};
        for (int i=0; i<lengthArray.length; i++) {
            lengthList.add(lengthArray[i]);
        }
        VehicleVisualizer vis = new VehicleVisualizer(lengthList);
        String[] titleArray = {"weight", "fuelConsumption", "price", "productionYear",
                          "manufacturer", "maxSpeed", "type", "accel/capacity"};
        for (int i=0; i<titleArray.length; i++) {
            vis.addField(titleArray[i]);
        }
        System.out.println(vis.getString());
        for (Car currCar: list) {
            currCar.addFields(vis);
            System.out.println(vis.getString());
        }
        System.out.println();
    }

    /**
     * Calculate total price of Car instances, contained in list parameter
     * @param list ArrayList of Car instances
     * @return
     */
    public static long getCarParkCost (ArrayList<Car> list) {
        long sum = 0;
        for (Car currCar: list) {
            sum += currCar.getPrice();
        }
        return sum;
    }

    /**
     * Tests getRandomInt and getRandomDouble simultaneously.
     */
    public static void testGetRandom () {
        Random ran = new Random();
        boolean success = true;
        for (int i=0; i<954770; i++){
            int num = getRandomInt(1100, 1700, 100, ran);
            if (num < 1100 || num > 1700) {
                success = false;
                break;
            }
            double number = getRandomDouble(11, 17, 100, ran);
            if (number < 11 || number > 17) {
                success = false;
                break;
            }

        }
        String result = success ? "Success" : "Fail";
        System.out.println(result);
    }

    /**
     * Returns random value from "start" to "end" inclusively with step "step".
     * If start smaller that end of step equals to zero method returns "start" value.
     * Parameter "ran" if passed for higher performance.
     * @param start minimal value of range
     * @param end maximal value of range
     * @param step magnitude of step of range
     * @param ran instance of Random class
     * @return integer in specified range
     */
    public static int getRandomInt (int start, int end, int step, Random ran) {
        if (start < end && step == 0) {
            return start;
        }
        return (ran.nextInt((end - start) / step + 1) * step) + start;
    }


    /**
     * Returns random value from "start" to "end" inclusively with
     * "divisions" divisions between two consecutive integer numbers.
     * If "start" lower that "end" or "divisions" lower than 1, method returns "start" value.
     * Parameter "ran" if passed for higher performance.
     * @param start minimal value of range
     * @param end maximal value of range
     * @param divisions  number of divisions between two consecutive integer numbers
     * @param ran instance of Random class
     * @return double in specified range
     */
    public static double getRandomDouble (int start, int end,
                                          int divisions, Random ran) {
        if (start < end && divisions < 1) {
            return start;
        }
        int currRange = ((end - start) * divisions) + 1;
        return (double) (ran.nextInt(currRange) + start * divisions) / divisions;
    }
}

/**
 * Class for sorting list of Car instances.
 */
class fuelConsumptionSort implements Comparator<Car> {
    /**
     * Compares objects based on fuelConsumption
     * @param c1 the first object to be compared.
     * @param c2 the second object to be compared.
     * @return int value in format, specified by Comparator interface
     */
    public int compare(Car c1, Car c2) {
        return Double.compare(
                c1.getFuelConsumption(), c2.getFuelConsumption());
    }
}