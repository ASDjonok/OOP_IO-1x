package Lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Ship {
    private ArrayList<Crew> _memberList = new ArrayList<>();

    public void addCrew(Crew newCrew) {
        _memberList.add(newCrew);
    }

    public void bunkSort() {
        _memberList.sort(new BunkComparator());
    }

    public void yearSort() {
        _memberList.sort(new YearComparator().reversed());
    }

    public String getInfo() {
        return _memberList.stream().map(Crew::toString).collect(Collectors.joining("\n"));
    }
}
