package com.noskra.listacompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.noskra.entidad.Elemento;
import com.noskra.util.ElementoAdaptador;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.Recuperamos el LIstView
        ListView listView = (ListView) findViewById(R.id.listViewElementos);

        //2.Obtenemos los elementos de la lista
        final ArrayList<Elemento> elementos = getElementos();

        //3.Iniciamos el adaptador el cual llamara
        ElementoAdaptador adaptador = new ElementoAdaptador(this,elementos);

        //4.Asociamos el adaptador a la vista
        listView.setAdapter(adaptador);

        //5.Registramos el evento OnItemClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Recuperamos el layout
                Elemento elementoSel = elementos.get(position);

                String mensaje = "Posicion " + position + "-" + elementoSel.getNombre();

                //Enviamor una notificacion
                Toast.makeText(MainActivity.this,mensaje,Toast.LENGTH_SHORT).show();
            }
        });


    }

    private ArrayList<Elemento> getElementos() {
        ArrayList<Elemento> elementos = new ArrayList<Elemento>();

        elementos.add(new Elemento(1, "Manzana", "manzana"));
        elementos.add(new Elemento(2, "Kiwi", "kiwi"));
        elementos.add(new Elemento(3, "Pera", "pera"));

        return elementos;

    }


}
