public class Lab6 {

    public static String printFlowerParameters(Flower f) {
        return "Flower \"" + f.getNameOfFlower() + "\" cost " + f.getPrice() + " UAH" + ", her length is " + f.getLength() + " cm" + ", her freshness is " + f.getFreshness() + " days.";
    }

    public static void outputArray(Flower[] bouquet) {
        for (Flower flower : bouquet) {
            System.out.println(printFlowerParameters(flower));
        }
    }

    public static Flower searchByFlowerLength(Flower[] bouquet, double length1, double length2) {
        Flower result = bouquet[0];
        for (Flower flower : bouquet) {
            if (flower.getLength() >= length1 && flower.getLength() <= length2)
                result = flower;
        }
        return result;
    }

    static void totalBouquetPrice(Flower[] bouquet) {
        int totalPrice = 0;
        for (Flower flower : bouquet) {
            totalPrice += flower.getPrice();
        }
        System.out.println("Total bouquet price: " + totalPrice + " UAH");
    }

    static void sortByFreshness(Flower[] bouquet) {
        System.out.println("Bouquet is sorted by decision of freshness:");
        Flower buf;
        for (int i = 0; i <= 7 - 1; i++) {
            for (int j = 0; j <= 7 - 1; j++) {
                if (bouquet[i].getFreshness() > bouquet[j].getFreshness()) {
                    buf = bouquet[i];
                    bouquet[i] = bouquet[j];
                    bouquet[j] = buf;
                }
            }
        }
    }

    public static void main(String[] args) {
        final int count = 7;
        Flower[] bouquet = new Flower[count];
        bouquet[0] = new Rose(3, 50.5, 80);
        bouquet[1] = new Rose(4, 49.6, 80);
        bouquet[2] = new Rose(3, 48.0, 80);
        bouquet[3] = new Orchid(2, 28.3, 120);
        bouquet[4] = new Orchid(2, 27.9, 110);
        bouquet[5] = new Lily(1, 15.4, 50);
        bouquet[6] = new Rose();

        System.out.println("Bouquet consists of:");
        outputArray(bouquet);

        System.out.println();
        sortByFreshness(bouquet);
        outputArray(bouquet);

        System.out.println();
        System.out.println("Searched Flower by length:");
        System.out.println(printFlowerParameters(searchByFlowerLength(bouquet, 10.0, 50.0)));
        System.out.println();
        totalBouquetPrice(bouquet);
    }
}
