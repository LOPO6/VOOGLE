package com.example.assignment2gc200479031;

//Program: Voogle - The video game search engine
//Programmer: Logan Potopnyk
//Original Date of completion: Decemeber 12th, 2024

import javafx.fxml.FXML;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GameDetailsViewController {
    @FXML
    private Label gameTitleLabel; //creating fxml variables

    @FXML
    private Label releaseDateLabel;

    @FXML
    private Label ratingLabel;

    @FXML
    private Label descriptionLabel; //not currently used but kept for future improvements

    @FXML
    private Label platformLabel;


    @FXML
    private ImageView backgroundImageView; // ImageView for background image

    @FXML
    private Button backButton;

    // Set the game details passed from the SceneChanger
    public void setGameDetails(GameDetail gameDetail) {
        //Gets all the values from the api request and sets them to variables, using special formats for some
        gameTitleLabel.setText(gameDetail.getName()); //getting the name
        String released = gameDetail.getReleased(); //getting the release date with formatting
        if (released != null && !released.isEmpty()) {
            try {
                // Parse the original date string into a Date object
                SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = originalFormat.parse(released);

                // Format it into a different format, e.g., "dd MMM yyyy"
                SimpleDateFormat targetFormat = new SimpleDateFormat("dd MMM yyyy");
                String formattedDate = targetFormat.format(date);

                // Set the formatted release date to the label
                releaseDateLabel.setText("Release Date: " + formattedDate);
            } catch (ParseException e) {
                e.printStackTrace();
                releaseDateLabel.setText("Release Date: Invalid Date");
            }
        } else {
            releaseDateLabel.setText("Release Date: Not Available");
        }
        // Set a placeholder or modify later if you want to add release date
        ratingLabel.setText("Rating: " + gameDetail.getRating()); //setting up the rating

        if (gameDetail.getPlatforms() != null && !gameDetail.getPlatforms().isEmpty()) { //setting up all the platforms and putting them into a list
            StringBuilder platforms = new StringBuilder();
            for (Platform platform : gameDetail.getPlatforms()) {
                platforms.append(platform.getName()).append(", ");
            }
            platformLabel.setText("Platforms: " + platforms.substring(0, platforms.length() - 2));  // Remove the last comma
        } else {
            platformLabel.setText("Platforms: Not Available");
        }

        // Handle background image if it exists
        String imageUrl = gameDetail.getBackgroundImage(); //setting up the image
        if(imageUrl !=null && !imageUrl.isEmpty()){
            Image image = new Image(imageUrl);
            backgroundImageView.setImage(image);
        }
    }
    // Initialize the back button to return to the search screen
    @FXML
    private void initialize() { //function for the back button
        // Set an action for the back button
        backButton.setOnAction(event -> {
            try {
                SceneChanger.changeScenes(event, "search-game-view.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}




