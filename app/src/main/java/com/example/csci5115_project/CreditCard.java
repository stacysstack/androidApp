package com.example.csci5115_project;

public class CreditCard {
    private String title;
    private String owner;
    private String cardnumber;
    private int cvv;
    private String expiration;
    private int zip;
    private int image;


    public CreditCard(String title, String owner, String cardnumber,int cvv, String expiration, int zip, int image){
        this.title = title;
        this.owner = owner;
        this.cardnumber = cardnumber;
        this.expiration = expiration;
        this.zip = zip;
        this.image = image;
    }

    public String getTitle(){ return title; }

    public String getOwner(){ return owner; }

    public String getCardnumber() { return cardnumber; }

    public int getCvv(){ return cvv; }

    public String getExpiration(){ return expiration; }

    public int getZip(){ return zip; }

    public int getImage(){ return image; }


}
