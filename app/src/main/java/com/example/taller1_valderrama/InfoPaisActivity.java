package com.example.taller1_valderrama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class InfoPaisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pais);
        String buffer= loadJSONFromAsset();
        TextView text;
        text=findViewById(R.id.textView3);
        try {
            JSONObject json = new JSONObject(buffer);
            JSONArray paisesJsonArray = json.getJSONArray("paises");


            for (int i = 0; i < paisesJsonArray.length(); i++) {
                JSONObject jsonObject = paisesJsonArray.getJSONObject(i);
                String country = jsonObject.getString("nombre_pais");
                String pais= getIntent().getStringExtra("pais");

                if(country.equals(pais)){

                    String capital=jsonObject.getString("capital");
                    String nomInt=jsonObject.getString("nombre_pais_int");
                    String sigla=jsonObject.getString("sigla");
                    text.setText("capital: "+capital+"\n"+"nombre internacional: "+nomInt+"\n"+"sigla: "+sigla);
                    break;
                }


            }
        } catch (JSONException x){
            x.printStackTrace();
        }

    }

    public String loadJSONFromAsset() {
        String json=null;
        try{
            InputStream is=this.getAssets().open("paises.json");
            int size=is.available();
            byte[] buffer= new byte[size];
            is.read(buffer);
            is.close();
            json= new String (buffer,"UTF-8");

        }catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
