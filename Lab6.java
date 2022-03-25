import java.util.Arrays;

public class Lab6 {
    public static void main(String[] args) {
        /*C13 = 1314 % 13 = 1 => Ієрархія цукерок та інших солодощів. Створити кілька об'єктів-цукерок. Зібрати дитячий
        подарунок з визначенням його ваги. Провести сортування цукерок у подарунку за одним із параметрів. Знайти
        цукерку в подарунку, що відповідає заданому діапазону вмісту шоколаду в цукерці.*/
        //Створюємо масив об'єктів-солодощів
        Sweet[] present = {
                new ChocolateBar("Lion", 35.5, 80),
                new Jelly("DinDon ", 0, 250),
                new ChocolateBar("Bounty", 20, 120),
                new Chocolate("Korona", 73, 100),
                new ChocolateCandies("Terry's Milk", 90, 200),
                new ChocolateCandies("Terry's Milk", 100, 200),
                new Chocolate("Milka", 82, 300),
                new LolliPop("Zubi", 0, 250)
        };
        //Рахуємо його повну масу, виводимо її та весь масив
        System.out.println("Present consist of:");
        int mass = 0;
        for (Sweet candy : present) {
            candy.showInfo();
            mass += candy.getMass();
        }
        System.out.printf("Total mass: %d\n", mass);
        //Сортуємо масив за зростанням маси, виводимо результат
        int[] masses = new int[present.length];
        for (int i = 0; i < present.length; i++) {
            masses[i] = present[i].getMass();
        }
        Arrays.sort(masses);
        Sweet[] sortedByMass = new Sweet[present.length];
        int j = 0;
        while (j < present.length) {
            for (Sweet sweet : present) {
                if (j < present.length && masses[j] == sweet.getMass()) {
                    sortedByMass[j] = sweet;
                    j++;
                }
            }
        }
        System.out.println("Sorted present by mass: ");
        for (Sweet candy : sortedByMass) {
            candy.showInfo();
        }
        // Знаходимо перший об'єкт, що входить у заданий діапазон за часткою шоколаду, виводимо його(або іноформуємо про
        // відсутність такого у списку)
        double[] range = {25, 40};
        Sweet lookingCandy = null;
        for (Sweet sweet : present) {
            if (sweet.getChocolatePercent() >= range[0] && sweet.getChocolatePercent() <= range[1]) {
                lookingCandy = sweet;
                break;
            }
        }
        if (lookingCandy == null) {
            System.out.println("There is not any candy with this percent of chocolate");
        } else {
            System.out.printf("%s by %s with percent of chocolate %.2f is in range [%.2f, %.2f]", lookingCandy.getType()
                    , lookingCandy.getDistributor(), lookingCandy.getChocolatePercent(), range[0], range[1]);
        }
    }
}
//Super-клас Sweet
class Sweet {
    private double chocolatePercent;
    private int mass;
    private String distributor;
    private String type;

    Sweet(String distributor, double percent, int mass) {
        this.setDistributor(distributor);
        this.setChocolatePercent(percent);
        this.setMass(mass);
    }

    public double getChocolatePercent() {
        return chocolatePercent;
    }

    public void setChocolatePercent(double chocolatePercent) {
        this.chocolatePercent = chocolatePercent;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void showInfo() {
        System.out.printf(" %s by %s. Chocolate percent: %.2f%%. Mass: %d\n", this.getType(), this.getDistributor(),
                this.getChocolatePercent(), this.getMass());
    }
}

//П'ять класів-нащадків
class Chocolate extends Sweet {
    Chocolate(String distributor, double chocolatePercent, int mass) {
        super(distributor, chocolatePercent, mass);
        super.setType("Chocolate");
    }
}

class LolliPop extends Sweet {
    LolliPop(String distributor, double chocolatePercent, int mass) {
        super(distributor, chocolatePercent, mass);
        super.setType("Lolli-Pop");
    }
}

class ChocolateBar extends Sweet {
    ChocolateBar(String distributor, double chocolatePercent, int mass) {
        super(distributor, chocolatePercent, mass);
        super.setType("Chocolate Bar");
    }
}

class Jelly extends Sweet {
    Jelly(String distributor, double chocolatePercent, int mass) {
        super(distributor, chocolatePercent, mass);
        super.setType("Jelly candy");
    }
}

class ChocolateCandies extends Sweet {
    ChocolateCandies(String distributor, double chocolatePercent, int mass) {
        super(distributor, chocolatePercent, mass);
        super.setType("ChocolateCandies");
    }
}