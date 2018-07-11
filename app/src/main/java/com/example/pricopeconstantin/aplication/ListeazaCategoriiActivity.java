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

public class ListeazaCategoriiActivity extends Activity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener, View.OnClickListener {
    private String TAG = "Listeaza Categorii";
    //Obtinem date si le introducem in lista
    ProduseDAO produseDAO;

    private void populateListView(){
        Log.e(TAG,"populateListView: Displaying data in the ListView.");

        List<Categorie> listaCategorii = CategorieDAO.obtineListaCategorii();
        List<String> listaCategoriString = new ArrayList<>();
        if(listaCategorii.size()>0)
        {
        int dim = listaCategorii.size();
        Log.e(TAG, "Index pentru baza de date: " + Integer.toString(dim));
        for (int i = 0; i < listaCategorii.size(); i++) {
            String str = Integer.toString(i) + "  " + (listaCategorii.get(i)).getNumeCategorie();
            Log.e(TAG, (listaCategorii.get(i)).getNumeCategorie());
            listaCategoriString.add(str);

        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaCategoriString);
        lista_categorii.setAdapter(adapter);


    }
        else

    {
        Log.e(TAG, "Lista de produse e goala");
    }

    }

        @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        return false;
        }

    ListView lista_categorii;
    ImageButton adaugaProdus;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "Creare activitate de populare lista ");
        setContentView(R.layout.lista_produse);

        lista_categorii = (ListView) findViewById(R.id.lista_produse);

        populateListView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_add:
                Log.e(TAG, "Buton de adauga apasat.");
                Intent myIntent = new Intent(ListeazaCategoriiActivity.this, AddProdusActivity.class);
                ListeazaCategoriiActivity.this.startActivity(myIntent);
        }
    }
}