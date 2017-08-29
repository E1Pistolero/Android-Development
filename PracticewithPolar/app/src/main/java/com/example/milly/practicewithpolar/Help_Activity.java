package com.example.milly.practicewithpolar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Help Activity
 *
 * Pulls information from Polar's website in order to help users
 * who have issues with connecting their heart rate monitors
 * with phone.
 *
 */

public class Help_Activity extends AppCompatActivity {

    WebView mWebHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        //View for showing web pages
        mWebHelp = (WebView) findViewById(R.id.web_help);
        WebSettings webSettings = mWebHelp.getSettings();
        //uses JavaScrip to present things in WebView
        webSettings.setJavaScriptEnabled(true);
        //Polar's website
        mWebHelp.loadUrl("http://www.polar.com/us-en/support/FAQs/Troubleshooting_H7_heart_rate_sensor");


    }


}
