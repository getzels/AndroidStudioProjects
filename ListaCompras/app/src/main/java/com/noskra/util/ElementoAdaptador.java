package com.noskra.util;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.noskra.entidad.Elemento;
import com.noskra.listacompras.R;

import java.util.ArrayList;


/**
 * Created by noskra on 10/8/16.
 */

public class ElementoAdaptador extends BaseAdapter {


    private Activity activity;
    private ArrayList<Elemento> elementos;

    public ElementoAdaptador(Activity activity, ArrayList<Elemento> elementos) {

        this.activity = activity;
        this.elementos = elementos;
    }

    @Override
    public int getCount() {
        return elementos.size();
    }

    @Override
    public Object getItem(int position) {
        return elementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return elementos.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Elemento elemento;

        //Verifica si la vista se a desplegado.
        if (view == null){

            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.lista_elementos_layout,null);
        }

        elemento = elementos.get(position);

        //Modificamos el contenido del nombre del elemento.
        TextView nombre = (TextView) view.findViewById(R.id.nombre);
        nombre.setText(elemento.getNombre());

        //Modificamos el contenido de la imagen
        ImageView imagen = (ImageView) view.findViewById(R.id.imagenElemento);

        //Recuperamos el identificador de la imagen
        int recursoImagen = activity.getResources().getIdentifier("drawable/" +
                elemento.getImagen(),null,activity.getPackageName());
        //Colocamos la imagen recuperada segun clase R
        imagen.setImageDrawable(activity.getResources().getDrawable(recursoImagen));

        return view;
    }
}
