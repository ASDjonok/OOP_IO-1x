package laba4;

import java.util.Comparator;

public class getYearComparator implements Comparator<Educational_institution> {

    @Override
    public int compare(Educational_institution o1, Educational_institution o2) {
        return o1.getYear() - o2.getYear();
    }
}
