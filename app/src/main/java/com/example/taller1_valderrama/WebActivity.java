package com.example.taller1_valderrama;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.ArrayList;

public class WebActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView myWebView= (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://sauce.pntic.mec.es/~rmarti9/WebBabilonia/Biografias/Fibonacci.htm");



    }




}
