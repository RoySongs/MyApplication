package com.example.practice2;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


// ViewHolder 정의가 끝나면 Viewholder를 내부적으로 이용하는 Adapter를 하나 만들어줘야 한다.
// 항목 개수 판단을 위한 getItemCount()함수와 각 항목을 구성하기 위한 onBindViewHolder()함수를 가지는 건 동일한데,
// 각 항목을 구성하기 위한 레이아웃 XML 파일을 inflat하는 역할의 함수가 분리되어 있는 차이점이 있다.
// 아래 코드에서 onCreateViewHolder()함수가 레이아웃 XML파일의 inflate를 담당하는 함수이다.

// inflate된 뷰 계층구조의 root 객체를 ViewHolder의 생성자로 넘겨 ViewHolder에서 각 뷰 객체를 findViewById하게 되며
// 이렇게 만들어진 ViewHolder 객체를 onCreateViewHolder()함수에서 반환하면 내부적으로 메모리에 유지했다가 onBindViewHolder()호출 시 매개변수로 전달하는 구조
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<String> list;

    public MyAdapter(List<String> list){
        this.list = list;
    };

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(android.R.layout.simple_list_item_1, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position){
        String text = list.get(position);
        viewHolder.title.setText(text);

    }

    @Override
    public int getItemCount(){
        return list.size();
    }

}
