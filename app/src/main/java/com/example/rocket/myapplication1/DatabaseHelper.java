package com.example.rocket.myapplication1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rocket on 7/4/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String database_name ="sign_up.db";
    public static final String table_name ="user";
    public static final String col_1 ="full_name";
    public static final String col_2 ="email";
    public static final String col_3 ="password";


    public DatabaseHelper(Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(full_name text,email text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }

    public boolean insert(String col_1, String col_2, String col_3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name", col_1);
        contentValues.put("email", col_2);
        contentValues.put("password", col_3);
        long ins = db.insert("user", null, contentValues);
        if (ins == -1) return false;
        else return true;


    }

    //checks if mail already exists
    public boolean chkemail(String col_2) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?", new String[]{col_2});
        if (cursor.getCount() > 0) return false;
        else {
            return true;
        }
    }

    public boolean passchk(String col_3) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where password=?", new String[]{col_3});
        if (cursor.getCount() > 0) return false;
        else {
            return true;
        }

    }
}