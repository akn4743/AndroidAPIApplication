package com.example.adamn.userstatisticsapplication.Models;

/**
 *This object class creates a Weather Object which is used to fill the
 * list view in the WundergroundActivity.
 *
 * @author Adam Nowak
 */

public class WeatherObject {
    private String name;
    private String description;
    private String weatherimage;

    public WeatherObject(String name,String description ,String weatherimage) {
        this.name = name;
        this.description = description;
       this.weatherimage = weatherimage;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getWeatherimage() {
        return weatherimage;
    }

}
