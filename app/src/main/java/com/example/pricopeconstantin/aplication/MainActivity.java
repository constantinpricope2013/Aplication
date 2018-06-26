package com.example.pricopeconstantin.aplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText num1,num2;
    TextView resu;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          add=(Button) findViewById(R.id.add);
         num1=(EditText) findViewById(R.id.etnum1);
         num2=(EditText) findViewById(R.id.etnum2);
         resu=(TextView) findViewById(R.id.b);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mynum1 = num1.getText().toString();
                String mynum2=num2.getText().toString();
                Integer res=Integer.parseInt(mynum1)+Integer.parseInt(mynum2);
                resu.setText(Integer.toString(res));
            }
        });
    }
}
