package laba4;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final Educational_institution kpi = new Educational_institution("KPI", "Kyiv",
                "Ukraine", 1898, 25000);
        final Educational_institution hnu = new Educational_institution("HNU", "Kharkiv",
                "Ukraine", 1805, 15630);
        final Educational_institution knu = new Educational_institution("KNU", "Kyiv",
                "Ukraine", 1834, 20000);

        Educational_institution[] ed_inst_array = {knu, kpi, hnu};

        System.out.println("Початковий масив:");
        for (Educational_institution educational_institution : ed_inst_array) {
            System.out.printf("%d year, %d students\n", educational_institution.year, educational_institution.students);
        }

        System.out.println("Сортування за зростанням років:");

        Arrays.sort(ed_inst_array, new getYearComparator());

        for (Educational_institution educational_institution : ed_inst_array) {
            System.out.printf("%d year, %d students\n", educational_institution.year, educational_institution.students);
        }

        System.out.println("Сортування за спаданням кількості студентів:");

        Arrays.sort(ed_inst_array, new getStudentsComparator());
        for (Educational_institution educational_institution1 : ed_inst_array) {
            System.out.printf("%d year, %d students\n", educational_institution1.year, educational_institution1.students);
        }
    }
}