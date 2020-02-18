package com.example.pooptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SearchByGoogle extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_google);

        webView = (WebView) findViewById(R.id.searchByG);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://images.google.com/?gws_rd=ssl");
        //webView.loadUrl("https://www.google.com");



    }
}
