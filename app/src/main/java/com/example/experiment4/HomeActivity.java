package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    protected Button[] mButtons=new Button[2];

    protected void initButtons() {

        mButtons[0]=findViewById(R.id.btn_login);

        mButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intentHome);
                Log.d("HomeActivity","LoginActivity");
            }
        });

        mButtons[1]=findViewById(R.id.btn_register);
        mButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(HomeActivity.this,RegisterActivity.class);
                startActivity(intentHome);
                Log.d("MainActivity","RegisterActivity");
            }
        });


    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initButtons();
    }
}