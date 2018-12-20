package com.example.practice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    Context context;

    public MyView(Context context){
        super(context);
    }

    public MyView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.context=context;

        if(attrs != null){
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyView);
            color=a.getColor(R.styleable.MyView_customColor, Color.RED);
        }
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

}
