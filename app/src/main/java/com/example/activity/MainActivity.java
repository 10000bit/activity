package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditNum1;
    private EditText mEditNum2;
    private RadioGroup radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditNum1 = (EditText) findViewById(R.id.editText);
        mEditNum2 = (EditText) findViewById(R.id.editText2);
        radio = (RadioGroup) findViewById(R.id.radioGroup);
    }

    public void mOnClick(View v) {
        Intent intent = new Intent(this, SubActivity.class);
        intent.putExtra("num1", Integer.parseInt(mEditNum1.getText().toString()));
        intent.putExtra("num2", Integer.parseInt(mEditNum2.getText().toString()));

        switch (radio.getCheckedRadioButtonId()) {
            case R.id.radioSum:
                intent.putExtra("op", "+");  break;
            case R.id.radioSub:
                intent.putExtra("op", "-");  break;
            case R.id.radioMul:
                intent.putExtra("op", "*");  break;
            case R.id.radioDiv:
                intent.putExtra("op", "/");  break;
        }
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK) {
            int result = data.getIntExtra("result", 0);
            Toast.makeText(this, "두 숫자의 결과: " + result, Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
