package com.example.csci5115_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PurchaseHistoryPage extends AppCompatActivity {

    //a list to store all the products
    List<PurchaseHistoryItem> phList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);

        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the phList
        phList = new ArrayList<>();


        //adding some items to our list
        phList.add(
                new PurchaseHistoryItem(
                        1,
                        "Pizza Co.",
                        "11-01-2018",
                        "12.12",
                        "1 Large Pizza",
                        "************1234"));

        phList.add(
                new PurchaseHistoryItem(
                        2,
                        "Taco Palace",
                        "11-02-2018",
                        "8.01",
                        "6 Tacos",
                        "************9876"));

        phList.add(
                new PurchaseHistoryItem(
                        3,
                        "Big Burgerz",
                        "11-04-2018",
                        "100.11",
                        "100 Burgerz",
                        "************1467"));

        //creating recyclerview adapter
        PurchaseHistoryAdapter adapter = new PurchaseHistoryAdapter(this, phList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}
