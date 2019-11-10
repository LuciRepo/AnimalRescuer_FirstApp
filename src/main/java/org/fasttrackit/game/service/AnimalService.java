package org.fasttrackit.game.service;

import org.fasttrackit.game.persistence.AnimalRepository;
import org.fasttrackit.game.pojo.Animal;


import java.sql.SQLException;
import java.util.Random;

public class AnimalService {
    Random random = new Random();
   Animal animal = new Animal(random.nextInt(100), "Spyke", 2, 3, 4, 6, 3, "yellow");

    public void animalService() throws SQLException {
        AnimalRepository cru = new AnimalRepository();
        cru.createAnimal(this.animal);
        cru.getAnimal();
        cru.updateAnimal(this.animal);
    }
}
