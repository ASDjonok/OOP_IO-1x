package Lab4;

public class CrewWriter {
    public Crew write(String name, String rank, String callSign, int bunk, int years) {
        if (bunk <= 0 || bunk > 50) throw new IllegalArgumentException("There are only natural numbers of bunk and" +
                "there are no more than 50 of them");
        if (years < 0 || years > 50) throw new IllegalArgumentException("The crew cannot spend a negative number of " +
                "years in service, or more than 50 years, because they are retiring");

        return new Crew(name, rank, callSign, bunk, years);
    }
}
