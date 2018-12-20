package com.example.part4_12;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        // Set whether to include the application home affordance in the action bar.
        actionBar.setDisplayShowHomeEnabled(true);
        // Set whether home should be displayed as an "up" affordance.
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setIcon(R.drawable.icon);
    }
    // HOME_AS_UP 이라고 업계에서 쓰이는건지...
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home){
            Toast t = Toast.makeText(this, "HOME AS UP Click", Toast.LENGTH_SHORT);
            t.show();
            return true;
        }
/*
        if(item.getItemId()==0){
            Toast t = Toast.makeText(this, "0입니다.", Toast.LENGTH_LONG);
            return true;
        } else if(item.getItemId()==1){
            Toast t = Toast.makeText(this, "1입니다.", Toast.LENGTH_LONG);
        }
*/

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // 아래 2줄은 오버플로우 아이콘쪽
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        /*if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }*/


        MenuItem menuItem=menu.findItem(R.id.searchInfo);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint(getResources().getString(R.string.query_hint));
        searchView.setOnQueryTextListener(queryTextListener);

        /*MenuItem item1 = menu.add(0,0,0, "슬라이드쇼");
        MenuItem item2 = menu.add(0,1,0,"앨범에 추가");
        */
        return true;
    }


    private SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener(){
        @Override
        public boolean onQueryTextSubmit(String query){

            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText){
            return false;
        }
    };
}
