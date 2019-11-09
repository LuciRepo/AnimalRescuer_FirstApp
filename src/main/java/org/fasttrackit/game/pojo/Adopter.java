package org.fasttrackit.game.pojo;

public class Adopter {
    private String firstName;
    private String lastName;
    private int age;
    private String sex;
    private String occupation;
    Animal a;
    FoodForAnimals f;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Adopter(String firstName, String lastName, int age, String sex, String occupation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.occupation = occupation;
    }

    public Adopter() {
    }

    public void feedPet() {
    }
    public void playPet(){

    }
}
