package com.example.taller1_valderrama;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity2 extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        TextView resultado;
        resultado=  findViewById(R.id.resultado);
        ArrayList <Integer> resul= getIntent().getIntegerArrayListExtra("numero");
        for(int c:resul) {
            resultado.setText(resultado.getText()+ "\n"+c);
        }

    }


}
