package com.noskra.listatareas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText editTextAgregar = (EditText)findViewById(R.id.editTextAgregar);

        ListView listViewLista = (ListView) findViewById(R.id.listViewLista);

        final ArrayList<String> listaTareas = new ArrayList<String>();
        listaTareas.add("Tarea Uno");
        listaTareas.add("Tarea Dos");

        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaTareas);


        listViewLista.setAdapter(adaptador);


        editTextAgregar.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(event.getAction() == KeyEvent.ACTION_DOWN){
                   if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER){

                       listaTareas.add(editTextAgregar.getText().toString());

                       editTextAgregar.setText("");

                       adaptador.notifyDataSetChanged();
                       return true;
                   }

                }
                return false;
            }
        });





    }
}
