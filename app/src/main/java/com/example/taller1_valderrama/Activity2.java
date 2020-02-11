package com.example.taller1_valderrama;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        TextView resultado;
        resultado=  findViewById(R.id.resultado);
        int resul= getIntent().getIntExtra("numero",0);
        resultado.setText(resultado.getText()+"\n"+resul);
    }
}
