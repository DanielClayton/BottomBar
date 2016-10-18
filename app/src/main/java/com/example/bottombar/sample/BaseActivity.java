package com.example.bottombar.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class BaseActivity extends AppCompatActivity {

    LinearLayout vMainContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        vMainContent = (LinearLayout) findViewById(R.id.main_content);

        if (hasBottomBar()) {
            configureBottomBar();
        }

        doCreate(savedInstanceState);


    }

    protected void doCreate(Bundle savedInstanceState) {
        // Override to create activity here
    }

    protected void configureBottomBar() {
        // Override to build bottom bar
    }

    protected boolean hasBottomBar() {
        return true;
    }
}
