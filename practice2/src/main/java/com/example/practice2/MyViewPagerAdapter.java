package com.example.practice2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class MyViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> listFragment;
    public MyViewPagerAdapter(FragmentManager fm){
        super(fm);
        listFragment=new ArrayList<>();
        listFragment.add(new ViewPager_OneFragment());
        listFragment.add(new ViewPager_TwoFragment());

    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public Fragment getItem(int i) {
        return listFragment.get(i);
    }
}
