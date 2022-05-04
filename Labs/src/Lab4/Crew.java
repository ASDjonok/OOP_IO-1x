package Lab4;

public class Crew {
    private final String _name, _rank, _callSign;
    private final int _bunk, _yearsofService;

    public Crew(String name, String rank, String callSign, int bunk, int years) {
        this._name = name;
        this._rank = rank;
        this._callSign = callSign;
        this._bunk = bunk;
        this._yearsofService = years;
    }

    public String getName() {
        return _name;
    }

    public String getRank() {
        return _rank;
    }

    public String getCallSign() {
        return _callSign;
    }

    public int getBunk() {
        return _bunk;
    }

    public int getYears() {
        return _yearsofService;
    }

    @Override
    public String toString() {
        String crewMateInfo = "%s. Звання: %s. Позивний: %s. Перебуває у %d-ому ліжку. Років служби: %d";
        return String.format(crewMateInfo, getName(), getRank(), getCallSign(), getBunk(), getYears());
    }
}
