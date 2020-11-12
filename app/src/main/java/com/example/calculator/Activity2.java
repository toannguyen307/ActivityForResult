package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private final static int RESULT_CODE=1;

    private TextView txtResult;
    private Button btnBack;
    private int number1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtResult = findViewById(R.id.text_result);
        btnBack= findViewById(R.id.button_back);
        getData();
        setEvent();
    }

    public void getData(){
        Bundle bundle= getIntent().getExtras();
        if(bundle!=null) {
            number1 = bundle.getInt("num");
            txtResult.setText(number1 + "");
        }
    }

    public void setEvent(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1+=9;
                Intent intent= new Intent();
                intent.putExtra("result",number1);
                setResult(RESULT_CODE,intent);
                finish();
            }
        });
    }
}