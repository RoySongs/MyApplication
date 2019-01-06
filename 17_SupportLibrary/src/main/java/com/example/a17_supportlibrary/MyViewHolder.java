package com.example.a17_supportlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    Button mainBtn;

    public MyViewHolder(View view){
        super(view);
        textView = (TextView) view.findViewById(R.id.mainText);
        mainBtn = (Button) view.findViewById(R.id.mainBtn);
    }
}
