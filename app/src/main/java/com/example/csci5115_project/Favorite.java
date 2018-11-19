package com.example.csci5115_project;

public class Favorite {
    private int id;
    private String name;
    private String restaurant;
    private int image;
    private String price;

    public Favorite(int id, String name, String restaurant, int image, String price) {
        this.id = id;
        this.name = name;
        this.restaurant = restaurant;
        this.image = image;
        this.price = price;
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

    public String getPrice() { return price; }

}
