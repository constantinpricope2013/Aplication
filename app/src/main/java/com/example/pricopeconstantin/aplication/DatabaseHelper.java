package com.example.pricopeconstantin.aplication; /**
 * Created by Pricope Constantin on 6/27/2018.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_PRODUS = "Poduse";
    public static final String COLUMN_ID_PRODUS = "ID_PRODUS";
    public static final String COLUMN_NUME_PRODUS = "Nume_Produs";
    public static final String COLUMN_CATEGORIE_PRODUS= "Categorie_Produs";


    public static final String TABLE_CATEGORIE = "Categorie";
    public static final String COLUMN_ID_CATEGORIE = "ID_Categorie";
    public static final String COLUMN_NUME_CATEGGORIE = "Nume_Categorie";


    public DatabaseHelper(Context context) {
        super(context, TABLE_PRODUS, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableProdus = "CREATE TABLE " + TABLE_PRODUS + " ("+ COLUMN_ID_PRODUS +"ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NUME_PRODUS +" TEXT, " + COLUMN_CATEGORIE_PRODUS +  " TEXT)";
        String createTableCategorie= "CREATE TABLE " + TABLE_CATEGORIE + " ("+ COLUMN_ID_CATEGORIE +"ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NUME_CATEGGORIE +" TEXT)";

        sqLiteDatabase.execSQL(createTableProdus);
        sqLiteDatabase.execSQL(createTableCategorie);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUS);
        onCreate(sqLiteDatabase);
    }


}
