package com.example.practice2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TwoFragment extends Fragment {
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_two_fragment, container, false);
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getChildFragmentManager());
        ViewPager viewPager = (ViewPager) v.findViewById(R.id.layout_ViewPager);
        viewPager.setAdapter(adapter);

        return v;
    }
}
