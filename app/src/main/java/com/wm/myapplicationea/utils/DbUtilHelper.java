package com.wm.myapplicationea.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbUtilHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "tutorial_db";
    public static final String DB_REGISTRATION_TABLE = "registration";

    public DbUtilHelper(Context context){
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table registration(id intgere primary key autoincrement, " + "login text, haslo text);");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    public SQLiteDatabase getWriteConnection() {
        return getWritableDatabase();
    }

    public SQLiteDatabase getReadConnection() {
        return getReadConnection();
    }
}
