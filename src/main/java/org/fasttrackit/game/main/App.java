package org.fasttrackit.game.main;

import org.fasttrackit.game.helper.DBHelper;
import org.fasttrackit.game.main.Game;
import org.fasttrackit.game.persistence.AnimalRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {

        Game game=new Game("Game one");
        game.start();

    }
}
