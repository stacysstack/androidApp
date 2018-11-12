package com.example.csci5115_project;

public class PurchaseHistoryItem {
    private int id;
    private String restaurantName;
    private String date;
    private String price;
    private String order;
    private String cc;

    public PurchaseHistoryItem(int id, String restaurantName, String date, String price, String order, String cc) {
        this.id = id;
        this.restaurantName = restaurantName;
        this.date = date;
        this.price = price;
        this.order = order;
        this.cc = cc;
    }

    public int getId() {
        return id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getDate() {
        return date;
    }

    public String getPrice() { return price; }

    public String getOrder() { return order; }

    public String getCC() { return cc; }
}
