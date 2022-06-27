import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.lang.Math;

/***
 * Class contain methods required in lab 4 of oop course
 * @author Vadim Voykin
 * @version 0.1
 */
public class Lab4 {
    /***
     * Method create collection of object of Cosmetics type
     * @param argv not used in current program
     */
    public static void main(String[] argv) {
        List<Cosmetics> list = new ArrayList<>();
        list.add(new Cosmetics("lipstick", "Global-cosmatics", "Italy", 5.0, false));
        list.add(new Cosmetics("lipstick", "Global-cosmatics", "Italy", 5.0, true));
        list.add(new Cosmetics("lipstick", "Global-cosmatics", "Italy", 12, false));
        list.add(new Cosmetics("lipstick", "Global-cosmatics", "Italy", 19, false));
        list.add(new Cosmetics("eye shadows", "Guerlain", "Germany", 12.0, true));
        list.add(new Cosmetics("eye shadows", "Guerlain", "Germany", 17.0, false));
        list.add(new Cosmetics("eye shadows", "Global-cosmatics", "Italy", 21, false));
        list.add(new Cosmetics("eye shadows", "Global-cosmatics", "Italy", 27, false));
        list.add(new Cosmetics("cleaner", "Loreal", "France", 15.0, false));
        list.add(new Cosmetics("cleaner", "Loreal", "France", 19.0, false));
        list.add(new Cosmetics("cleaner", "Loreal", "France", 31.0, false));
        list.add(new Cosmetics("cleaner", "Guerlain", "Germany", 11.0, true));
        list.add(new Cosmetics("cleaner", "Guerlain", "Germany", 17.0, false));
        list.add(new Cosmetics("cleaner", "Guerlain", "Germany", 21.0, false));

        Collections.sort(list, new SortByPriceInc());
        printCollection(list);

        Collections.sort(list, new SortByTitleDec());
        printCollection(list);

    }

    /***
     * Method print instances of objects, contained in collection,
     * in specified number of places
     * @param list represent collection of objects of Cosmetics class
     */
    private static void printCollection(List<Cosmetics> list) {

        // Get length required by fields to display in correctly
        int[] space = {5, 12, 7, 5, 5};
        getFieldLength(space, list);

        // form format string considering length of fields
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < space.length; ++i) {
            strBuffer.append('%');
            strBuffer.append('-');
            strBuffer.append(space[i]);
            strBuffer.append('s');
            if (i + 1 < space.length) {
                strBuffer.append(" | ");
            }
        }
        strBuffer.append("\n");
        String stringTemplate = strBuffer.toString();

        System.out.format(stringTemplate,
                "Title", "Manufacturer", "Country",
                "Price", "Contains allergens");

        for (Cosmetics cosm : list) {
            System.out.format(stringTemplate,
                    cosm.title, cosm.manufacturer,
                    cosm.manufacturerCountry, cosm.price,
                    cosm.containsAllergens);
        }
        System.out.println();
    }

    /***
     * Determine length of num considering three place for decimal part
     * @param num number to determine length of
     * @return length of num + 3 for decimal places
     */
    private static int getNumLength(int num) {
        int numLength = -1;
        while (true) {
            if (num / (int) Math.pow(10, ++numLength) == 0) {
                return numLength + 3;
            }
        }
    }

    /***
     * run through object and determine maximum length of each fiels
     * @param lengthArray array of the length of fields of object contained in objList
     * @param objList list of object ot inspect
     */
    private static void getFieldLength(int[] lengthArray, List<Cosmetics> objList) {
        for (Cosmetics obj : objList) {
            int currLength = obj.title.length();
            if (currLength > lengthArray[0]) {
                lengthArray[0] = currLength;
            }
            currLength = obj.manufacturer.length();
            if (currLength > lengthArray[1]) {
                lengthArray[1] = currLength;
            }
            currLength = obj.manufacturerCountry.length();
            if (currLength > lengthArray[2]) {
                lengthArray[2] = currLength;
            }
            currLength = getNumLength((int) obj.price);
            if (currLength > lengthArray[3]) {
                lengthArray[3] = currLength;
            }
        }
    }
}

/***
 * Class sorting objects by increasing price.
 * If price is equal, sorts by increasing allergen content.
 * @author Vadim Voykin
 * @version 0.1
 */
class SortByPriceInc implements Comparator<Cosmetics> {
    @Override
    public int compare(Cosmetics prod1, Cosmetics prod2) {
        double temp = prod1.price - prod2.price;
        if (temp < 0.001 && temp > -0.001) {
            if (prod1.containsAllergens == prod2.containsAllergens) {
                return 0;
            } else if (prod2.containsAllergens) {
                return 1;
            } else {
                return -1;
            }
        }
        if (temp > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}

/***
 * Sorts objects by decreasing title.
 * @author Vadim Voykin
 * @version 0.1
 */
class SortByTitleDec implements Comparator<Cosmetics> {
    @Override
    public int compare(Cosmetics prod1, Cosmetics prod2) {
        return prod2.title.compareTo(prod1.title);
    }
}

/***
 * Class represent Cosmetic product.
 * Contain title, manufacturer, manufacturerCountry,
 * price, containsAllergens instances.
 * @author Vadim Voykin
 * @version 0.1
 */
class Cosmetics {
    String title;
    String manufacturer;
    String manufacturerCountry;
    double price; // Euro
    boolean containsAllergens;

    /***
     * @param title type of product
     * @param manufacturer name of company-manufacturer
     * @param manufacturerCountry country of company-manufacturer
     * @param price price of product in Euro
     * @param containsAllergens represent containment of allergens
     */
    public Cosmetics(
            String title, String manufacturer,
            String manufacturerCountry,
            double price, boolean containsAllergens) {

        this.title = title;
        this.manufacturer = manufacturer;
        this.manufacturerCountry = manufacturerCountry;
        this.price = price;
        this.containsAllergens = containsAllergens;
    }
}
