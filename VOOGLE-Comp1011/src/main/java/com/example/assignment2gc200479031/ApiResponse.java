package com.example.assignment2gc200479031;

//Program: Voogle - The video game search engine
//Programmer: Logan Potopnyk
//Original Date of completion: Decemeber 12th, 2024

import java.util.List;

public class ApiResponse {
    private List<GameDetail> results; //declaring results to show on the info screen

    public List<GameDetail> getResults() {
        return results;
    } //getter and setter for variable

    public void setResults(List<GameDetail> results) {
        this.results = results;
    }
}
