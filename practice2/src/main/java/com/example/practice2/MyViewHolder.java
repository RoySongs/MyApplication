package com.example.practice2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

//ViewHolder 정의
//RecyclerView에 Adapter뷰를 적용해야 한다. 그런데 RecyclerView는 Adapter에 ViewHolder의 적용이 강제되어 있다.
// 따라서 ViewHolder 클래스를 먼저 정의해야 한다.
// ViewHolder의 역할은 항목을 구성하기 위해 뷰들을 findViewById 해주는 역할을 한다.ViewHolder 객체를 Adapter 내부에서 메모리에
// 유지해줌으로써 ViewHolder에 의해 최초 한 번만 findViewByid 하기 위해서이다.

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public MyViewHolder(View view){
        super(view);
        title = (TextView) view.findViewById(android.R.id.text5);
    }
}
