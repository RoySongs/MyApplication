package com.example.a17_supportlibrary;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    List<DataVo> totalList;
    int cnt;
    public MyAdapter(List<DataVo> list){
        this.totalList = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int idx){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity__lab__recycle_view_row, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position){
        String textList = totalList.get(position).getMainText();
        viewHolder.mainBtn.setText(textList);
        viewHolder.textView.setText(textList);
    }

    @Override
    public int getItemCount(){
        cnt = totalList.size();
        return totalList.size();
    }

    public int getMess(){
        return cnt;
    }

}
