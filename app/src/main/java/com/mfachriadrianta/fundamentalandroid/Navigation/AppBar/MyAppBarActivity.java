package com.mfachriadrianta.fundamentalandroid.Navigation.AppBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mfachriadrianta.fundamentalandroid.Navigation.AppBar.MenuAppBarActivity;
import com.mfachriadrianta.fundamentalandroid.Navigation.AppBar.MenuAppBarFragment;
import com.mfachriadrianta.fundamentalandroid.R;
import com.mfachriadrianta.fundamentalandroid.databinding.ActivityMyAppBarBinding;

public class MyAppBarActivity extends AppCompatActivity {

    private ActivityMyAppBarBinding activityMyAppBarBinding;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMyAppBarBinding = ActivityMyAppBarBinding.inflate(getLayoutInflater());
        setContentView(activityMyAppBarBinding.getRoot());

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(getString(R.string.my_app_bar));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_1){
            getSupportFragmentManager().
                    beginTransaction().replace(R.id.frame_container_two, new MenuAppBarFragment())
                    .addToBackStack(null).commit();
            return true;
        } else if (item.getItemId() == R.id.menu_2){
            intent = new Intent(this, MenuAppBarActivity.class);
            startActivity(intent);
            return true;
        } else {
            return true;
        }
    }
}