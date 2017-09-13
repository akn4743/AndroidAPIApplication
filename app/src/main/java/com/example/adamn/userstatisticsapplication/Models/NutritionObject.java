package com.example.adamn.userstatisticsapplication.Models;


/**
 *This object class creates a Nutrition Object which is used to fill the
 * list view in the NutritionixActivity.
 *
 * @author Adam Nowak
 */

public class NutritionObject {
    private String name;
    private String brand;
    private String calories;
    private String fat;
    private String serving;

    public NutritionObject(String name, String brand, String calories, String fat, String serving) {
        this.name = name;
        this.brand = brand;
        this.calories = calories;
        this.fat = fat;
        this.serving = serving;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCalories() {
        return calories;
    }

    public String getFat() {
        return fat;
    }

    public String getServing() {
        return serving;
    }

}
