package com.example.hui.js_with_native;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        //实例化WebView对象
        webView = new WebView(this);
        //设置WebView属性，能够执行Javascript脚本
        webView.setWebChromeClient(new WebChromeClient());
        final WebSettings settings = webView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);

        webView.addJavascriptInterface(new JavascriptInterface(), "javascriptInterface");

        try {
            //设置打开的页面地址
            webView.loadUrl("file:///android_asset/javascript.html");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }


        setContentView(webView);

    }
    public class JavascriptInterface {
        @android.webkit.JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(MainActivity.this, toast, Toast.LENGTH_SHORT).show();
        }
    }
}
