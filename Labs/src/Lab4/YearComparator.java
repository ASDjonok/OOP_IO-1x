package Lab4;

import java.util.Comparator;

public class YearComparator implements Comparator<Crew> {
    @Override
    public int compare(Crew firstCrew, Crew secondCrew) {
        return Integer.compare(firstCrew.getYears(), secondCrew.getYears());
    }
}
