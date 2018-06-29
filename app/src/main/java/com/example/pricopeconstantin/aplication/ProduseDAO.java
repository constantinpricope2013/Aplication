package com.example.pricopeconstantin.aplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;

/**
 * Created by Pricope Constantin on 6/27/2018.
 */

public class ProduseDAO {

    public static final String TAG = "EmployeeDAO";
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private DatabaseHelper mDbHelper;
    private String[] mAllColumns  = { DatabaseHelper.COLUMN_ID_PRODUS,
            DatabaseHelper.COLUMN_NUME_PRODUS,
            DatabaseHelper.COLUMN_CATEGORIE_PRODUS,
            };

    public ProduseDAO(Context context) {
        mDbHelper = new DatabaseHelper(context);
        this.mContext = context;
        // open the database
        try {
            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException on openning database " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public Produse adaugareProdus(String numeProdus, String categorie) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NUME_PRODUS, numeProdus);
        values.put(DatabaseHelper.COLUMN_CATEGORIE_PRODUS, categorie);

        long insertId = mDatabase.insert(DatabaseHelper.TABLE_PRODUS, null, values);
        Cursor cursor = mDatabase.query(DatabaseHelper.TABLE_PRODUS, mAllColumns,
                DatabaseHelper.COLUMN_ID_PRODUS + " = " + insertId, null, null,
                null, null);
        cursor.moveToFirst();
        Produse newProdus = cursorToProdus(cursor);
        cursor.close();
        return newProdus;
    }

    public Produse cursorToProdus(Cursor cursor) {
       Produse produs = new Produse();
        produs.setID(cursor.getLong(0));
        produs.setNumeProdus(cursor.getString(1));
        produs.setCategorieProdus(cursor.getString(2));


        return produs;
    }

}
