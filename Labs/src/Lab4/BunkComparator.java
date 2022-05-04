package Lab4;

import java.util.Comparator;

public class BunkComparator implements Comparator<Crew> {
    @Override
    public int compare(Crew firstCrew, Crew secondCrew) {
        return Integer.compare(firstCrew.getBunk(), secondCrew.getBunk());
    }
}
