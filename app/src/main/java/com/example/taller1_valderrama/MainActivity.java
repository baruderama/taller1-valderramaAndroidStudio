package com.example.taller1_valderrama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ArrayList <Integer> serie= new ArrayList<Integer> ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serie.add(0);
        serie.add(1);
        serie.add(1);



    }


    public void calcularFibonacci(View v) {
        Intent intent= new Intent (v.getContext(), Activity2.class);
        TextView calculo;
        recursivoFibonacci();
        calculo=  findViewById(R.id.calculo);
        int ultimoNum= serie.get(serie.size()-1);
        intent.putExtra("numero",ultimoNum);
        startActivity(intent);
        calculo.setText(calculo.getText()+"\n"+ultimoNum);


    }

    public void recursivoFibonacci(){
        int ultimo=serie.size();

            int fib1=serie.get(ultimo-1);
            int fib2=serie.get(ultimo-2);
            serie.add(fib1+fib2);

    }


}
