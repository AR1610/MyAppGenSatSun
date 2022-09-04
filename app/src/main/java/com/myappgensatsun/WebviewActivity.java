package com.myappgensatsun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.loadUrl("https://www.javatpoint.com/");
        webView.setWebViewClient(new MyWebview());
    }

    private class MyWebview extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            finish();
        }
    }
}