package com.example.pricopeconstantin.aplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListeazaProduseActivity extends Activity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener, View.OnClickListener {


    ListView lista_produse;
    ImageButton adaugaProdus;
    private static final String TAG = "ListDataActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "Creare activitate de populare lista ");
        setContentView(R.layout.lista_produse);

        lista_produse = (ListView) findViewById(R.id.lista_produse);

        populateListView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_add:
                Log.e(TAG, "Buton de adauga apasat.");
                Intent myIntent = new Intent(ListeazaProduseActivity.this, AddProdusActivity.class);
                ListeazaProduseActivity.this.startActivity(myIntent);
        }
    }
    private void populateListView() {
        //Obtinem date si le introducem in lista
        Log.e(TAG, "populateListView: Displaying data in the ListView.");
        ProduseDAO produseDAO;

        List<Produse> listaProduse = ProduseDAO.listeazaToateProduse();
        List<String> listaProdusString = new ArrayList<>();
        List<String> listaCategorii = new ArrayList<>();

        if(listaProduse.size() > 0) {
            int dim = listaProduse.size();
            Log.e(TAG,"Index pentru baza de date: " + Integer.toString(dim));
            for (int i = 0; i < listaProduse.size() ; i++) {
                    String str = Integer.toString(i) + "  " + (listaProduse.get(i)).toString();
                    Log.e(TAG, (listaProduse.get(i)).toString());
                    listaProdusString.add(str);


                    String str2 =(listaProduse.get(i)).getCategorieProdus();
                Log.e(TAG,"Nume categorie: "+ str2);
                   listaCategorii.add(str2);

            }
            //Adauga categorii automat in functie de categoriile prodduselor existente
            // CategorieDAO.Adauga_Categorii(listaCategorii);

            ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaProdusString);
            lista_produse.setAdapter(adapter);


        }
        else
        {
            Log.e(TAG,"Lista de produse e goala");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        return false;
    }
}
