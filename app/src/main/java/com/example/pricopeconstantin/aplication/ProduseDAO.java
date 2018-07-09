package com.example.pricopeconstantin.aplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pricope Constantin on 6/27/2018.
 */

public class ProduseDAO {

    public static final String TAG = "EmployeeDAO";
    private Context mContext;
    private static SQLiteDatabase mDatabase;
    private DatabaseHelper mDbHelper;
    private static String[] mAllColumns  = { DatabaseHelper.COLUMN_ID_PRODUS,
            DatabaseHelper.COLUMN_NUME_PRODUS,
            DatabaseHelper.COLUMN_CATEGORIE_PRODUS,
            DatabaseHelper.COLUMN_PRET_PRODUS,
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
        //mDbHelper.onUpgrade(mDatabase,1,2);
        mDatabase = mDbHelper.getWritableDatabase();

    }
    public void close() {
        mDbHelper.close();
    }

    public Produse adaugareProdus(String numeProdus, String categorie,int pretProdus) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NUME_PRODUS, numeProdus);
        values.put(DatabaseHelper.COLUMN_CATEGORIE_PRODUS, categorie);
        values.put(DatabaseHelper.COLUMN_PRET_PRODUS, pretProdus);

        long insertId = mDatabase.insert(DatabaseHelper.TABLE_PRODUS, null, values);
        Cursor cursor = mDatabase.query(DatabaseHelper.TABLE_PRODUS, mAllColumns,
                DatabaseHelper.COLUMN_ID_PRODUS + " = " + insertId, null, null,
                null, null);
        cursor.moveToFirst();
        Produse newProdus = cursorToProdus(cursor);
        cursor.close();
        return newProdus;
    }

    public static List<Produse> listeazaToateProduse(){

        List<Produse> listaProduse = new ArrayList<Produse>();
        Cursor cursor = mDatabase.query(DatabaseHelper.TABLE_PRODUS, mAllColumns, null,null,null,null,null);
        cursor.moveToFirst();
        Log.e(TAG,"While in progres");

        Produse produs;

        while (!cursor.isAfterLast()) {
            Log.e(TAG,"While accesat");
            produs = cursorToProdus(cursor);
            listaProduse.add(produs);
            cursor.moveToNext();
        }

        return listaProduse;
    }

    public static Produse cursorToProdus(Cursor cursor) {
       Produse produs = new Produse();
        produs.setID(cursor.getLong(0));
        produs.setNumeProdus(cursor.getString(1));
        produs.setCategorieProdus(cursor.getString(3));
        produs.setPretProdus(cursor.getInt(2));


        return produs;
    }

}
