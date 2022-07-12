public class Flower {
    private int freshness;
    private double length;
    private int price;
    private String nameOfFlower;

    public Flower(int f, double l, int p) {
        int max_freshness = 5;
        if (f <= max_freshness) freshness = f;
        double max_length = 100;
        if (l <= max_length) length = l;
        int max_price = 120;
        if (p <= max_price) price = p;
        nameOfFlower = "chrysanthemum";
    }

    public Flower() {

    }

    public int getFreshness() {
        return freshness;
    }

    public double getLength() {
        return length;
    }

    public int getPrice() {
        return price;
    }

    public String getNameOfFlower() {
        return nameOfFlower;
    }

    public void setNameOfFlower(String fl) {
        nameOfFlower = fl;
    }

}
