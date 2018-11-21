package com.example.csci5115_project;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class PurchaseHistoryPage extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {

    public static boolean flag_new_purchase = false;
    public static boolean flag_favorite_burger_purchase = false;

        //a list to store all the products
    List<PurchaseHistoryItem> phList;

    //the recyclerview
    RecyclerView recyclerView;

    Button reorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
                        "************1334",
                        "10-31-2018",
                        "5 Cheese Pizzas",
                        "$60.62",
                        "Pizza Co."));

        phList.add(
                new PurchaseHistoryItem(
                        1,
                        "************3478",
                        "11-01-2018",
                        "1 Large Pepperoni with extra cheese",
                        "S12.02",
                        "Pizza Co."));

        phList.add(
                new PurchaseHistoryItem(
                        1,
                        "************7774",
                        "11-11-2018",
                        "Cowboy pizza",
                        "$12.12",
                        "Pizza Co."));

        if(flag_new_purchase) {
            phList.add(
                    new PurchaseHistoryItem(
                            1,
                            "************3478",
                            "11-21-2018",
                            "Steak Taco (with chips)",
                            "$6.98",
                            "Twin Cities Taco"));
        }

        if(flag_favorite_burger_purchase) {
            phList.add(
                    new PurchaseHistoryItem(
                            1,
                            "************3478",
                            "11-21-2018",
                            "Cheeseburger (no mustard)",
                            "$8.90",
                            "Dinkytown Burgerz"));
        }

        //creating recyclerview adapter
        PurchaseHistoryAdapter adapter = new PurchaseHistoryAdapter(this, phList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.purchase_history_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent startNewActivity = new Intent(this, MainActivity.class);
            startActivity(startNewActivity);
        } else if (id == R.id.nav_gallery) {
            Intent startNewActivity = new Intent(this, Restaurant_Page.class);
            startActivity(startNewActivity);

        } else if (id == R.id.nav_slideshow) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }

        } else if (id == R.id.nav_share) {
            Intent startNewActivity = new Intent(this, Accounts_Page.class);
            startActivity(startNewActivity);
        } else if (id == R.id.nav_send) {
            Intent startNewActivity = new Intent(this, Login.class);
            startActivity(startNewActivity);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
