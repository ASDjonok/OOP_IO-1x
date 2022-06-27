import java.util.Comparator;
import java.util.ArrayList;

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
        ArrayList<Cosmetics> list = new ArrayList<>();
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

        list.sort(new SortByPriceInc());
        printCollection(list);

        list.sort(new SortByTitleDec());
        printCollection(list);

    }

    /***
     * Method print instances of objects, contained in collection,
     * in specified number of places
     * @param list represent collection of objects of Cosmetics class
     */
    private static void printCollection(ArrayList<Cosmetics> list) {

        String stringTemplate = "%-15s|%-20s|%-10s|%-10s|%s\n";
        System.out.format(stringTemplate,
                "Title", "Manufacturer", "Country",
                "Price", "Contains allergens");

        for (Cosmetics cosm : list) {
            System.out.format(stringTemplate,
                    cosm.getTitle(), cosm.getManufacturer(),
                    cosm.getManufacturerCountry(), cosm.getPrice(),
                    cosm.isContainsAllergens());
        }
        System.out.println();
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
        double temp = prod1.getPrice() - prod2.getPrice();
        // object relatively same for double type
        if (temp < 0.001 && temp > -0.001) {
            // whatever both contains allergens or not, they are equal
            if (prod1.isContainsAllergens() == prod2.isContainsAllergens()) {
                return 0;
            }
            return prod2.isContainsAllergens() ? -1 : 1;
        }
        return temp > 0 ? 1 : -1;
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
        return prod2.getTitle().compareTo(prod1.getTitle());
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
    final String title;
    final String manufacturer;
    final String manufacturerCountry;
    final double price; // Euro
    final boolean containsAllergens;

    public String getTitle() {
        return title;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public double getPrice() {
        return price;
    }

    public boolean isContainsAllergens() {
        return containsAllergens;
    }

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
