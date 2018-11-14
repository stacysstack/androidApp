package com.example.csci5115_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.santalu.widget.MaskEditText;

public class AddNewCreditCard extends AppCompatActivity {
    private MaskEditText editText;

    Button cancelcc;
    Button savecc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_credit_card);

        editText = findViewById(R.id.edit_card_name);
        editText = findViewById(R.id.edit_card_number);
        editText = findViewById(R.id.edit_expiration_date);
        editText = findViewById(R.id.edit_cvv);
        editText = findViewById(R.id.edit_zipcode);
        editText = findViewById(R.id.edit_name);






        //cancel new card button
        cancelcc = (Button)findViewById(R.id.cancelcc);
        cancelcc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent cancelcc = new Intent(getApplicationContext(), Accounts_Page.class);
                startActivity(cancelcc);
            }
        });
        //end button

        //save new card button
        savecc = (Button)findViewById(R.id.savecc);
        savecc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent savecc = new Intent(getApplicationContext(), Accounts_Page.class);
                startActivity(savecc);
            }
        });
        //end button



    }

    public void showText(View v){
        Toast.makeText(this,editText.getText(), Toast.LENGTH_SHORT).show();
    }

    public void showRawText(View v){
        Toast.makeText(this,editText.getRawText(), Toast.LENGTH_SHORT).show();

    }



}
