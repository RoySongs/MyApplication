package com.example.part4_11;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class Lab11_2Activity extends AppCompatActivity implements View.OnClickListener{

    Button lineChart;
    Button barChart;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab11_2);

        webView = (WebView)findViewById(R.id.webView);
        lineChart = (Button)findViewById(R.id.lineChart);
        barChart = (Button)findViewById(R.id.barChart);

        lineChart.setOnClickListener(this);
        barChart.setOnClickListener(this);

        // 웹 뷰의 셋팅 설정을 가져온다.
        WebSettings settings = webView.getSettings();
        // 자바스크립트 사용을 가능하게 한다.
        settings.setJavaScriptEnabled(true);

        //웹 뷰의 경로 설정
        // file:///android_asset은 myProject/app/src/main/assets/ 을 의미한다.
        webView.loadUrl("file:///android_asset/test.html");

        // 자바스크립트 사용을 가능??
        webView.addJavascriptInterface(new JavascriptTest(), "android");
        // ??
        webView.setWebViewClient(new MyWebClient());
        // ??
        webView.setWebChromeClient(new MyWebChrome());

    }

    @Override
    public void onClick(View v){
        if(v == lineChart){
            webView.loadUrl("javascript:lineChart()");
        } else if(v == barChart){
            webView.loadUrl("javascript:barChart()");
        }
    }


    class JavascriptTest {
        // 자바스크립트 사용을 위해 필요한 어노테이션
        @JavascriptInterface
        public String getChartData(){
            StringBuffer buffer = new StringBuffer();
            buffer.append("[");
            for(int i = 0; i< 14;i++){
                buffer.append("["+i+","+Math.sin(i)+"]");
                Log.d("kkang", i+","+Math.sin(i));
                if(i<13) buffer.append(".");
            }
            buffer.append("]");
            return buffer.toString();
        }
    }

    class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            Toast t = Toast.makeText(Lab11_2Activity.this, url, Toast.LENGTH_SHORT);
            t.show();

            return true;
        }
    }

    class MyWebChrome extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result){
            Toast t = Toast.makeText(Lab11_2Activity.this, message, Toast.LENGTH_SHORT);
            t.show();
            result.confirm();
            return true;
        }
    }
}
