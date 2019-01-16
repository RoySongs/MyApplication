package com.example.practice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Lab18_3Activity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, View.OnClickListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    ViewPager viewPager;
    CoordinatorLayout cooriLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab18_3);

        drawerLayout = (DrawerLayout)findViewById(R.id.test3_drawerLayout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.drawer_open,R.string.drawer_close);
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.test3_navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        });

        cooriLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        viewPager = (ViewPager)findViewById(R.id.test3_relative_viewpager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout)findViewById(R.id.test3_relative_tab);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(this);

        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.floatingBtn);
        fab.setOnClickListener(this);
        /*coordinatorLayout=(CoordinatorLayout)findViewById(R.id.coordinatorLayout);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lab3, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments = new ArrayList<Fragment>();
        private String titles[] = new String[]{"TAB1", "TAB2", "TAB3"};
        public MyPagerAdapter(FragmentManager fm){
            super(fm);
            fragments.add(new OneFragment());
            fragments.add(new TwoFragment());
            fragments.add(new ThreeFragment());
        }

        @Override
        public Fragment getItem(int position){
            return this.fragments.get(position);
        }
        @Override
        public int getCount(){
            return this.fragments.size();
        }
        @Override
        public CharSequence getPageTitle(int position){
            return titles[position];
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu){

        int menuId = menu.getItemId();
        if(menuId == R.id.menu_drawer_add){
            showToast("add클릭");
        } else if (menuId == R.id.menu_drawer_home){
            showToast("홈클릭");
        } else {
            showToast("기타 클릭");
        }
        return false;

    }

    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(cooriLayout, "I am SnackBar", Snackbar.LENGTH_LONG)
                .setAction("MoreAtion", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //.......................
                    }
                })
                .show();
    }
}

