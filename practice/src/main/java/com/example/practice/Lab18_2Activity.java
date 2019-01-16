package com.example.practice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Lab18_2Activity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, View.OnClickListener  {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionToggle;
    ViewPager viewPager;
    FloatingActionButton fab;
    RelativeLayout realativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab18_2);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        drawerLayout = (DrawerLayout)findViewById(R.id.main_drawer);
        actionToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.drawer_open, R.string.drawer_close);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionToggle.syncState();
        /*drawerLayout.addDrawerListener(actionToggle);*/
        NavigationView navigationView = (NavigationView)findViewById(R.id.main_naviagtionView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int itemId = menuItem.getItemId();

                if(itemId == R.id.menu_drawer_home){
                    showToast("메뉴 홈");
                } else if(itemId == R.id.menu_drawer_message){
                    showToast("메뉴 메세지");
                } else {
                    showToast("메뉴 기타");
                }

                return false;
            }
        });

        realativeLayout=(RelativeLayout)findViewById(R.id.relative_container);
        viewPager = (ViewPager)findViewById(R.id.relative_viewpager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = (TabLayout)findViewById(R.id.relative_tab);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(this);

        fab = (FloatingActionButton)findViewById(R.id.relative_floatButton);
        fab.setOnClickListener(this);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu; this adds items to the action bar if it is present.
        //메뉴버튼이 처음 눌러졌을 때 실행되는 콜백메서드
        //메뉴버튼을 눌렀을 때 보여줄 menu에 대해서 정의
        getMenuInflater().inflate(R.menu.menu_side, menu);
        Log.d("test","onCreateOptionsMenu - 최초 메뉴키를 눌렀을 때 호출됨");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        Log.d("test","onOptionItemSelected - 아이템 클릭시 호출됨");
        if(actionToggle.onOptionsItemSelected(menuItem)){
            return false;
        }
        return super.onOptionsItemSelected(menuItem);
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
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onClick(View v) {
        Snackbar.make(realativeLayout, "I am SnackBar", Snackbar.LENGTH_LONG)
                .setAction("MoreAction", new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                    }
                }).show();
    }


    private void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
