package com.wu.dlsample.one_pulgin4;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ryg.dynamicload.DLBasePluginActivity;



public class MainActivity extends DLBasePluginActivity {
//public class MainActivity extends Activity {

    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView = (WebView) findViewById(R.id.webView);
//		WebView.setWebContentsDebuggingEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        WebView.setWebContentsDebuggingEnabled(true);

        webView.loadUrl("http://10.1.13.137/test2/");

//        ListenCloudUtil.newInstance(ListenCloudConfigBuilder.createBuilder()
//        .build(getApplicationContext(),"84349aecf4554f6d885102bf5b79faf5"));



         findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 throw new NullPointerException();

             }
         });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK){
            if (webView != null && webView.canGoBack()){
                webView.goBack();
                return true;
            }
        }

        return super.onKeyDown(keyCode, event);


    }
}
