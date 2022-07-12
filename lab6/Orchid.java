public class Orchid extends Flower {

    public Orchid() {
        super();
        setNameOfFlower("Orchid");
    }

    public Orchid(int f, double l, int p) {
        super(f, l, p);
        setNameOfFlower("Orchid");
    }

    public int total_price() {
        return getPrice();
    }

}
