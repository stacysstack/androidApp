package com.example.csci5115_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_confirmorder extends AppCompatActivity {

    Button confirmorder;
    Button cancelorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmorder);

        String popName=getIntent().getStringExtra("POP_NAME");
        String popRest= getIntent().getStringExtra("REST_NAME");
        String popPrice= getIntent().getStringExtra("ORDER_PRICE");


        TextView orderName = (TextView) findViewById(R.id.order_name);
        orderName.setText(popName);

        TextView orderRest = (TextView) findViewById(R.id.order_restaurant);
        orderRest.setText(popRest);

        TextView orderPrice = (TextView) findViewById(R.id.order_price);
        orderPrice.setText(popPrice);

        //save button
        confirmorder = (Button) findViewById(R.id.confirmorder);
        confirmorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
                Intent intent = new Intent (activity_confirmorder.this, PurchaseHistoryPage.class);
                startActivity(intent);

            }
        });
        //end button

        //save button
        cancelorder = (Button) findViewById(R.id.cancelorder);
        cancelorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //end button

    }
}
