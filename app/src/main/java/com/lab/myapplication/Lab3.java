package com.lab.myapplication;

import static android.view.View.VISIBLE;
import static android.widget.Toast.LENGTH_LONG;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;



public class Lab3 extends AppCompatActivity {

    private ImageView signupIv;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab3);

        loginBtn = findViewById(R.id.loginBtn);
        signupIv = findViewById(R.id.signupIv);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupIv.setVisibility(VISIBLE);
            }
        });

        loginBtn.setOnLongClickListener(v -> {
            Toast.makeText(Lab3.this,"Login button is pressed for long!!",LENGTH_LONG)
                    .show();
            return false;
        });

    }
}