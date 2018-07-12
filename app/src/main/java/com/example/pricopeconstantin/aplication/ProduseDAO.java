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
    Context  mContext;


    private static String[] mAllColumns  = { DatabaseHelper.COLUMN_ID_PRODUS,
            DatabaseHelper.COLUMN_NUME_PRODUS,
            DatabaseHelper.COLUMN_CATEGORIE_PRODUS,
            DatabaseHelper.COLUMN_PRET_PRODUS,
            };

    public  ProduseDAO(Context context) {
        this.mContext = context;
    }



    public Produse adaugareProdus(String numeProdus, String categorie,int pretProdus) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NUME_PRODUS, numeProdus);
        values.put(DatabaseHelper.COLUMN_CATEGORIE_PRODUS, categorie);
        values.put(DatabaseHelper.COLUMN_PRET_PRODUS, pretProdus);

        Cursor cursor;
        DAO dao=new DAO(mContext, DatabaseHelper.TABLE_PRODUS, values, mAllColumns, DatabaseHelper.COLUMN_ID_PRODUS,1);
        cursor = dao.getCursor();

        cursor.moveToFirst();
        Produse newProdus = cursorToProdus(cursor);
        cursor.close();
        return newProdus;
    }

    public   List<Produse> listeazaToateProduse(){

        List<Produse> listaProduse = new ArrayList<Produse>();

        Cursor cursor ;//= mDatabase.query(DatabaseHelper.TABLE_PRODUS, mAllColumns, null,null,null,null,null);
        DAO dao=new DAO(mContext, DatabaseHelper.TABLE_PRODUS, null, mAllColumns, DatabaseHelper.COLUMN_ID_PRODUS,0);

        cursor = dao.getCursor();
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

    public static void deleteProduct(){


    }

    public static Produse cursorToProdus(Cursor cursor) {
       Produse produs = new Produse();
        produs.setID(cursor.getLong(0));
        produs.setNumeProdus(cursor.getString(1));
        produs.setCategorieProdus(cursor.getString(2));
        produs.setPretProdus(cursor.getInt(3));


        return produs;
    }

}
