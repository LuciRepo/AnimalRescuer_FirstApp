package org.fasttrackit.game.pojo;

import java.util.ArrayList;

public class FoodForAnimals {
    private String name;
    private int numberOfPortionsAvailable;
    private int changeHungerLevel;


    public String getName() {
        return name;
    }

    public int getChangeHungerLevel() {
        return changeHungerLevel;
    }

    public void setChangeHungerLevel(int changeHungerLevel) {
        this.changeHungerLevel = changeHungerLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPortionsAvailable() {
        return numberOfPortionsAvailable;
    }

    public void setNumberOfPortionsAvailable(int numberOfPortionsAvailable) {
        this.numberOfPortionsAvailable = numberOfPortionsAvailable;
    }

    public FoodForAnimals(String name, int numberOfPortionsAvailable, int   changeHungerLevel) {
        this.name = name;
        this.numberOfPortionsAvailable = numberOfPortionsAvailable;
        this.changeHungerLevel=changeHungerLevel;
    }

    public FoodForAnimals() {
    }

}
