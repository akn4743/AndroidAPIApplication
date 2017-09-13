package com.example.adamn.userstatisticsapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.adamn.userstatisticsapplication.Models.User;

/**
 * This class is responsible for creating a databse in SQLite
 * and stores data relating to emails and passwords of accounts.
 *
 *
 * @author Adam Nowak
 */

public class DBHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "info.db";
    public static final String TABLE_USER = "user";
    public static final String COLUMN_ID = "column_id";
    public static final String COLUMN_EMAIL = "column_email";
    public static final String COLUMN_PASSWORD = "column_password";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_USER + "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_EMAIL + " TEXT,"
                + COLUMN_PASSWORD + " TEXT" + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public void addUser(User user){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASSWORD,user.getPassword());
        db.insert(TABLE_USER,null,values);
        db.close();
    }
    public boolean checkUser(String email){
        String[] columns = {COLUMN_ID};
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_EMAIL + "= ?";
        String[] selectionArgs = { email };
        Cursor c = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cCount = c.getCount();
        c.close();
        db.close();
        if(cCount > 0){
            return true;
        }
        return false;
    }
    public boolean checkUser(String email, String password){
        String[] columns = {
                COLUMN_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = COLUMN_EMAIL + "= ?" + " AND " + COLUMN_PASSWORD + "= ?";
        String[] selectionArgs = { email, password };
        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0){
            return true;
        }
        return false;
    }
}
