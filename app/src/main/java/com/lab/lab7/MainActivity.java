package com.lab.lab7;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button popupBtn, contextBtn;
    private TextView titleTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popupBtn = findViewById(R.id.popupBtn);
        contextBtn = findViewById(R.id.contextBtn);
        titleTv =  findViewById(R.id.titleTv);

        registerForContextMenu(contextBtn);

        popupBtn.setOnClickListener(v->{
            PopupMenu popup = new PopupMenu(MainActivity.this, v);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
            popup.show();

            popup.setOnMenuItemClickListener(item->{
                switch (item.getItemId()){
                    case R.id.save:
                        displayText("SAVE");
                        return true;
                    case R.id.update:
                        displayText("UPDATE");
                        return true;
                    case R.id.delete:
                        displayText("DELETE");
                        return true;
                    default:
                        displayText("error");
                        return false;
                }
            });

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                displayText("SETTINGS");
                return true;
            case R.id.theme:
                displayText("THEME");
                return true;
            case R.id.privacyPolicy:
                displayText("PRIVACY POLICY");
                return true;
            case R.id.logout:
                displayText("LOGOUT");
                return true;
            default:
                displayText("error");
                return false;
        }

    }

    private void displayText(String msg) {
        titleTv.setText(msg);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.alert:
                showAlert();
                return true;
            case R.id.custom:
                showCustom();
                return true;
            default:
                displayText("error");
                return false;
        }
    }

    private void showCustom() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Addition");
        builder.setCancelable(true);

        View view = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null);
        builder.setView(view);
        builder.setNegativeButton("EXIT", (dialog, where)-> dialog.cancel());

        EditText num1 = view.findViewById(R.id.num1);
        EditText num2 = view.findViewById(R.id.num2);
        Button addBtn = view.findViewById(R.id.addBtn);
        TextView resultTv = view.findViewById(R.id.resultTv);

        addBtn.setOnClickListener(v->{
            Double number1 = Double.parseDouble(num1.getText().toString());
            Double number2 = Double.parseDouble(num2.getText().toString());

            Double result = number1+number2;

            resultTv.setText(String.valueOf(result));

        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showAlert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert");
        builder.setMessage("This is alert message!");
        builder.setCancelable(true);
        builder.setNegativeButton("EXIT", (dialog, where)-> dialog.cancel());

        AlertDialog dialog = builder.create();
        dialog.show();

    }




}
