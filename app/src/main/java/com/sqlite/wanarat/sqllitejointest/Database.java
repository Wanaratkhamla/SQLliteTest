package com.sqlite.wanarat.sqllitejointest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

class MyDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "BTS";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Product";
    public static final String COL_NAME = "name";
    public static final String COL_PIECE_PRICE = "pieceprice";
    public static final String COL_CAKE_PRICE = "cakeprice";

    public MyDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, " + COL_PIECE_PRICE + " INTEGER, "
                + COL_CAKE_PRICE + " INTEGER);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Chocolate Fudge', 95, 750);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Banana Choc Cake', 55, 500);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Banoffee', 75, 700);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Cheese Cake', 85, 800);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Tiramisu', 85, 800);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Tiramisua', 85, 800);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Tiramisub', 85, 800);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Tiramisuc', 85, 800);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Tiramisud', 85, 800);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Tiramisue', 85, 800);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Tiramisuf', 85, 800);");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COL_NAME + ", " + COL_PIECE_PRICE
                + ", " + COL_CAKE_PRICE + ") VALUES ('Tiramisug', 85, 800);");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public ArrayList<HashMap<String, String>> SelectAllData() {
        try {
            ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            SQLiteDatabase db;
            db = this.getReadableDatabase();

            String strSQL = "SELECT * FROM " + TABLE_NAME;
            Cursor cursor = db.rawQuery(strSQL, null);

            if (cursor != null) {
                if (cursor.moveToFirst()){
                    do {
                        map = new HashMap<String, String>();
                        map.put(COL_NAME, cursor.getString(0));
                        map.put(COL_PIECE_PRICE, cursor.getString(1));
                        map.put(COL_CAKE_PRICE, cursor.getString(2));
                        MyArrList.add(map);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MyArrList;
        } catch (Exception e) {
            return null;
        }
    }
}
public class Database {

}
