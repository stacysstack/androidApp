package com.example.csci5115_project;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

public class Accounts_Page extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    CreditCardAdapter adapter;
    public AlertDialog alert;

    public Context mCtx;

    //a list to store all the products
    public List<CreditCard> cardList;

    //the recyclerview
    RecyclerView recyclerView;

    Button gotonewcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //add new credit card button
        gotonewcc = (Button) findViewById(R.id.addnewcc);
        gotonewcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent makecc = new Intent(getApplicationContext(), AddNewCreditCard.class);
                startActivity(makecc);
            }
        });
        //end button


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        //initializing the productlist
        cardList = new ArrayList<>();


        //adding some items to our list
        cardList.add(
                new CreditCard(0,
                        "My American Express",
                        "John Doe",
                        "000000",
                        333,
                        "1/21",
                        52345,
                        R.drawable.amex));

        cardList.add(
                new CreditCard(1,
                        "REI Discover",
                        "John Doe",
                        "00000000",
                        333,
                        "5/19",
                        52345,
                        R.drawable.discover));

        cardList.add(
                new CreditCard(2,
                        "Bank Card",
                        "John Doe",
                        "0000000",
                        523,
                        "01/23",
                        62345,
                        R.drawable.usbank));

        //creating recyclerview adapter
//        CreditCardAdapter adapter = new CreditCardAdapter(this, cardList);
/// for popup

        //setting adapter to recyclerview
//        recyclerView.setAdapter(adapter);

        adapter = new CreditCardAdapter(this, cardList, new CustomItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {
                Integer postId = cardList.get(position).getCardId();
                Log.d(postId.toString(), "changing cards");
                String passed= "this is new";
//                if (postId == 0){
                    Intent intent = new Intent(Accounts_Page.this, activity_popupcard.class);
                    intent.putExtra("EXTRA_SESSION_ID", passed);
                    startActivity(intent);
//                } else if (postId == 1){
//                    Intent intent1 = new Intent(Accounts_Page.this, activity_popupcard.class);
//                    startActivity(intent1);
//                } else if (postId == 2){
//                    Intent intent2 = new Intent(Accounts_Page.this, activity_popupcard.class);
//                    startActivity(intent2);
//                }
//            mCtx = this.getApplicationContext();
//            LayoutInflater inflater = LayoutInflater.from(mCtx.this);
//            View alertLayout = inflater.inflate(R.layout.popupwindow, null);
//            AlertDialog alertDialog = new AlertDialog.Builder(mCtx).create();
//            alertDialog.setView(alertLayout);
//
//            new Dialog(mCtx);
//            alertDialog.show();
            }

        });

        //end popup

//
//        //setting adapter to recyclerview
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
        getMenuInflater().inflate(R.menu.account_page, menu);
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
            Intent startNewActivity = new Intent(this, PurchaseHistoryPage.class);
            startActivity(startNewActivity);

        } else if (id == R.id.nav_share) {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }

        } else if (id == R.id.nav_send) {
            Intent startNewActivity = new Intent(this, Login.class);
            startActivity(startNewActivity);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}