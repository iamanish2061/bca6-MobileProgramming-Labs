package com.lab.lab5passingacts;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Spinner foodNameSpn;
    private TextView statusTv, totalTv;
    private EditText quantityEt;

    private Button orderBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodNameSpn = findViewById(R.id.foodNameSpn);
        quantityEt = findViewById(R.id.quantityEt);
        orderBtn = findViewById(R.id.orderBtn);
        statusTv = findViewById(R.id.statusTv);
        totalTv = findViewById(R.id.totalTv);

        orderBtn.setOnClickListener(v->{
            Intent i = new Intent(MainActivity.this, ChildActivity.class);
            i.putExtra("Name", foodNameSpn.getSelectedItem().toString());
            i.putExtra("Quantity", quantityEt.getText().toString());

            startActivityForResult(i,20);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NonNull ComponentCaller caller) {
        if (requestCode == 20 && resultCode == RESULT_OK) {

            String status = data.getStringExtra("status");
            String totalPrice = data.getStringExtra("totalPrice");

            statusTv.setText(status);
            totalTv.setText(totalPrice);
        }
    }
}