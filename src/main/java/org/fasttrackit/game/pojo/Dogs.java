package org.fasttrackit.game.pojo;

public class Dogs extends Animal {
    private String race;

    public Dogs(int id,String name, int age, int healthLevel, int hungerLevel, int moodLevel, double weight, String colour, String race) {
        super(id,name, age, healthLevel, hungerLevel, moodLevel, weight, colour);
        this.race = race;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Dogs(String name) {
    }

    public Dogs(int hungerLevel, int healthLevel) {

    }

    public Dogs() {
    }
}
