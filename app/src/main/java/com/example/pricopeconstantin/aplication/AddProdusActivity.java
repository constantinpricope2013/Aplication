package com.example.pricopeconstantin.aplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddProdusActivity extends Activity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    EditText num1, editText;
    TextView textView;
    Spinner sp1;
    int pozitieCategorie=-1;
    Button add;
    ProduseDAO produseDAO;
    CategorieDAO categorieDAO;
    private String TAG = "ADDPRODUS";
    List<Categorie> listaCategorii ;
    List<String> listaCategoriString = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adaugare_produs);

        add = (Button) findViewById(R.id.add);
        textView = (TextView) findViewById(R.id.textView);
        num1 = (EditText) findViewById(R.id.etnum1);
        sp1 = (Spinner) findViewById(R.id.spinner1);
        editText = (EditText) findViewById(R.id.editText);
        this.produseDAO = new ProduseDAO(this);
        this.categorieDAO = new CategorieDAO(this);

        listaCategorii = categorieDAO.obtineListaCategorii();

        Log.e(TAG, "Index pentru baza de date: " + listaCategorii.size());
        if (listaCategorii.size() > 0) {
            int dim = listaCategorii.size();
            Log.e(TAG, "Index pentru baza de date: " + Integer.toString(dim));
            for (int i = 0; i < listaCategorii.size(); i++) {
                String str = Integer.toString(i) + "  " + (listaCategorii.get(i)).getNumeCategorie();
                Log.e(TAG, (listaCategorii.get(i)).getNumeCategorie());
                listaCategoriString.add(str);

            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(AddProdusActivity.this, android.R.layout.simple_spinner_item, listaCategoriString);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp1.setAdapter(adapter);
            sp1.setOnItemSelectedListener(this);
        }
        //this.add.setOnClickListener(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                Editable numeProdus = num1.getText();
                Editable pretProdus = editText.getText();


                    if(pozitieCategorie < 0 )
                    {
                        textView.setText("Va rugam sa selectati categoria.");
                    }
                    else if (!TextUtils.isEmpty(numeProdus) && !TextUtils.isEmpty(pretProdus)) {


                        try {
                            Produse produsCreat = produseDAO.adaugareProdus(numeProdus.toString(),listaCategoriString.get(pozitieCategorie), Integer.parseInt(pretProdus.toString()));
                        } catch (Exception e) {
                            Log.e(TAG, "Eroare in creearea produsului " + e.getMessage());
                            e.printStackTrace();
                        }

                        textView.setText("Produs adaugat cu succes,categorie:" +listaCategoriString.get(pozitieCategorie));
                    }
                    else {

                        textView.setText("Va rugam sa completati toate campurile.");
                    }
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        pozitieCategorie = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        pozitieCategorie= -2;
    }
}
