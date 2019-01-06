package com.example.a17_supportlibrary;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class TwoFragment extends ListFragment {

    ArrayList<String> list;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, list);
        setListAdapter(aa);
    }

    public void setArguments(ArrayList<String> arrayList) {
        this.list = arrayList;
    }
}
