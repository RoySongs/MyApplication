package com.example.part3_8_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText titleView;
    EditText contentView;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleView = (EditText) findViewById(R.id.add_title);
        contentView = (EditText) findViewById(R.id.add_content);
        addBtn = (Button) findViewById(R.id.add_btn);
        SharedPreferences sharedPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("data1", "Hello");
        editor.putInt("data2",100);
        editor.commit();
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        String title = titleView.getText().toString();
        String content = contentView.getText().toString();

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("insert into tb_memo (title, content) values(?,?)", new String[]{title, content});
        db.close();

        Intent intent = new Intent(this, ReadDBActivity.class);
        startActivity(intent);

    }

}
