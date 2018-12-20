package com.example.part4_11_1;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;

public class Lab11_3Activity extends AppCompatActivity {

    ProgressBar stickBar;
    SeekBar seekBar;
    Spinner spinner;
    AutoCompleteTextView auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab11_3);

        spinner = (Spinner)findViewById(R.id.spinner);
        String[] datas = getResources().getStringArray(R.array.spinner_array);
        ArrayAdapter<String> arrAdp = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, datas);
        spinner.setAdapter(arrAdp);

        auto = (AutoCompleteTextView)findViewById(R.id.auto);
        String[] datas2 = getResources().getStringArray(R.array.auto_array);
        ArrayAdapter<String> arrAda = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, datas2);
        auto.setAdapter(arrAda);

        stickBar=(ProgressBar)findViewById(R.id.stickBar);
        ProgressThread thread = new ProgressThread();
        thread.run();

    }

    class ProgressThread{

        public void run(){

            for(int i=0; i<10;i++){
                SystemClock.sleep(1000);
                stickBar.incrementProgressBy(10);
                stickBar.incrementSecondaryProgressBy(15);
            }
        }
    }

}
