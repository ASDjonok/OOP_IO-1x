package Lab4;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Crew> memberList = new ArrayList<>();
        CrewWriter getting = new CrewWriter();

        memberList.add(getting.write("Антон", "Капітан", "Чорний лицар", 28, 10));
        memberList.add(getting.write("Даниїл", "Боцман", "Пахан", 2, 0));
        memberList.add(getting.write("Іван", "Кок", "Шпала", 1, 5));
        memberList.add(getting.write("Константин", "Матрос", "Дудка", 5, 2));

        Ship shipDivision = new Ship();
        for (Crew crewmmbr : memberList) {
            shipDivision.addCrew(crewmmbr);
        }

        shipDivision.bunkSort();
        System.out.println("Відсортуємо за номером ліжка по зростанню:\n\n" + shipDivision.getInfo());

        shipDivision.yearSort();
        System.out.println("\nВідсортуємо за тривалості служби по спаданню:\n\n" + shipDivision.getInfo());
    }
}
