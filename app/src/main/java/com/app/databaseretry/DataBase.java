package com.app.databaseretry;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Android on 20-Dec-16.
 */

public class DataBase extends SQLiteOpenHelper {


    public static final String mDatabase_Name = "StudentDB";
    public static final String mTable_Name = "StudentDetail";
    public static final String mCol1 = "Student_FirstName";
    public static final String mCol2 = "Student_LastName";
    public static final String mCol3 = "MailId";
    public static final String mCol4 = "Password";
    public static final String mCol5 = "Contact_No";
    private static final String CREATE = "create table StudentDetail (Student_FirstName varchar(20),Student_LastName varchar(20) ,MailId varchar(30) primary key,Password varchar(20), Contact_No varchar(10));";
    SQLiteDatabase sd;

    public DataBase(Context context) {

        super(context, mDatabase_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE);
        // db.execSQL("create table"+ mTable_Name+"( Student_FirstName varchar(20),Student_LastName varchar(20) ,MailId varchar(30) primary key,Password varchar(20), Contact_No varchar(10)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("Drop table if exists" + mTable_Name);
        onCreate(db);

    }


    public boolean insertData(String fName, String lName, String mailId, String password, String mobileNo) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(mCol1, fName);
        contentValues.put(mCol2, lName);
        contentValues.put(mCol3, mailId);
        contentValues.put(mCol4, password);
        contentValues.put(mCol5, mobileNo);

        long result = db.insert(mTable_Name, null, contentValues);

        if (result == -1)
            return false;

        else
            return true;


    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + mTable_Name, null);
        return res;
    }

    public boolean updateMessages(String fName, String lName, String mailId, String password, String mobileNo) {

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(mCol1, fName);
        contentValues.put(mCol2, lName);
        contentValues.put(mCol3, mailId);
        contentValues.put(mCol4, password);
        contentValues.put(mCol5, mobileNo);

        db.update(mTable_Name, contentValues, "mailId = ?", new String[]{mailId});

        return true;
    }

    public Integer deleteData(String mailId) {
        SQLiteDatabase db = this.getReadableDatabase();


        return db.delete(mTable_Name, "mailId = ?", new String[]{mailId});


    }
}
