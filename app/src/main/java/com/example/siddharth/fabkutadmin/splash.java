package com.example.siddharth.fabkutadmin;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.siddharth.fabkutadmin.Admin.view.Login;
import com.example.siddharth.fabkutadmin.DataEntry.view.DataEntry;

import java.util.List;

/**
 * Created by Udit on 16-Jan-17.
 */

public class splash extends Activity {
    ImageView imageView;
    TextView textView;
    String flage;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        preferences = getSharedPreferences("CreateLogin",MODE_PRIVATE);

        flage = preferences.getString("flag","hello");
      //  imageView = (ImageView) findViewById(R.id.logo_img);
      //  textView = (TextView) findViewById(R.id.textView3);
        Thread timerThread = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    if (flage.equalsIgnoreCase("data")) {
                        Intent intent = new Intent(splash.this, DataEntry.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(splash.this, Login.class);
                        startActivity(intent);
                    }
                }

            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
