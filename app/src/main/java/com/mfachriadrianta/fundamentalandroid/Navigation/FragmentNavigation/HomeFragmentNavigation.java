package com.mfachriadrianta.fundamentalandroid.Navigation.FragmentNavigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mfachriadrianta.fundamentalandroid.Navigation.AppBar.MyAppBarActivity;
import com.mfachriadrianta.fundamentalandroid.Navigation.Bottom.MyBottomNavigationActivity;
import com.mfachriadrianta.fundamentalandroid.Navigation.Drawer.ui.MyNavigationDrawerActivity;
import com.mfachriadrianta.fundamentalandroid.R;

public class HomeFragmentNavigation extends Fragment {

    private Button buttoncategorynavigation, buttonprofilenaigation,
                    buttontomyappbar, buttonmynavigationdrawer, buttonmybottomnavigation;
    private Intent intent;

    public HomeFragmentNavigation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_navigation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle){
        super.onViewCreated(view, bundle);
        buttoncategorynavigation = view.findViewById(R.id.button_category_navigation);
        buttonprofilenaigation = view.findViewById(R.id.button_profile_navigation);
        buttontomyappbar = view.findViewById(R.id.button_to_myappbar);
        buttonmynavigationdrawer = view.findViewById(R.id.button_mynavigationdrawer);
        buttonmybottomnavigation = view.findViewById(R.id.button_mybottomnavigation);

        // Use for between fragment and not for activity
        // Tidak perlu menggunakan .setOnClickListener(new View.OnClickListener) untuk memanggil aksi
        buttoncategorynavigation.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_homeFragmentNavigation_to_categoryFragmentNavigation)
        );

        // Use for between fragment and not for activity
        // Menggunakan Navigation.findNavController untuk memanggil aksi yang bertujuan ke activity
        buttonprofilenaigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragmentNavigation_to_profileActivity);
            }
        });

        buttontomyappbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), MyAppBarActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        buttonmynavigationdrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), MyNavigationDrawerActivity.class);
                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        buttonmybottomnavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), MyBottomNavigationActivity.class);
                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

    }
}