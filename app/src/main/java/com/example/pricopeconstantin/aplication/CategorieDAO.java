package com.example.pricopeconstantin.aplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO {

    public static final String TAG = "CateorieDAO";
    private Context mContext;
    //public static SQLiteDatabase mDatabase;
    //public DatabaseHelper mDbHelper;
    private static String[] mAllColumns = {DatabaseHelper.COLUMN_ID_CATEGORIE,
            DatabaseHelper.COLUMN_NUME_CATEGORIE,
    };

    public CategorieDAO(Context context) {
/*
        ProduseDAO.mDbHelper = new DatabaseHelper(context);
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

        ProduseDAO.mDatabase = ProduseDAO.mDbHelper.getWritableDatabase();

*/
        mContext=context;
    }

    public  Categorie adaugareCategorie(String numeCategorie){

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COLUMN_NUME_CATEGORIE, numeCategorie);

        Cursor cursor;
        DAO dao=new DAO(mContext, DatabaseHelper.TABLE_CATEGORIE, contentValues, mAllColumns, DatabaseHelper.COLUMN_ID_CATEGORIE,1);
        cursor = dao.getCursor();

/*        long insertId = ProduseDAO.mDatabase.insert(DatabaseHelper.TABLE_CATEGORIE, null, contentValues);

        Cursor cursor =  ProduseDAO.mDatabase.query(DatabaseHelper.TABLE_CATEGORIE, mAllColumns,
                DatabaseHelper.COLUMN_NUME_CATEGORIE + " = " + insertId, null, null,
                null, null);*/

        cursor.moveToFirst();
        Categorie newCategorie = cursorToCategorie(cursor);
        cursor.close();
         Log.e(TAG,"Categorie adaugata cu succes");
        return newCategorie;

    }

    public void Adauga_Categorii(List<String> list)
    {
        for (int i = 0 ; i< list.size();i++)
        {
            Categorie categ= this.adaugareCategorie(list.get(i));
        }
    }

    public  List<Categorie> obtineListaCategorii(){
        List<Categorie> listaCategorie = new ArrayList<>();

        //Cursor cursor = ProduseDAO.mDatabase.query(DatabaseHelper.TABLE_CATEGORIE, mAllColumns, null,null,null,null,null);

        Cursor cursor;
        DAO dao=new DAO(mContext, DatabaseHelper.TABLE_CATEGORIE, null, mAllColumns, DatabaseHelper.COLUMN_ID_CATEGORIE,0);
        cursor = dao.getCursor();
        cursor.moveToFirst();
        Log.e(TAG,"While in progres");

        Categorie categorie;

        while (!cursor.isAfterLast()) {
            Log.e(TAG,"While accesat");
            categorie = cursorToCategorie(cursor);
            listaCategorie.add(categorie);
            cursor.moveToNext();
        }

        return listaCategorie;

    }


   // public void close() {
   //     ProduseDAO.mDbHelper.close();
    //}

    public static Categorie cursorToCategorie(Cursor cursor) {
        Categorie categorie = new Categorie();
        categorie.setID(cursor.getLong(0));
         categorie.setNumeCategorie(cursor.getString(1));


        return categorie;
    }

}