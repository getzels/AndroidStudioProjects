package com.noskra.formulariosimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private OnClickListener botonListener = new OnClickListener(){

        public void onClick(android.view.View v){
            final EditText editTextName = (EditText) findViewById(R.id.editTextName);
            String valoreditTextName = editTextName.getText().toString();

            TextView textViewResultado = (TextView) findViewById(R.id.textViewResuldado);
            textViewResultado.setText(valoreditTextName);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewResultado = (TextView) findViewById(R.id.textViewResuldado);
        textViewResultado.setText("Aqui se mostrara el resultado");

        Button buttonEnviar = (Button) findViewById(R.id.buttonEnviar);
        buttonEnviar.setOnClickListener(botonListener);


    }




}
