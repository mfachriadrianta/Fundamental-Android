package com.mfachriadrianta.fundamentalandroid.Navigation.FragmentNavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mfachriadrianta.fundamentalandroid.R;

public class CategoryFragmentNavigation extends Fragment {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_STOCK = "extra_stock";
    private Button buttoncategorylifestyle;

    public CategoryFragmentNavigation() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category_navigation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle bundle){
        super.onViewCreated(view, bundle);
        buttoncategorylifestyle = view.findViewById(R.id.button_category_lifestyle);
        buttoncategorylifestyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryFragmentNavigationDirections.ActionCategoryFragmentNavigationToDetailCategoryFragmentNavigation
                        toDetailCategoryFragment = CategoryFragmentNavigationDirections.actionCategoryFragmentNavigationToDetailCategoryFragmentNavigation();
                toDetailCategoryFragment.setName("Nike");
                toDetailCategoryFragment.setStock(7);
                Navigation.findNavController(view).navigate(toDetailCategoryFragment);

                // Menggunakan Bundle
//                Bundle bundletwo;
//                bundletwo = new Bundle();
//                bundletwo.putString(EXTRA_NAME, "Nike");
//                bundletwo.putInt(EXTRA_STOCK, 7);
//                Navigation.findNavController(view).navigate(R.id.action_categoryFragmentNavigation_to_detailCategoryFragmentNavigation, bundletwo);
            }
        });
    }
}