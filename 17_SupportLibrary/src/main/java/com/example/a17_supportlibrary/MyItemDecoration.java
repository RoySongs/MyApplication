package com.example.a17_supportlibrary;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MyItemDecoration extends RecyclerView.ItemDecoration {


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
        super.getItemOffsets(outRect,view,parent,state);

        int idx = parent.getChildAdapterPosition(view)+1;

        if(idx % 3 == 0)outRect.set(20,20,20,60);
        else outRect.set(20,20,20,20);

        view.setBackgroundColor(0xFFECE9E9);
        ViewCompat.setElevation(view, 20.0f);

    }

}
