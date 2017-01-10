package com.aegroto.tmsimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private final String siteUrl="file:///android_asset/index.html";
    private TextView textView;

    protected String getURLOutput(String url) throws MalformedURLException,IOException {
        String output="", currentLine;

        URL site = new URL(url);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(site.openStream()));

        while ((currentLine = bufferedReader.readLine()) != null)
            output+=currentLine;

        bufferedReader.close();

        return output;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RelativeLayout layout =

        /*textView = new TextView(this);
        layout.addView(textView);

        setContentView(layout);*/
        String hash = "#aaab;;;%3C{a,b},#,{q0,qF},q0,{qF},d%3E;;;%3Cq0,a,q0,a,r%3E%0A%3Cq0,b,qF,#,r%3E;;;250;;;";

        WebView browser=(WebView) findViewById(R.id.browser_main);

        browser.setWebChromeClient(new WebChromeClient());
        browser.getSettings().setJavaScriptEnabled(true);
        browser.loadUrl(siteUrl+hash);

        //layout.addView(browser);

        //textView.setText(browser.);

        //Document doc = Jsoup.parse("");
    }

    public void setTextOnTextView(String text) {
        textView.setText(text);
    }
}
