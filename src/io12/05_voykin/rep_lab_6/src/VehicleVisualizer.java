/**
 * Class provide methods for visualizing value of object fields.
 * Each passed class field will be added to final string.
 * Length of format string depends on order.
 * Each length applied consequently.
 */

import java.util.ArrayList;

import java.lang.StringBuffer;

public class VehicleVisualizer {

    private int pointer;
    private final StringBuffer buffer;
    private final ArrayList<String> templateList;

    /**
     * @param list list of lengths of each string passed in addField
     */
    public VehicleVisualizer (ArrayList<Integer> list) {
        this.pointer = 0;
        this.buffer = new StringBuffer();
        this.templateList = new ArrayList<String>();
        StringBuffer templateBuffer = new StringBuffer("%-");
        for (int length: list) {
            templateBuffer.append(length);
            templateBuffer.append("s");
            this.templateList.add(templateBuffer.toString());
            templateBuffer.delete(2, templateBuffer.length());
        }
    }

    /**
     * Adds string with formatted length, based on value of list,
     * passed to constructor.
     * @param phrase string representation of passed class field value
     */
    public void addField (String phrase) {
        this.buffer.append(String.format(
                this.templateList.get(this.pointer), phrase));
        pointer++;
    }

    /**
     * Obtaining final string, sets internal pointer to zero.
     * Next string passed in addField will be formatted with length,
     * defined by first element in list of lengths.
     * @return formatted string of fields passed in addFiled method
     */
    public String getString () {
        String result = this.buffer.toString();
        this.buffer.delete(0, this.buffer.length());
        this.pointer = 0;
        return result;

    }
}
