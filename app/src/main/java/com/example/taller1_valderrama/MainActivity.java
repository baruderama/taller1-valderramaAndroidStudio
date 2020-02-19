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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ArrayList <Integer> serie= new ArrayList<Integer> ();
    public ArrayList <Integer> numerosMult= new ArrayList<Integer> ();
    public  int contadorFib=0;
    public  int contadorFac=0;
    public int aux1=0;
    public int aux2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView i=findViewById(R.id.vecesFibo);
        i.setText("veces llamado fibo= "+contadorFib);
        TextView u=findViewById(R.id.vecesFac);
        u.setText("veces llamado fac= "+contadorFac);

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        String currentDateTimeString = java.text.DateFormat.getDateTimeInstance().format(new Date());
        if(contadorFib>aux1) {
            TextView i = findViewById(R.id.vecesFibo);
            i.setText("veces llamado fibo= " + contadorFib + "\n" + "fecha/hora: " + currentDateTimeString);
            aux1=contadorFib;
        }
        if(contadorFac>aux2) {
            TextView u = findViewById(R.id.vecesFac);
            u.setText("veces llamado fac= " + contadorFac + "\n" + "fecha/hora: " + currentDateTimeString);
            aux2=contadorFac;
        }


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
        contadorFac++;

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
        //calculo=  findViewById(R.id.calculo);
        //int ultimoNum= serie.get(serie.size()-1);
        Intent intent= new Intent (v.getContext(), Activity2.class);
        intent.putExtra("numero",serie);
        startActivity(intent);
        contadorFib++;
        //calculo.setText(calculo.getText()+"\n"+ultimoNum);
    }

    public void recursivoFibonacci(){
        int ultimo=serie.size();

            int fib1=serie.get(ultimo-1);
            int fib2=serie.get(ultimo-2);
            serie.add(fib1+fib2);

    }


}
