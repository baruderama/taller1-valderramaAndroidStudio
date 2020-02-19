package com.example.taller1_valderrama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ArrayList <Integer> serie= new ArrayList<Integer> ();
    public ArrayList <Integer> numerosMult= new ArrayList<Integer> ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void paginaWeb(View v){
        Intent intent= new Intent (v.getContext(), WebActivity.class);
        startActivity(intent);

    }

    public void factorialCalculo(View v){
        numerosMult.clear();
        Spinner spi= findViewById(R.id.spinner);
        int numFactorial= Integer.parseInt(spi.getSelectedItem().toString());
        int numFactoResultado=1;
        for(int i= 1; i<=numFactorial;i++){
            numerosMult.add(i);
            numFactoResultado=numFactoResultado*i;
        }
        numerosMult.add(numFactoResultado);
        Intent intent= new Intent (v.getContext(), FactorialActivity.class);
        intent.putExtra("factorial",numerosMult);
        startActivity(intent);
    }

    public void paises(View v){
        Intent intent= new Intent (v.getContext(), PaisesActivity.class);
        startActivity(intent);

    }


    public void calcularFibonacci(View v) {

        serie.clear();
        serie.add(0);
        serie.add(1);
        serie.add(1);

        TextView calculo;
        EditText numeroDeIteraciones;
        numeroDeIteraciones= findViewById(R.id.campoTexto);
        int numerito= Integer.parseInt(numeroDeIteraciones.getText().toString());

        for(int i=0;i<numerito;i++)
            recursivoFibonacci();
        calculo=  findViewById(R.id.calculo);
        //int ultimoNum= serie.get(serie.size()-1);
        Intent intent= new Intent (v.getContext(), Activity2.class);
        intent.putExtra("numero",serie);
        startActivity(intent);
        //calculo.setText(calculo.getText()+"\n"+ultimoNum);
    }

    public void recursivoFibonacci(){
        int ultimo=serie.size();

            int fib1=serie.get(ultimo-1);
            int fib2=serie.get(ultimo-2);
            serie.add(fib1+fib2);

    }


}
