package com.mfachriadrianta.fundamentalandroid.Navigation.Drawer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mfachriadrianta.fundamentalandroid.R;

public class SubwayNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway_navigation);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(getString(R.string.navigation_component));
        }
    }
}