package com.noskra.pasoparametrointent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActividad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        TextView textView = (TextView) findViewById(R.id.textViewInformacion);
        textView.setText(getIntent().getExtras().getString("informacion"));

    }
}
