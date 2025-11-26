package com.lab.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView answerTv, inputTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTv = findViewById(R.id.queryTv);
        answerTv = findViewById(R.id.resultTv);

        assignId(R.id.btnOpenP);
        assignId(R.id.btnCloseP);
        assignId(R.id.btnClr);

        assignId(R.id.btn1);
        assignId(R.id.btn2);
        assignId(R.id.btn3);
        assignId(R.id.btnPlus);

        assignId(R.id.btn4);
        assignId(R.id.btn5);
        assignId(R.id.btn6);
        assignId(R.id.btnMinus);

        assignId(R.id.btn7);
        assignId(R.id.btn8);
        assignId(R.id.btn9);
        assignId(R.id.btnMultiply);

        assignId(R.id.btnSqrt);
        assignId(R.id.btn0);
        assignId(R.id.btnDivide);
        assignId(R.id.btnEquals);
    }

    void assignId(int id) {
        MaterialButton btn = findViewById(id);
        btn.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String result = inputTv.getText().toString();

        if (buttonText.equals("C")) {
            inputTv.setText("");
            answerTv.setText("0");
            return;
        } else if (buttonText.equals("=")) {
            String finalResult = getResult(result);
            answerTv.setText(finalResult);
            return;
        } else if(buttonText.equals("S")){
            buttonText = "Math.sqrt(";
        }

        result+=buttonText;

        inputTv.setText(result);
    }

    String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            return context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
        } catch (Exception e) {
            return "Err";
        }
    }
}
