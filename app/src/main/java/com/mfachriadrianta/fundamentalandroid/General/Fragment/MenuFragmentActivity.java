package com.mfachriadrianta.fundamentalandroid.General.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.mfachriadrianta.fundamentalandroid.R;
import com.mfachriadrianta.fundamentalandroid.databinding.ActivityMenuFragmentBinding;

public class MenuFragmentActivity extends AppCompatActivity {

    private ActivityMenuFragmentBinding activityMenuFragmentBinding;
    private HomeFragment homeFragment = new HomeFragment();
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMenuFragmentBinding = ActivityMenuFragmentBinding.inflate(getLayoutInflater());
        setContentView(activityMenuFragmentBinding.getRoot());

        if (!(getSupportActionBar() == null)){
            getSupportActionBar().setTitle(getString(R.string.my_flexible_fragment));
        }

        if (!(fragment instanceof HomeFragment)){
            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment.class.getSimpleName());
            fragmentManager.beginTransaction().add(R.id.frame_container, homeFragment, HomeFragment.class.getSimpleName()).commit();
        }
    }
}