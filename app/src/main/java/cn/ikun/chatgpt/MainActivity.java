package cn.ikun.chatgpt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.webview);
        //背景设置为黑色，解决加载前白屏问题
        webView.setBackgroundColor(Color.parseColor("#000000"));
        webView.loadUrl("http://47.115.203.9:12345");
        webView.setWebViewClient(new WebViewClient() {
            //重载链接跳转,防止跳转到浏览器
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri uri = request.getUrl();
                //Log.i("Test",uri.toString());
                if(!uri.toString().contains("http://47.115.203.9:12345")){
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }else{
                    view.reload();
                }
                return true;
            }
        });

        WebSettings webSettings=webView.getSettings();
        //启用js
        webSettings.setJavaScriptEnabled(true);
        //启用localStorage
        webSettings.setDomStorageEnabled(true);

        //webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);


    }

}