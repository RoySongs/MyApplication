package com.example.a17_supportlibrary;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class OneFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    public List<DataVo> list;
    Button btn11;
    MyAdapter myAdr;
    int count=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity__lab__recycle_view, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.myRecyclerView);

        recyclerView.setHasFixedSize(true);
        list = new ArrayList<>();
        myAdr = new MyAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(myAdr);


        /*btn11.setOnClickListener(this);*/
        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

/*
    @Override
    public void onClick(View view){
        count++;
        DataVo dataVo = new DataVo("Hello Number : "+ count);
        list.add(dataVo);
        myAdr.notifyDataSetChanged(); // 변경된 데이터를 화면에 반영
    }*/
}
