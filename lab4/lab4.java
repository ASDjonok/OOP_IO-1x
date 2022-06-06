import java.util.ArrayList;

import java.util.Comparator;

public class lab4 {

    public static final ArrayList<Plane> PlaneArr = new ArrayList<>();


    public static void main(String[] args) {
        addPlanes();
        PlaneArr.sort(Comparator
                .comparing(Plane::getlength)
                .thenComparing(Plane::getcrew, Comparator.reverseOrder()));
        PlaneArr.forEach(Plane::print);
    }

    private static void addPlanes() {
        PlaneArr.add(new Plane ("F-16", "Grey","USA",15,1));
        PlaneArr.add(new Plane ("Mig-29MU2", "Blue","Ukraine",17,1));
        PlaneArr.add(new Plane ("Mirage", "Black","France",14,1));
        PlaneArr.add(new Plane ("T-2", "Brown","Japan",18,2));
        PlaneArr.add(new Plane ("B-2", "Black","USA",21,5));
    }
}





