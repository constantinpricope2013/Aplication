package com.example.pricopeconstantin.aplication; /**
 * Created by Pricope Constantin on 6/27/2018.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=2;

    public static final String bd = "Poduse";
    public static final String TAG = "DATABASE_HELPER";

    public static final String TABLE_PRODUS = "Poduse";
    public static final String COLUMN_ID_PRODUS = "ID_PRODUS";
    public static final String COLUMN_NUME_PRODUS = "Nume_Produs";
    public static final String COLUMN_PRET_PRODUS = "Pret_Produs";
    public static final String COLUMN_CATEGORIE_PRODUS= "Categorie_Produs";


    public static final String TABLE_CATEGORIE = "Categorie";
    public static final String COLUMN_ID_CATEGORIE = "ID_Categorie";
    public static final String COLUMN_NUME_CATEGORIE = "Nume_Categorie";

    public DatabaseHelper(Context context) {
        super(context, bd, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableCategorie= "CREATE TABLE " + TABLE_CATEGORIE + " ("+ COLUMN_ID_CATEGORIE +" INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NUME_CATEGORIE +" TEXT)";
        String createTableProdus = "CREATE TABLE " + TABLE_PRODUS + " ("+ COLUMN_ID_PRODUS +" INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NUME_PRODUS +" TEXT, " + COLUMN_PRET_PRODUS + " REAL, FOREIGN KEY(" + COLUMN_ID_CATEGORIE +  " REFERENCES " + TABLE_CATEGORIE + "(" + COLUMN_ID_CATEGORIE + "))";


        sqLiteDatabase.execSQL(createTableProdus);
        sqLiteDatabase.execSQL(createTableCategorie);
    }



    @Override


    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i,int  i1) {
        Log.e(TAG,"Eroare in updatarea bazei de date ");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIE);
        onCreate(sqLiteDatabase);
    }


}
