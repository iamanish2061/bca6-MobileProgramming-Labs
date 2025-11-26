package com.lab.lab5passingacts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChildActivity extends AppCompatActivity {

    private TextView orderedItemTv, orderedQtyTv, priceTv, totalPriceTv;
    private Button placeOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        String foodName = getIntent().getStringExtra("Name");
        String quantity = getIntent().getStringExtra("Quantity");
        String price;
        if(foodName.equalsIgnoreCase("pizza")){
            price = "500";
        }else{
            price="150";
        }

        Double totalPrice = Double.parseDouble(price) * Double.parseDouble(quantity);

        orderedItemTv = findViewById(R.id.orderedItemTv);
        orderedQtyTv = findViewById(R.id.orderedQtyTv);
        priceTv = findViewById(R.id.priceTv);
        totalPriceTv = findViewById(R.id.totalPriceTv);

        orderedItemTv.setText("Item: "+foodName);
        orderedQtyTv.setText("Quantity: " +quantity);
        priceTv.setText("Price: "+price);
        totalPriceTv.setText("Total: "+totalPrice.toString());

        placeOrderBtn = findViewById(R.id.placeOrderBtn);

        placeOrderBtn.setOnClickListener(v->{
            Intent resultIntent = new Intent();
            resultIntent.putExtra("status", "Status: Pending");
            resultIntent.putExtra("totalPrice", totalPrice.toString());

            setResult(RESULT_OK, resultIntent);
            finish();
        });


    }
}