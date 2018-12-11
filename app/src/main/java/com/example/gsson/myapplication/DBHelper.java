package com.example.gsson.myapplication;

import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public DBHelper(Context context){
        super(context, "memodb", null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String memoSQL = "create table tb_memo " +
                "(_id integer primary key autoincrement,"+
                "title,"+
                "content)";
        db.exeSQL(memoSQL);
    }
    public void onUpgrade(SQLiteDatabase db, int )
}


