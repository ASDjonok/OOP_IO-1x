/**
 * Ensures support of interface, used for converting string representation of object.
 */
public interface IVehicle {
    /**
     * Method used to pass internal class fields to VehicleVisualizer object,
     * that accumulates and formats value of fields, passed in it.
     * @param visualizer instance of VehicleVisualizer, which accumulate field values
     */
    void addFields(VehicleVisualizer visualizer);
}
