package com.example.pricopeconstantin.aplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddCategorieActivity extends Activity {

    EditText ed1;
    TextView textView2;
    Button bt1;
    private String TAG="HELL";
    ProduseDAO produseDAO;
    CategorieDAO categorieDAO;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adaugare_categorie);
        textView2 = findViewById(R.id.textView2);
        ed1 =findViewById(R.id.etnum1);
        bt1 =findViewById(R.id.add1);
        this.produseDAO = new ProduseDAO(this);
        this.categorieDAO = new CategorieDAO(this);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable numeCatgorie = ed1.getText();
                if (!TextUtils.isEmpty(numeCatgorie))
                {
                    categorieDAO.adaugareCategorie(numeCatgorie.toString());
                    textView2.setText("Categoria: "+numeCatgorie.toString() + " adaugata cu succes.");
                }else
                {
                    textView2.setText("Completati numele Categoriei");
                }

            }}
        );

    }


}
