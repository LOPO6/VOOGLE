package com.example.assignment2gc200479031;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    // Updated changeScenes method to pass GameDetail instead of gameId
    public static void changeScenes(ActionEvent event, String fxmlFile, GameDetail gameDetail) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        // Get the controller and pass the GameDetail object
        GameDetailsViewController controller = fxmlLoader.getController();
        controller.setGameDetails(gameDetail);  // Pass the whole GameDetail object

        // Change the scene
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Method to change scenes without passing GameDetail
    public static void changeScenes(ActionEvent event, String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
