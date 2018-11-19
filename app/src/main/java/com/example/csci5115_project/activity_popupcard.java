package com.example.csci5115_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.santalu.widget.MaskEditText;

public class activity_popupcard extends AppCompatActivity {
    private MaskEditText editText;
    EditText cardname;

    Button savecc;
    Button cancelcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupcard);
        String poptitle= getIntent().getStringExtra("POP_UP_TITLE");
        String popowner = getIntent().getStringExtra("POP_UP_OWNER");
        String popnumber = getIntent().getStringExtra("POP_UP_NUMBER");


//          code to record user typing
//        final EditText text1 = (EditText) findViewById(R.id.text1);
//        final EditText text2 = (EditText) findViewById(R.id.text2);
//        final EditText text3 = (EditText) findViewById(R.id.text3);
//
//        text2.addTextChangedListener(new TextWatcher() {
//            void afterTextChanged(Editable s) {
//                text3.setText(text1.getText().toString() + text2.getText().toString());
//            };
//        });
//        editText = findViewById(R.id.edit_card_name);
        EditText nameedit = (EditText)findViewById(R.id.edit_card_name);
        nameedit.setText(poptitle);

        EditText ownerEdit = (EditText)findViewById(R.id.edit_card_owner);
        ownerEdit.setText(popowner);

        EditText numberEdit = (EditText)findViewById(R.id.edit_card_number);
        numberEdit.setText(popnumber);

        //save button
        savecc = (Button) findViewById(R.id.savebutton);
        savecc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //end button

        //save button
        cancelcc = (Button) findViewById(R.id.cancelbutton);
        cancelcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //end button

    }

    public void showText(View v){
        Toast.makeText(this,editText.getText(), Toast.LENGTH_SHORT).show();
    }
}
