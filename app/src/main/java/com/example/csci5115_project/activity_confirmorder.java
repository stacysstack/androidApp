package com.example.csci5115_project;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Handler;

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

//        AlertDialog.Builder mAlertDialogBuilder = new AlertDialog.Builder(this);
//        LayoutInflater inflater = this.getLayoutInflater();
//        // inflate the custom dialog view
//        final View mDialogView = inflater.inflate(R.layout.dialog_layout, null);
//        // set the View for the AlertDialog
//        mAlertDialogBuilder.setView(mDialogView);

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
                View view = getWindow().getDecorView().getRootView();
////                finish();
                String sentmsg = "Your order has been sent";
                int duration = Snackbar.LENGTH_SHORT;
                showSnackbar(view, sentmsg, duration);
                final Intent next = new Intent(activity_confirmorder.this,PurchaseHistoryPage.class);

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(next);
                        finish();
                    }
                }, 1000);
            }

            public void showSnackbar(View view, String message, int duration) {
                Snackbar.make(view, message, duration).show();
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
