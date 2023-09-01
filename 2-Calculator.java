package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class
MainActivity extends AppCompatActivity {
    Button b1, b2, bplus, beql;
    EditText ET_Result;
    Float v1, v2;
    Boolean add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button)findViewById(R.id.btn_one);
        b2 = (Button) findViewById(R.id.btn_two);
        bplus = (Button) findViewById(R.id.btn_plus);
        beql = (Button) findViewById(R.id.btn_eql);
        ET_Result = (EditText) findViewById(R.id.ET_Result);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ET_Result.setText(ET_Result.getText()+"1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                ET_Result.setText(ET_Result.getText()+"2");
            }
        });
        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    v1 = Float.parseFloat(ET_Result.getText()+"");
                    add = true;
                    ET_Result.setText(null);

            }
        });
        beql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v2 = Float.parseFloat(String.valueOf(ET_Result.getText()));
                if (add) {
                    ET_Result.setText(v1+v2+"");
                    add = false;
                }
            }
        });
    }
}
