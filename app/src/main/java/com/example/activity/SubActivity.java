package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class SubActivity extends AppCompatActivity {

    private int num1;
    private int num2;
    private int result;
    private String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView textNum1 = (TextView) findViewById(R.id.textNum1);
        TextView textNum2 = (TextView) findViewById(R.id.textNum2);

        Intent intent = getIntent();
        num1 = intent.getIntExtra("num1", -1);
        num2 = intent.getIntExtra("num2", -1);
        if (num1 != -1 && num2 != -1) {
            textNum1.setText(String.format(Locale.KOREAN, "숫자1: %d", num1));
            textNum2.setText(String.format(Locale.KOREAN, "숫자2: %d", num2));
        }
        op = intent.getStringExtra("op");
        if(op.equals("+"))
            result = num1 + num2;
        else if(op.equals("-"))
            result = num1 - num2;
        else if(op.equals("*"))
            result = num1 * num2;
        else if(op.equals("/"))
            result = num1 / num2;
    }

    public void mOnClick(View v) {
        Intent data = new Intent();
        data.putExtra("result", result);
        setResult(RESULT_OK, data);
        finish();
    }
}
