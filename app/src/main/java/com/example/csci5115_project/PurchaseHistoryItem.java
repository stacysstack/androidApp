package com.example.csci5115_project;

public class PurchaseHistoryItem {
    private int id;
    private String account, date, order, price, restaurantName, total;

    public PurchaseHistoryItem(int id, String account, String date, String order, String price, String restaurantName) {
        this.id = id;
        this.account = "Account number: " + account;
        this.date = date;
        this.order = order;
        this.price = price;
        this.restaurantName = restaurantName;
        this.total = "Total: " + price;
    }

    public int getId() {
        return id;
    }

    public String getAccount() { return account; }

    public String getDate() {
        return date;
    }

    public String getOrder() {
        return order;
    }

    public String getPrice() { return price; }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getTotal() { return total; }

}
