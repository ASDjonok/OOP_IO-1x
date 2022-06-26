/**
 * Class describes several characteristics of car, provide getters and
 * method for converting values of class fields into string.
 */

public class Car implements IVehicle{

    private int wheelsNumber = 4;
    private final int weight;
    private final double fuelConsumption;
    private final int price;
    private final int productionYear;
    private final String manufacturer;
    private final int maxSpeed;

    /**
     * @param weight weight of car, measured in kg
     * @param fuelConsumption fuel consumptions, measured in liter per 100 km
     * @param price price of car, measured in dollars
     * @param productionYear year of production of car
     * @param manufacturer brand of manufacturer
     * @param maxSpeed maximal speed of Car, measured in km per hour
     */
    public Car (int weight, double fuelConsumption, int price, int productionYear,
                String manufacturer, int maxSpeed) {
        this.weight = weight;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.productionYear = productionYear;
        this.manufacturer = manufacturer;
        this.maxSpeed = maxSpeed;
    }

    public void setWheelsNumber (int number) {
        this.wheelsNumber = number;
    }

    public int getWheelsNumber() {
        return wheelsNumber;
    }

    public int getWeight() {
        return weight;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Method used for converting values of class fields into string representation.
     * @param visualizer instance of VehicleVisualizer, which accumulates filed values
     */
    public void addFields (VehicleVisualizer visualizer) {
        visualizer.addField(String.valueOf(this.weight));
        visualizer.addField(String.valueOf(this.fuelConsumption));
        visualizer.addField(String.valueOf(this.price));
        visualizer.addField(String.valueOf(this.manufacturer));
        visualizer.addField(String.valueOf(this.productionYear));
        visualizer.addField(String.valueOf(this.maxSpeed));
    }
}
