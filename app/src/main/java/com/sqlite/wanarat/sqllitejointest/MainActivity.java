package com.sqlite.wanarat.sqllitejointest;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {
    SQLiteDatabase mDb;
    MyDbHelper mHelper;
    Cursor mCursor;
    public static final String COL_NAME = "name";
    public static final String COL_PIECE_PRICE = "pieceprice";
    public static final String COL_CAKE_PRICE = "cakeprice";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        ArrayList<HashMap<String, String>> cakelist;
        MyDbHelper myDB = new MyDbHelper(this);
        myDB.getWritableDatabase();
        ListView listView1 = (ListView) findViewById(R.id.listView1);
        cakelist = myDB.SelectAllData();
        SimpleAdapter simAdap;
        simAdap = new SimpleAdapter(getApplicationContext(), cakelist, R.layout.layout_detail,
                new String[]{COL_NAME, COL_PIECE_PRICE, COL_CAKE_PRICE}, new int[]{R.id.col_name, R.id.col_price, R.id.col_price_cake});
        listView1.setAdapter(simAdap);
    }

    public void onPause() {
        super.onPause();
        mHelper.close();
        mDb.close();

    }


}