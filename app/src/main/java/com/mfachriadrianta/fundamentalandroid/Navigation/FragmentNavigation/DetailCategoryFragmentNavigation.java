package com.mfachriadrianta.fundamentalandroid.Navigation.FragmentNavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mfachriadrianta.fundamentalandroid.R;

public class DetailCategoryFragmentNavigation extends Fragment {

    private TextView textviewcategorynametwo, textviewcategorydescriptiontwo;
    private Button buttonbacknavigation;

    public DetailCategoryFragmentNavigation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category_navigation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle bundle){
        super.onViewCreated(view, bundle);
        textviewcategorynametwo = view.findViewById(R.id.textview_category_name_two);
        textviewcategorydescriptiontwo = view.findViewById(R.id.textview_category_description_two);
        buttonbacknavigation = view.findViewById(R.id.button_back_navigation);
        String getDataName;
        Long getDataStock;

        // Use method SafeArgs
        getDataName = DetailCategoryFragmentNavigationArgs.fromBundle(getArguments()).getName();
        getDataStock =DetailCategoryFragmentNavigationArgs.fromBundle(getArguments()).getStock();

        textviewcategorynametwo.setText(getDataName);
        textviewcategorydescriptiontwo.setText(String.valueOf(getDataStock));

        // Menggunakan Bundle
//        getDataName = getArguments().getString(CategoryFragmentNavigation.EXTRA_NAME);
//        getDataStock = getArguments().getInt(CategoryFragmentNavigation.EXTRA_STOCK);

//        textviewcategorynametwo.setText("Product Name: " + getDataName);
//        textviewcategorydescriptiontwo.setText("Stock: " + getDataStock);

        buttonbacknavigation.setOnClickListener(
                Navigation.createNavigateOnClickListener
                        (R.id.action_detailCategoryFragmentNavigation_to_homeFragmentNavigation, null));
    }
}