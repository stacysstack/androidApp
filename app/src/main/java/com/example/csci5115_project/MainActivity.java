package com.example.csci5115_project;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<Favorite> favoriteList = new ArrayList<>();
    RecyclerView recyclerView;
    public static boolean new_flag = false;
    FavoriteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewFavorites);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        favoriteList.add(
                new Favorite(
                        1,
                        "Cheese Pizza",
                        "Pizza Co.",
                        R.drawable.pizza));
        favoriteList.add(
                new Favorite(
                        1,
                        "Beef Taco",
                        "Twin Cities Taco",
                        R.drawable.taco));
        favoriteList.add(
                new Favorite(
                        1,
                        "Cheeseburger (No Mustard)",
                        "Dinkytown Burgerz",
                        R.drawable.taco));
        favoriteList.add(
                new Favorite(
                        1,
                        "Meatlovers' Pizza",
                        "Pizza Co.",
                        R.drawable.pizza));


        adapter = new FavoriteAdapter(this,favoriteList,new CustomItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {
//                Log.d("create popup for item");
                String orderName = favoriteList.get(position).getName();
                String restName = favoriteList.get(position).getRestaurant();

                Intent intent = new Intent (MainActivity.this, activity_confirmorder.class);
                intent.putExtra("POP_NAME", orderName);
                intent.putExtra("REST_NAME", restName);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);


//        FavoriteAdapter adapter = new FavoriteAdapter(this, favoriteList);
//        recyclerView.setAdapter(adapter);
    }
    

    @Override
    public void onResume() {
        if(new_flag) {
            favoriteList.add(
                    new Favorite(
                            1,
                            "Bean Burrito",
                            "Twin Cities Taco",
                            R.drawable.taco));
            FavoriteAdapter adapter = new FavoriteAdapter(this, favoriteList, new CustomItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {
                    String orderName = favoriteList.get(position).getName();
                    String restName = favoriteList.get(position).getRestaurant();

                    Intent intent = new Intent (MainActivity.this, activity_confirmorder.class);
                    intent.putExtra("POP_NAME", orderName);
                    intent.putExtra("REST_NAME", restName);
                    startActivity(intent);
                }
            });
            recyclerView.setAdapter(adapter);
            new_flag = false;
        }
        super.onResume();
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
        getMenuInflater().inflate(R.menu.main, menu);
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
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
        } else if (id == R.id.nav_gallery) {
            Intent startNewActivity = new Intent(this, Restaurant_Page.class);
            startActivity(startNewActivity);
        } else if (id == R.id.nav_slideshow) {
            Intent startNewActivity = new Intent(this, PurchaseHistoryPage.class);
            startActivity(startNewActivity);
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

    /* Doesn't work */
//    public boolean onFavoriteSelected(CardView item) {
//        int id = item.getId();
    /* Navigation to incorrect location - for testing purposes */
//        if (id == R.id.pizzaCardViewId) {
//            Intent startNewActivity = new Intent(this, Restaurant_Page.class);
//            startActivity(startNewActivity);
//        } else if (id == R.id.burgersCardViewId) {
//            Intent startNewActivity = new Intent(this, Restaurant_Page.class);
//            startActivity(startNewActivity);
//        } else if (id == R.id.tacoCardViewId) {
//            Intent startNewActivity = new Intent(this, Restaurant_Page.class);
//            startActivity(startNewActivity);
//        } else if (id == R.id.meatPizzaCardViewId) {
//            Intent startNewActivity = new Intent(this, Restaurant_Page.class);
//            startActivity(startNewActivity);
//       }
//        return true;
//    }

}
