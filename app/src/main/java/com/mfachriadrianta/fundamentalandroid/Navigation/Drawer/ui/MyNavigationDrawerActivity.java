package com.mfachriadrianta.fundamentalandroid.Navigation.Drawer.ui;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.mfachriadrianta.fundamentalandroid.R;
import com.mfachriadrianta.fundamentalandroid.databinding.ActivityMyNavigationDrawerBinding;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyNavigationDrawerActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMyNavigationDrawerBinding binding;
    private CircleImageView circleImageView;
    private String imageViewUrl = "https://i.postimg.cc/sDqmzr47/me.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyNavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMyNavigationDrawer.toolbar);
        binding.appBarMyNavigationDrawer.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Without add toast
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                // With toast
                Snackbar.make(view, "This is Snackbar with toast", Snackbar.LENGTH_LONG).
                        setAction("Show", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MyNavigationDrawerActivity.this, "This is toast", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_cart)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_my_navigation_drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        circleImageView = navigationView.getHeaderView(0).findViewById(R.id.imageView);
        Glide.with(MyNavigationDrawerActivity.this).load(imageViewUrl).into(circleImageView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_my_navigation_drawer);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}