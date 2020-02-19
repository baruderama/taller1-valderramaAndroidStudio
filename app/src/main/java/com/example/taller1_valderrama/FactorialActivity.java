package com.example.taller1_valderrama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class FactorialActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        TextView ver = findViewById(R.id.multiFactorial);
        ArrayList<Integer> resul = getIntent().getIntegerArrayListExtra("factorial");

        for (int i = 0; i < resul.size() - 1; i++) {
            ver.setText(ver.getText().toString() + resul.get(i) + "*");
        }
        ver = findViewById(R.id.resultadoFactorial);
        ver.setText(ver.getText().toString() + resul.get(resul.size() - 1));
    }

}
