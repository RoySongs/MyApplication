package com.example.practice2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    FragmentManager fm;
    OneFragment oneFragment;
    TwoFragment twoFragment;
    ThreeFragment threeFragment;
    Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        selectFragment(oneFragment);

    }

    @Override
    public void onClick(View v) {
        Log.d("test","들어왔쥬");
        if(v == btn1 && !oneFragment.isVisible()){
            showToast("1번");
            selectFragment(oneFragment);
        } else if(v == btn2 && !twoFragment.isVisible()){
            showToast("2번");
            selectFragment(twoFragment);
        } else {
            showToast("3번");
            selectFragment(threeFragment);
        }
    }



    public void selectFragment(Fragment fragment){
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.main_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
