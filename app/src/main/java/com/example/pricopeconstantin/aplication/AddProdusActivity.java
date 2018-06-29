package com.example.pricopeconstantin.aplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.Toast;

public class AddProdusActivity extends Activity {

    EditText num1,num2;
    TextView textView;
    Button add;
    ProduseDAO produseDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adaugare_produs);

        add=(Button) findViewById(R.id.add);
        textView= (TextView) findViewById(R.id.textView);
        num1 = (EditText) findViewById(R.id.etnum1) ;
        num2= (EditText) findViewById(R.id.etnum2);
        this.produseDAO  = new ProduseDAO(this);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable numeProdus = num1.getText();
                Editable categorieProdus = num2.getText();
                if(!TextUtils.isEmpty(numeProdus) && !TextUtils.isEmpty(categorieProdus))
                {
                    Produse produsCreat = produseDAO.adaugareProdus(numeProdus.toString(),categorieProdus.toString());

                    textView.setVisibility(1);
                    textView.setText("Produs adaugat cu succes");
                }
                else
                {
                    textView.setVisibility(1);
                    textView.setText("Va rugam sa completati toate campurile.");
                }


            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
