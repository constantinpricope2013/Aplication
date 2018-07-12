package com.example.pricopeconstantin.aplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;

public class DAO{// implements Runnable{
    public static SQLiteDatabase mDatabase;
    public static DatabaseHelper mDbHelper;
    public Cursor cursor= null;
    private Context mContext;
    private String TAG="DAO";
    Context context;
    String numeleTabelului;
    ContentValues values;
    String [] mAllColumns;
    String ID;
    int insert;



    public DAO(Context context,String numeleTabelului, ContentValues values, String [] mAllColumns,String ID,int insert ){
        mDbHelper = new DatabaseHelper(context);
        this.mContext = context;
        // open the database
        try {

            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException on openning database " + e.getMessage());
            e.printStackTrace();
        }

        this.context=context;
        this.numeleTabelului =numeleTabelului;
        this.values = values;
        this.mAllColumns = mAllColumns;
        this.ID=ID;
        this.insert = insert;

            try {
                if (insert == 1) {
                    long insertId = mDatabase.insert(numeleTabelului, null, values);
                    this.cursor = mDatabase.query(numeleTabelului, mAllColumns,
                            ID + " = " + insertId, null, null,
                            null, null);
                } else {
                    this.cursor = mDatabase.query(numeleTabelului, mAllColumns, 
                            null, null, null,
                            null, null);
                }
            } catch (Exception e) {
                Log.e(TAG, "Baza de date nu se poate accesa");
            }


        Log.e(TAG,"ERROR");

    }
    public void open() throws SQLException {
        //mDbHelper.onUpgrade(mDatabase,1,2);
        mDatabase = mDbHelper.getWritableDatabase();

    }
    public void close() {
        mDbHelper.close();
    }

    public Cursor getCursor() {

        return this.cursor;
    }

//    @Override
//    public void run() {
//
//    }
}
