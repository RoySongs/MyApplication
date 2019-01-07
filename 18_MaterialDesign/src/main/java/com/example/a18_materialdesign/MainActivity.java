package com.example.a18_materialdesign;

import android.os.Bundle;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    boolean bLog = false; // false : 로그아웃 상태

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu; this adds items to the action bar if it is present.
        //메뉴버튼이 처음 눌러졌을 때 실행되는 콜백메서드
        //메뉴버튼을 눌렀을 때 보여줄 menu에 대해서 정의
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d("test","onCreateOptionsMenu - 최초 메뉴키를 눌렀을 때 호출됨");
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        Log.d("test", "onPrepareOptionsMenu - 옵션메뉴가 화면에 보여질때마다 호출됨");
        if(bLog){ // 로그인 한 상태 : 로그인은 안보이게, 로그아웃은 보이게
            menu.getItem(0).setEnabled(true);
            menu.getItem(1).setEnabled(false);
        } else { // 로그아웃 한 상태 : 로그인은 보이고, 로그아웃은 안보이게
            menu.getItem(0).setEnabled(false);
            menu.getItem(1).setEnabled(true);
        }
        bLog = !bLog; // 값이 반대로 바뀜
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // 메뉴의 항목을 선택(클릭)했을 때 호출되는 콜백메서드
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a prent activity in AndroidManifest.xml.
        Log.d("test", "onOptionsItemSelected = 메뉴 항목을 클랙했을 때 호출");

        int id = item.getItemId();

        switch(id) {
            case R.id.menu_login:
                Toast.makeText(getApplicationContext(), "로그인 메뉴 클릭", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_logout:
                Toast.makeText(getApplicationContext(), "로그아웃 메뉴 클릭", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_next:
                Toast.makeText(getApplicationContext(), "다음", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
