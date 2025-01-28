package com.example.assignment2gc200479031;


//Program: Voogle - The video game search engine
//Programmer: Logan Potopnyk
//Original Date of completion: Decemeber 12th, 2024

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GameDetail {
    private String id; //establishing variables
    private String name;
    private String rating;

    private List<Platform> platforms; //list of a different class type

    private String description; // Optional if you decide to show the description later (Was not used but kept for potential later improvement)

    @SerializedName("background_image") //use to assist in extracting information
    private String backgroundImage;

    private String released;
    public String getReleased() { //getters and setters for all variables
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }


    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    // Constructor and getters/setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
