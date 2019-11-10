package org.fasttrackit.game.pojo;

public class Cats extends Animal {
    private String race;

    public Cats(int id,String name, int age, int healthLevel, int hungerLevel, int moodLevel, double weight, String colour) {
        super(id,name, age, healthLevel, hungerLevel, moodLevel, weight, colour);
        this.race = race;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Cats(int id,String name, int age, int healthLevel, int hungerLevel, int moodLevel, double weight, String colour, String race) {
        super(id,name, age, healthLevel, hungerLevel, moodLevel, weight, colour);
        this.race = race;
    }

    public Cats(String name) {
    }

    public Cats(int hungerLevel, int healthLevel) {

    }

    public Cats() {
    }
}
