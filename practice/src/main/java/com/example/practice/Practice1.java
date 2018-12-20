package com.example.practice;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Practice1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice1);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.alpha(Color.CYAN));

        RectF rect = new RectF(15, 15, 160, 160);
        Paint paint = new Paint();
        MyView myView = new MyView(rect, color);
        paint.setColor(color);
        canvas.drawArc(rect, 0, 360, false, paint);
    }
}
