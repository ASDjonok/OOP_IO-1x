package laba4;

import java.util.Comparator;

public class getStudentsComparator implements Comparator<Educational_institution> {

    @Override
    public int compare(Educational_institution o1, Educational_institution o2) {
        return o2.getYear() - o1.getYear();
    }
}
