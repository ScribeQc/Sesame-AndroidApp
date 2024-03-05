package com.example.sesamefrontend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class CodeRecupFragment extends Fragment {

    EditText etEmail;
    View dividerEmail;
    public CodeRecupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_code_recup, container, false);

        etEmail = view.findViewById(R.id.etEmail);
        dividerEmail = view.findViewById(R.id.dividerEmail);

        etEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    dividerEmail.setBackgroundColor(getResources().getColor(R.color.orange));
                }else{
                    dividerEmail.setBackgroundColor(getResources().getColor(R.color.lightGray));
                }
            }
        });

        return view;
    }
}