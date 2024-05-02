package com.mfachriadrianta.fundamentalandroid.Navigation.AppBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.mfachriadrianta.fundamentalandroid.R;
import com.mfachriadrianta.fundamentalandroid.databinding.ActivityMenuAppBarBinding;

public class MenuAppBarActivity extends AppCompatActivity {

    private ActivityMenuAppBarBinding activityMenuAppBarBinding;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMenuAppBarBinding = ActivityMenuAppBarBinding.inflate(getLayoutInflater());
        setContentView(activityMenuAppBarBinding.getRoot());

//        with(binding) {
//            searchView.setupWithSearchBar(searchBar)
//            searchView
//                    .editText
//                    .setOnEditorActionListener { textView, actionId, event ->
//                    searchBar.text = searchView.text
//                searchView.hide()
//                Toast.makeText(this@MenuActivity, searchView.text, Toast.LENGTH_SHORT).show()
//                false
//            }
//        }
    }


}