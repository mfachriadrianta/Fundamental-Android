package com.mfachriadrianta.fundamentalandroid.General.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mfachriadrianta.fundamentalandroid.General.ProfileActivity;
import com.mfachriadrianta.fundamentalandroid.R;

public class DetailCategoryFragment extends Fragment {

    private TextView textviewcategoryname, textviewcategorydescription;
    private Button buttonprofile, buttonshowdialog;
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DESCRIPTION = "extra_description";
    private String description;
    private Intent intent;

    public DetailCategoryFragment() {
        // Required empty public constructor
    }

    private String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle){
        super.onViewCreated(view, bundle);
        textviewcategoryname = view.findViewById(R.id.textview_category_name);
        textviewcategorydescription = view.findViewById(R.id.textview_category_description);
        buttonprofile = view.findViewById(R.id.button_profile);
        buttonshowdialog = view.findViewById(R.id.button_show_dialog);

        buttonprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        buttonshowdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OptionDialogFragment optionDialogFragment = new OptionDialogFragment();
                FragmentManager fragmentManager = getChildFragmentManager();
                optionDialogFragment.show(fragmentManager, OptionDialogFragment.class.getSimpleName());
            }
        });

        if (bundle != null){
            String descFromBundle = bundle.getString(EXTRA_DESCRIPTION);
            setDescription(descFromBundle);
        }

        if (getArguments() != null){
            String categoryName = getArguments().getString(EXTRA_NAME);
            textviewcategoryname.setText(categoryName);
            textviewcategorydescription.setText(getDescription());
        }

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle bundle){
        super.onSaveInstanceState(bundle);
        bundle.putString(EXTRA_DESCRIPTION, getDescription());
    }

    public final OptionDialogFragment.OnOptionDialogListener optionDialogListener = new OptionDialogFragment.OnOptionDialogListener() {
        @Override
        public void onOptionChoosen(String s) {
            Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
        }
    };

}