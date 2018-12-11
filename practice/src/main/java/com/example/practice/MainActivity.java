package com.example.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnValue1, btnValue2, btnValue3, btnValue4;
    TextView txtView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnValue1 = (Button)findViewById(R.id.btn1);
        btnValue2 = (Button)findViewById(R.id.btn2);
        btnValue3 = (Button)findViewById(R.id.btn3);
        btnValue4 = (Button)findViewById(R.id.btn4);
        txtView1 = (TextView)findViewById(R.id.invisibleL);



        btnValue1.setOnClickListener(this);
        btnValue2.setOnClickListener(this);
        btnValue3.setOnClickListener(this);
        btnValue4.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        if(btnValue1 == v){
            txtView1.setVisibility(View.VISIBLE);
        } else if(btnValue2 == v){
            txtView1.setVisibility(View.INVISIBLE);
        } else if(btnValue3 == v){
            txtView1.setVisibility(View.GONE);
        } else if(btnValue4 == v){
            Intent intent = new Intent(this, ActivityLab1.class);
            startActivity(intent);
        }
    }

}
