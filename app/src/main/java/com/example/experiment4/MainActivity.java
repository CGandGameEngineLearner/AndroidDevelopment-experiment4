package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    protected Button[] mButtons=new Button[4];


    protected void initButtons()
    {

        mButtons[0]=findViewById(R.id.button_0);
        mButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentConsult = new Intent(MainActivity.this,AppStoreActivity.class);
                startActivity(intentConsult);
                Log.d("MainActivity","AppStoreActivity");
            }
        });

        mButtons[1]=findViewById(R.id.button_1);
        mButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(MainActivity.this,com.example.experiment4.HomeActivity.class);
                startActivity(intentHome);
                Log.d("MainActivity","HomeActivity");
            }
            });



        }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
    }
}
