package com.example.assignment2gc200479031;

import java.util.List;

//Program: Voogle - The video game search engine
//Programmer: Logan Potopnyk
//Original Date of completion: Decemeber 12th, 2024


public class Game {
    private String id; //variables for all the games things
    private String name;
    private String released;
    private String backgroundImage;
    private GameDetail details;

    public String getId() { //getters and setters for everything
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public GameDetail getDetails() {
        return details;
    }

    @Override
    public String toString(){
        return String.format("%s (%s)", name, released);
    }
}
