package com.example.taller1_valderrama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PaisesActivity extends AppCompatActivity {

    ArrayList <String> paises= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        String buffer= loadJSONFromAsset();
        try {
            JSONObject json = new JSONObject(buffer);
            JSONArray paisesJsonArray = json.getJSONArray("paises");
            for (int i = 0; i < paisesJsonArray.length(); i++) {
                JSONObject jsonObject = paisesJsonArray.getJSONObject(i);
                String country = jsonObject.getString("nombre_pais");
                paises.add(country);
            }
        } catch (JSONException x){
            x.printStackTrace();
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,paises);
        final ListView listView= findViewById(R.id.listaPaises);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(getBaseContext(),InfoPaisActivity.class);
                i.putExtra("pais", (String) listView.getAdapter().getItem(position));
                startActivity(i);
            }
        });


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
