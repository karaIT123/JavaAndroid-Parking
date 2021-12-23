package com.example.parking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "PARKING.DB";
    static final int DATABASE_VERSION = 1;

    static final String TABLE_USER = "USER";
    static final String TABLE_PARKING = "PARKING";

    static final String USER_ID = "_ID";
    static final String USER_FULLNAME = "FULLNAME";
    static final String USER_USERNAME = "USERNAME";
    static final String USER_EMAIL = "EMAIL";
    static final String USER_PASSWORD = "PASSWORD";

    static final String PARKING_ID = "_ID";
    static final String PARKING_NAME = "NAME";
    static final String PARKING_ZONE = "ZONE";

    static final String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER  +
            " ( " +
            USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            USER_FULLNAME + " TEXT NOT NULL, " +
            USER_USERNAME + " TEXT NOT NULL, " +
            USER_EMAIL + " TEXT NOT NULL, " +
            USER_PASSWORD + " TEXT NOT NULL " +
            " ); ";

    static final String CREATE_PARKING_TABLE = "CREATE TABLE " + TABLE_PARKING +
            " ( " +
            PARKING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PARKING_NAME + " TEXT NOT NULL ," +
            PARKING_ZONE + " TEXT NOT NULL " +
            " ); ";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_PARKING_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARKING);
    }
}
