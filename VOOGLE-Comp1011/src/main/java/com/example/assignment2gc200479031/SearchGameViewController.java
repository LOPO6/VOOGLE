package com.example.assignment2gc200479031;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

//Program: Voogle - The video game search engine
//Programmer: Logan Potopnyk
//Original Date of completion: Decemeber 12th, 2024


public class SearchGameViewController {
    @FXML
    private Button getDetailButton;

    @FXML
    private Label msgLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<GameDetail> resultListView;


    @FXML
    private void searchGames(ActionEvent event) { //function to search for games
        String gameTitle = searchTextField.getText().trim();

        // Validate input
        if (gameTitle.isEmpty()) {
            msgLabel.setText("Please enter a game title.");
            return;
        }

        // Call ApiUtility.searchGames to fetch the game results
        List<GameDetail> gameDetails = ApiUtility.searchGames(gameTitle);

        // Update the result ListView with the game details
        if (!gameDetails.isEmpty()) {
            resultListView.getItems().setAll(gameDetails);
            msgLabel.setText("Found " + gameDetails.size() + " games!");
        } else {
            msgLabel.setText("No games found.");
        }
    }

    @FXML
    public void initialize() {
        getDetailButton.setVisible(false);
        msgLabel.setText("");
        // Use a custom cell factory to display only the game names in the ListView
        resultListView.setCellFactory(param -> new ListCell<GameDetail>() {
            @Override
            protected void updateItem(GameDetail gameDetail, boolean empty) {
                super.updateItem(gameDetail, empty);
                if (empty || gameDetail == null) {
                    setText(null);
                } else {
                    setText(gameDetail.getName());  // Display the game name only
                }
            }
        });

        // Show the details button if an option is selected
        resultListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldGameSelected, newGameSelected) -> {
                    getDetailButton.setVisible(true);
                });
    }


    //Method to handle the button click and change to the game details view.

    @FXML
    private void getDetails(ActionEvent event) throws IOException { //function to change scene and get details if button is hit
        GameDetail gameDetail = resultListView.getSelectionModel().getSelectedItem();
        if (gameDetail != null) {

            SceneChanger.changeScenes(event, "game-details-view.fxml", gameDetail);
        }
    }
}

