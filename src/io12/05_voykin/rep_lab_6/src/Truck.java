/**
 * Class dedicated for representing truck and it`s specs.
 */
public class Truck extends Car implements IVehicle{
    private final String type = "truck";
    private final int capacity;

    /**
     * Other parameters and metrics specified in Car class.
     * @param capacity signify maximum capacity, measured in kg
     */
    public Truck (int weight, double fuelConsumption, int price, int productionYear,
                     String manufacturer, int maxSpeed, int capacity) {
        super(weight, fuelConsumption, price, productionYear,
                manufacturer, maxSpeed);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return this.type;
    }

    /**
     * Accumulates values of class fields in VehicleVisualizer instance.
     * @param visualizer instance of VehicleVisualizer
     */
    public void addFields (VehicleVisualizer visualizer) {
        super.addFields(visualizer);
        visualizer.addField(this.type);
        visualizer.addField(String.valueOf(this.capacity));
    }
}
