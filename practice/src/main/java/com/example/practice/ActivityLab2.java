package com.example.practice;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

public class ActivityLab2 extends AppCompatActivity {

    Spinner spinner;
    AutoCompleteTextView editText;
    ProgressBar stickProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);

        spinner = (Spinner)findViewById(R.id.spinner);
        editText = (AutoCompleteTextView) findViewById(R.id.editText);

        String[] datas = {"한국어", "영어"};
        ArrayAdapter<String> arrAda = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, datas);
        arrAda.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(arrAda);


        String[] datas2 = {"한국어","영어","일본어"};
        ArrayAdapter<String> arrAda2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,datas2);
        editText.setAdapter(arrAda2);

        stickProgress = (ProgressBar)findViewById(R.id.stickProgress);
        ProgressThread proThr = new ProgressThread();
        proThr.run();
    }

    class ProgressThread extends Thread {

        @Override
        public void run(){
            for(int i=0; i<10; i++){
                SystemClock.sleep(1000);
                stickProgress.incrementProgressBy(10);
            }
        }
    }

}
