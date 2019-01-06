package com.example.a17_supportlibrary;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1,btn2,btn3;
    OneFragment oneFragment;
    TwoFragment twoFragment;
    ThirdFragment thirdFragment;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("서울");
        arrayList.add("대전");
        arrayList.add("대구");
        arrayList.add("부산");
        arrayList.add("찍고");


        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        twoFragment.setArguments(arrayList);
        thirdFragment = new ThirdFragment();

        fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.addToBackStack(null);
        ft.add(R.id.containerBox, oneFragment);
        ft.commit();
    }

    @Override
    public void onClick(View v) {
        if(v == btn1){
            if(!oneFragment.isVisible()){
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.add(R.id.containerBox, oneFragment);
                ft.commit();
            }
        } else if(v == btn2){
            if(!twoFragment.isVisible()){
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.addToBackStack(null);
                ft.add(R.id.containerBox, twoFragment);
                ft.commit();
            }
        } else if(v == btn3){
            if(!thirdFragment.isVisible()){
                thirdFragment.show(fragmentManager, null);
            }
        }
    }
}
