package com.example.assignment2gc200479031;
//Program: Voogle - The video game search engine
//Programmer: Logan Potopnyk
//Original Date of completion: Decemeber 12th, 2024




import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

     @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search-game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("VOOGLE - The Great Videogame Search Engine");
        Image icon = new Image(getClass().getResourceAsStream("/com/example/assignment2gc200479031/controller-1827840_640_processed.webp"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}