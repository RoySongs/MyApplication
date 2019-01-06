package com.example.a17_supportlibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity_Lab_RecycleView extends AppCompatActivity {

    int count= 0;
    List<DataVo> list;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__lab__recycle_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        list = new ArrayList<DataVo>();
        myAdapter = new MyAdapter(list);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
        recyclerView.addItemDecoration(new MyItemDecoration());

        Button button = (Button)findViewById(R.id.btn1);
        button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                count++;
                DataVo dataVo = new DataVo("Hello Number : "+ count);
                list.add(dataVo);
                myAdapter.notifyDataSetChanged(); // 변경된 데이터를 화면에 반영
                Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(list.size()), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
