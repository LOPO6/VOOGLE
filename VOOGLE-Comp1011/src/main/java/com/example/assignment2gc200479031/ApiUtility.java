package com.example.assignment2gc200479031;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

//Program: Voogle - The video game search engine
//Programmer: Logan Potopnyk
//Original Date of completion: Decemeber 12th, 2024

public class ApiUtility {
    // Method to search for games and return a list of GameDetail objects
    public static ArrayList<GameDetail> searchGames(String gameTitle) { //function to search for games
        ArrayList<GameDetail> gameDetails = new ArrayList<>();
        try {
            // URL-encode the user input (game title)
            String encodedGameTitle = URLEncoder.encode(gameTitle, StandardCharsets.UTF_8.toString());

            // Construct the URL with the encoded game title
            String url = "https://api.rawg.io/api/games?key=6122a7542803471f8c8ea69698c270e0&search=" + encodedGameTitle;

            // Send the HTTP request using the constructed URL
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the JSON response body
            String responseBody = response.body();
            System.out.println("Response: " + responseBody); // Debugging output

            // Use Gson to parse the JSON response
            Gson gson = new Gson();
            ApiResponse apiResponse = gson.fromJson(responseBody, ApiResponse.class);

            // Add the list of games to the gameDetails list
            if (apiResponse != null && apiResponse.getResults() != null) {
                gameDetails.addAll(apiResponse.getResults());
            }

        } catch (UnsupportedEncodingException e) { //exception handling
            e.printStackTrace();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return gameDetails; //return the game details
    }

}
