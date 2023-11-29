package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    protected Button mButtonLogin;

    private void init() {
        mButtonLogin=findViewById(R.id.btn_login);
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(LoginActivity.this,LoginSuccActivity.class);
                startActivity(intentLogin);
                Log.d("LoginActivity","LoginSuccActivity");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
}