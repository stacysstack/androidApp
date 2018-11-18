package com.example.csci5115_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.santalu.widget.MaskEditText;

public class activity_popupcard extends AppCompatActivity {
    private MaskEditText editText;
    EditText cardname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupcard);
        String sessionId= getIntent().getStringExtra("EXTRA_SESSION_ID");

        editText = findViewById(R.id.edit_card_name);

    }

    public void showText(View v){
        Toast.makeText(this,editText.getText(), Toast.LENGTH_SHORT).show();
    }
}
