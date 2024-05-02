package com.mfachriadrianta.fundamentalandroid.General.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mfachriadrianta.fundamentalandroid.R;

public class OptionDialogFragment extends DialogFragment {

    private RadioGroup radiogroupoptions;
    private RadioButton radiobuttonsaf, radiobuttonmou, radiobuttonlvg, radiobuttonmoyes;
    private Button buttonclose, buttonchoose;
    private OnOptionDialogListener optionDialogListener;

    public OptionDialogFragment(){}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }

    // Menginisialisasi variabel dari fragment menuju XML Fragment
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle){
        super.onViewCreated(view, bundle);
        radiogroupoptions = view.findViewById(R.id.radiogroup_options);
        radiobuttonsaf = view.findViewById(R.id.radiobutton_saf);
        radiobuttonmou = view.findViewById(R.id.radiobutton_mou);
        radiobuttonlvg = view.findViewById(R.id.radiobutton_lvg);
        radiobuttonmoyes = view.findViewById(R.id.radiobutton_moyes);
        buttonchoose = view.findViewById(R.id.button_choose);
        buttonclose = view.findViewById(R.id.button_close);

        buttonchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            int integerCheckedRadioButtonId = radiogroupoptions.getCheckedRadioButtonId();
            if (integerCheckedRadioButtonId != 1 ){
            String choicecoach = null;
            if (integerCheckedRadioButtonId == R.id.radiobutton_saf){
                choicecoach = radiobuttonsaf.getText().toString().trim();
            } else if (integerCheckedRadioButtonId == R.id.radiobutton_mou){
                choicecoach = radiobuttonmou.getText().toString().trim();
            } else if (integerCheckedRadioButtonId == R.id.radiobutton_lvg){
                choicecoach = radiobuttonlvg.getText().toString().trim();
            } else if (integerCheckedRadioButtonId == R.id.radiobutton_moyes){
                choicecoach = radiobuttonmoyes.getText().toString().trim();
            }
            if (optionDialogListener != null){
                optionDialogListener.onOptionChoosen(choicecoach);
            }
            getDialog().dismiss();
        }
            }
        });

        buttonclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().cancel();
            }
        });
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        Fragment fragment = getParentFragment();
        if (fragment instanceof DetailCategoryFragment){
            DetailCategoryFragment detailCategoryFragment = (DetailCategoryFragment) fragment;
            this.optionDialogListener = detailCategoryFragment.optionDialogListener;
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        this.optionDialogListener = null;
    }

    // Membuat class/kelas antarmuka dari OnOptionDialogListener
    public interface OnOptionDialogListener {
        void onOptionChoosen(String s);
    }
}