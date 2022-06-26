/**
 * Class dedicated for representing sport car and it`s specs.
 */

public class SportCar extends Car implements IVehicle{

    private final String type = "sportCar";
    private final double acceleration;

    /**
     * Other parameters and metrics specified in Car class.
     * @param acceleration acceleration of car, measured in m/s^2
     */
    public SportCar (int weight, double fuelConsumption, int price, int productionYear,
                     String manufacturer, int maxSpeed, double acceleration) {
        super(weight, fuelConsumption, price, productionYear,
                manufacturer, maxSpeed);
        this.acceleration = acceleration;
    }

    public double getAcceleration() {
        return acceleration;
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
        visualizer.addField(String.valueOf(this.acceleration));
    }
}
