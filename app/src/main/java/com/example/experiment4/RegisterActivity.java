package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {


    protected Button mButtonRegister;

    private void init() {
        mButtonRegister=findViewById(R.id.btn_register);
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(RegisterActivity.this,RegisterSuccActivity.class);
                startActivity(intentRegister);
                Log.d("RegisterActivity","RegisterSuccActivity");
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }
}