package com.noskra.dialogoalerta;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int MOSTRAR_DIALOGO = 0;

    private Dialog dialog;

    //Definimos el Handler de Mensajes
    private Handler handler = new Handler(){
      public void handlerMessage(android.os.Message msg){
          dialog.dismiss();
      }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alerta();

        progreso();


    }

    protected android.app.Dialog onCreateDialog(int id){
        switch (id){
            case MOSTRAR_DIALOGO :
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                return builder.setMessage("Responde").setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Contestate NO", Toast.LENGTH_LONG).show();
                    }
                }).setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Contestate SI", Toast.LENGTH_LONG).show();
                    }
                }).create();
        }
        return null;
    }

    private void progreso(){
        Button button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se muestra el dialog de proceso
                dialog = ProgressDialog.show(MainActivity.this, "Esperando...", "Trabajo en proceso");

                Thread hilo = new Thread(new Runnable(){

                    public void run() {
                     try {
                         Thread.sleep(3000);
                     }catch(InterruptedException e){
                         e.printStackTrace();
                     }

                        handler.sendEmptyMessage(0);
                    }
                });
                hilo.start();
            }
        });
    }

    private void alerta(){
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(MOSTRAR_DIALOGO);
            }
        });
    }
}
