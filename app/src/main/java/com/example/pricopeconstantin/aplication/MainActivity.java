package com.example.pricopeconstantin.aplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText num1,num2;
    TextView resu;
    Button add;
    Button listeazaProduse,listeazaCategorii;
    public String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Suntem pe MainACtivity ");
        add = findViewById(R.id.button);
        listeazaProduse = findViewById(R.id.listeazaProduse);
        listeazaCategorii  = findViewById(R.id.listeazaCategorii);



       add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddProdusActivity.class);
                MainActivity.this.startActivity(myIntent);
                Log.e(TAG, "Accesam pagina de adaugare produse ");


            }
        });

        listeazaProduse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondIntent = new Intent(MainActivity.this, ListeazaProduseActivity.class);
                MainActivity.this.startActivity(secondIntent);
                Log.e(TAG, "Accesam pagina listare produse ");
                }}
        );

        listeazaCategorii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thirdIntent = new Intent(MainActivity.this, ListeazaCategoriiActivity.class);
                MainActivity.this.startActivity(thirdIntent);
                Log.e(TAG, "Accesam pagina listare categorii ");
            }}
        );


    }
}
