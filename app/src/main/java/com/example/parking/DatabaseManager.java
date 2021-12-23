package com.example.parking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLDataException;

public class DatabaseManager {
    private DatabaseHelper databaseHelper;
    private Context context;
    private SQLiteDatabase database;

    public DatabaseManager(Context ctx){
        this.context = ctx;
    }

    public DatabaseManager open() throws SQLDataException {
        databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
        return this;
    }

    public void close()
    {
        databaseHelper.close();
    }


    public Cursor fetchParking(){
        String [] columns = new String[] {DatabaseHelper.USER_ID,
                DatabaseHelper.USER_FULLNAME,
                DatabaseHelper.USER_USERNAME,
                DatabaseHelper.USER_EMAIL,
                DatabaseHelper.USER_PASSWORD};

        Cursor cursor = database.query(DatabaseHelper.TABLE_USER,columns,null,null,null,null,null);
        if(cursor != null)
        {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public boolean insertUser(String fullname, String username, String email, String password){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.USER_FULLNAME,fullname);
        cv.put(DatabaseHelper.USER_USERNAME,username);
        cv.put(DatabaseHelper.USER_PASSWORD,password);
        cv.put(DatabaseHelper.USER_EMAIL,email);

        long result = database.insert(DatabaseHelper.TABLE_USER,null,cv);
        return result != -1;
    }

    public boolean updatetUser(String id,String fullname, String username, String email, String password){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.USER_FULLNAME,fullname);
        cv.put(DatabaseHelper.USER_USERNAME,username);
        cv.put(DatabaseHelper.USER_PASSWORD,password);
        cv.put(DatabaseHelper.USER_EMAIL,email);

        long result = database.update(DatabaseHelper.TABLE_USER,cv,DatabaseHelper.USER_ID + "=" + id,null);
        return result != -1;
    }

    public boolean deleteUser(String id){
        try {
            database.delete(DatabaseHelper.TABLE_USER,DatabaseHelper.USER_ID + "=" + id,null);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public Cursor getUserByUsernameAndPassword(String username, String password)
    {
        return database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_USER + " WHERE " +  DatabaseHelper.USER_USERNAME + " = ? AND " + DatabaseHelper.USER_PASSWORD + " = ?", new String[] {username,password});
    }

    public Cursor getOneUser(String id){
        return database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_USER + " WHERE " +   DatabaseHelper.USER_ID + " = ?" , new String[] {id});
    }

    public Cursor getALLUser(){
        return database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_USER,null);
    }






    public Cursor fetchUser(){
        String [] columns = new String[] {DatabaseHelper.PARKING_ID,
                DatabaseHelper.PARKING_NAME,
                DatabaseHelper.PARKING_ZONE};

        Cursor cursor = database.query(DatabaseHelper.TABLE_PARKING,columns,null,null,null,null,null);
        if(cursor != null)
        {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public boolean insertParking(String name, String zone){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.PARKING_NAME,name);
        cv.put(DatabaseHelper.PARKING_ZONE,zone);


        long result = database.insert(DatabaseHelper.TABLE_PARKING,null,cv);
        return result != -1;
    }

    public boolean updateParking(String id,String name, String zone){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.PARKING_NAME,name);
        cv.put(DatabaseHelper.PARKING_ZONE,zone);

        long result = database.update(DatabaseHelper.TABLE_PARKING,cv,DatabaseHelper.PARKING_ID + "=" + id,null);
        return result != -1;
    }

    public boolean deleteParking(String id){
        try {
            database.delete(DatabaseHelper.TABLE_PARKING,DatabaseHelper.PARKING_ID + "=" + id,null);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }


    public Cursor getOneParking(String id){
        return database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_PARKING + " WHERE " +  DatabaseHelper.PARKING_ID + " = ?" , new String[] {id});
    }

    public Cursor getAllParking(){
        return database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_PARKING,null);

    }

}
