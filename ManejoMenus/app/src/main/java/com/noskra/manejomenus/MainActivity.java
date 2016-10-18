package com.noskra.manejomenus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        Intent intent = null;

        switch (item.getItemId()) {
            case R.id.idAyuda:
                intent = new Intent(MainActivity.this, Ayuda.class);
                startActivity(intent);
                break;
            case R.id.idConfiguracion:
                intent = new Intent(MainActivity.this, Configuracion.class);
                startActivity(intent);
        }
        return true;
    }
}
