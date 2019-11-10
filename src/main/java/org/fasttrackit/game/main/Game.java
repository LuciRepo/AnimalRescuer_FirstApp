package org.fasttrackit.game.main;

import org.fasttrackit.game.persistence.AnimalRepository;
import org.fasttrackit.game.pojo.*;
import org.fasttrackit.game.pojo.FoodForAnimals;
import org.fasttrackit.game.service.AnimalService;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private String nameOfTheGame;
    private int hungerLevel = 10;
    private int moodLevel = 0;
    String chosenName;

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public int getMoodLevel() {
        return moodLevel;
    }

    public void setMoodLevel(int moodLevel) {
        this.moodLevel = moodLevel;
    }

    public String getNameOfTheGame() {
        return nameOfTheGame;
    }

    public void setNameOfTheGame(String nameOfTheGame) {
        this.nameOfTheGame = nameOfTheGame;
    }

    public Game() {
    }

    public Game(String nameOfTheGame) {
        this.nameOfTheGame = nameOfTheGame;
    }

    private void initAnimal() {
        System.out.println("Choose your pet");
        Scanner in = new Scanner(System.in);
        String chosenPet = in.nextLine();
        if (chosenPet.equalsIgnoreCase("Cat")) {
            Animal cat = new Cats(1, 1);
        } else {
            if (chosenPet.equalsIgnoreCase("Bird")) {
                Animal bird = new Birds(1, 1);
            } else {
                if (chosenPet.equalsIgnoreCase("Dog")) {
                    Animal dog = new Dogs(1, 1);
                } else {
                    System.out.println("Rechoose your pet");
                    initAnimal();
                }
            }
        }
    }

    private void initAdopter() {
        System.out.println("Set adopter's first and last name");
        Scanner in = new Scanner(System.in);
        try {
            String firstName = in.nextLine();
            String lastName = in.nextLine();
            Adopter adopter = new Adopter(firstName, lastName, 23, "Masculin", "Student");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void nameAnimal() throws SQLException {
        System.out.println("Give your pet a name");
        Random random = new Random();
        boolean isName = false;
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        this.chosenName=name;
     //   AnimalService as = new AnimalService();
        AnimalRepository ar = new AnimalRepository();
        ArrayList<Animal> animalCreated = ar.getAnimal();
        for (Animal checkAnimal : animalCreated) {
            if (name.equals(checkAnimal.getName())) {
                System.out.println(checkAnimal.getId() + " " + checkAnimal.getName() + " " + checkAnimal.getAge() + " " + checkAnimal.getHealthLevel() + " " + checkAnimal.getHungerLevel() + " " + checkAnimal.getMoodLevel() + " " + checkAnimal.getWeight() + " " + checkAnimal.getColour());
                isName = true;
            }
        }
        if (isName == false) {
           ar.createAnimal(new Animal(random.nextInt(1000), name, 2, 3, 4, 2, 3, "Red"));
        }
    }
    private  void updateStatus() throws SQLException{
        AnimalRepository ar = new AnimalRepository();
        ArrayList<Animal> animalCreated = ar.getAnimal();
        for (Animal checkAnimal : animalCreated){
            if(chosenName.equalsIgnoreCase(checkAnimal.getName())){
                checkAnimal.setHungerLevel(0);
                checkAnimal.setMoodLevel(10);
                ar.updateAnimal(checkAnimal);
            }
        }

    }


    private void initFood() {
        ArrayList<FoodForAnimals> avalilableFood = new ArrayList<FoodForAnimals>();
        FoodForAnimals foodOne = new FoodForAnimals("Milk", 4, 3);
        FoodForAnimals foodTwo = new FoodForAnimals("Seeds", 5, 2);
        FoodForAnimals foodThree = new FoodForAnimals("Meat", 5, 5);
        FoodForAnimals foodFour = new FoodForAnimals("Bread", 10, 3);
        avalilableFood.add(0, foodOne);
        avalilableFood.add(1, foodTwo);
        avalilableFood.add(2, foodThree);
        avalilableFood.add(3, foodFour);

        for (FoodForAnimals f : avalilableFood) {
            System.out.println("The available types of food are: " + f.getName());
        }
    }

    private void initLeisure() {
        ArrayList<LeisureActivities> availableLeisure = new ArrayList<LeisureActivities>();
        LeisureActivities leisureOne = new LeisureActivities("Roll", 2, 4);
        LeisureActivities leisureTwo = new LeisureActivities("Pet", 4, 5);
        LeisureActivities leisureThree = new LeisureActivities("Sing", 2, 7);
        LeisureActivities leisureFour = new LeisureActivities("Jump", 4, 3);
        availableLeisure.add(0, leisureOne);
        availableLeisure.add(1, leisureTwo);
        availableLeisure.add(2, leisureThree);
        availableLeisure.add(3, leisureFour);
        for (LeisureActivities l : availableLeisure) {
            System.out.println("The available types of leisure activities are : " + l.getActivityName());
        }
    }

    private void requireFeeding() {
        System.out.println("Feed your pet");
        showAvailableFood();
        Adopter adopter = new Adopter();
        adopter.feedPet();
    }

    private void requireLeisure() {
        System.out.println("Play with your pet");
        showAvailableActivities();
        Adopter adopter = new Adopter();
        adopter.playPet();
    }

    private void showAvailableFood() {
        initFood();
    }

    private void showAvailableActivities() {
        initLeisure();
    }

    public void start() throws SQLException {
        initAnimal();
        initAdopter();
        nameAnimal();
        while ((hungerLevel > 0) || (moodLevel < 10)) {
            requireFeeding();
            hungerLevel = hungerLevel - 2;
            requireLeisure();
            moodLevel = moodLevel + 2;
        }
        if ((moodLevel == 10) || (hungerLevel == 0)) {
            System.out.println("Congratulation! You are a carring Adopter");
            System.out.println(moodLevel+" "+hungerLevel);
            updateStatus();
        }

    }


}

