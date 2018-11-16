package com.example.csci5115_project;

public class Favorite {
    private int id;
    private String name;
    private String restaurant;
    private int image;

    public Favorite(int id, String name, String restaurant, int image) {
        this.id = id;
        this.name = name;
        this.restaurant = restaurant;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public int getImage() {
        return image;
    }
}
