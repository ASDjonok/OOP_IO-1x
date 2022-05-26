package io12._14_Iliov.Lab4;

import java.util.Random;

class Ship {
    protected String name;
    protected int speed;
    protected int lenght;
    protected int carrying_capacity;
    protected int age;
    private String [] ships_names = {"Niniya", "Pinta", "Santa Mariya", "Millenium Falcon", "Bismarc", "Titanic",
            "Miss Love Duck", "Big Top", "Besan Black", "Going Merry", "Thousand Sunny", "Dreadnought Saber",
            "Coffin boat", "Cooking Georg", "Shark Superb", "Great Eirik", "Blinking", "Utan Sonar", "Victory Hunter",
            "Red Force", "Mobydick", "New Witch Language", "Foxy", "Thriller Bark"};

    public Ship() {
        Random random = new Random();
        this.name = ships_names[random.nextInt(24)];
        this.speed = random.nextInt(150);;
        this.lenght = random.nextInt(300);;
        this.carrying_capacity = random.nextInt(1000);;
        this.age = random.nextInt(40);
    }
}
