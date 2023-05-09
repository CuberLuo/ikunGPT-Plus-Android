package cn.ikun.chatgpt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.webview);
        webView.loadUrl("http://1.15.134.164:999");
        WebSettings webSettings=webView.getSettings();
        //启用js
        webSettings.setJavaScriptEnabled(true);
        //启用localStorage
        webSettings.setDomStorageEnabled(true);
    }
}