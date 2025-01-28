package com.example.assignment2gc200479031;

import com.google.gson.annotations.SerializedName;

public class Platform { //class for the platforms, complete with a name variable, getter, setters and functions
    @SerializedName("platform")
    private PlatformDetails platformDetails;

    public String getName() {
        return platformDetails != null ? platformDetails.getName() : "Unknown";
    }

    public static class PlatformDetails {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
