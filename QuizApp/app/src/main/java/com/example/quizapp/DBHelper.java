package com.example.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public final static String dbName="Quiz.db";

    public DBHelper(Context context) {
        super(context, "Quiz.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
    myDB.execSQL("create Table users(username TEXT primary key, password TEXT,type TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop Table if exists users ");
    }
    //methode to create a new user :
    public boolean insertUser(String username , String password,String type){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("type", type);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else return true;
    }
    //methode to usernme :
    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    //methode

}
