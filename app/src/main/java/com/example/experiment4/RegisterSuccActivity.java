package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class RegisterSuccActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_succ);
        Toast toast=Toast.makeText(getApplicationContext(), "注册成功！", Toast.LENGTH_SHORT);
        toast.show();
    }
}