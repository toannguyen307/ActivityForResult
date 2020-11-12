package com.example.calculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static int RESULT_CODE=1;
    private final static int REQUEST_CODE=100;
    private Button btnStart;
    private TextView txtResult;
    private EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult= (TextView) findViewById(R.id.text_result);
        etNumber= (EditText) findViewById(R.id.edit_number);
        btnStart= findViewById(R.id.button_plus);
        setEvent();
    }

    public void  setEvent(){
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(etNumber.getText().toString())) {
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    int number1 = Integer.parseInt(etNumber.getText().toString());
                    intent.putExtra("num", number1);
                    startActivityForResult(intent,REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE){
            if (resultCode==RESULT_CODE){
                int resultData= data.getIntExtra("result",0);
                txtResult.setText(resultData+"");
            }
        }
    }
}