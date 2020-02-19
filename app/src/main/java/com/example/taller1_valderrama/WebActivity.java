package com.example.taller1_valderrama;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.ArrayList;

public class WebActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webactivity);
        WebView myWebView=  findViewById(R.id.webview);
        myWebView.loadUrl("https://es.wikipedia.org/wiki/Leonardo_de_Pisa");
    }




}
