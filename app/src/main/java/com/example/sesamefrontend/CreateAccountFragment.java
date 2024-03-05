package com.example.sesamefrontend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CreateAccountFragment extends Fragment {

    View view;
    TextView etFirstName;
    TextView etLastName;
    TextView etEmail;
    TextView etPhone;
    TextView etMdp;
    View dividerFirstName;
    View dividerLastName;
    View dividerEmail;
    View dividerPhone;
    View dividerMdp;
    public CreateAccountFragment() {
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
        view = inflater.inflate(R.layout.fragment_create_account, container, false);

        etFirstName = view.findViewById(R.id.etFirstName);
        etLastName = view.findViewById(R.id.etLastName);
        etEmail = view.findViewById(R.id.etEmail);
        etPhone = view.findViewById(R.id.etPhone);
        etMdp = view.findViewById(R.id.etMdp);
        dividerFirstName = view.findViewById(R.id.dividerFirstName);
        dividerLastName = view.findViewById(R.id.dividerLastName);
        dividerEmail = view.findViewById(R.id.dividerEmail);
        dividerPhone = view.findViewById(R.id.dividerPhone);
        dividerMdp = view.findViewById(R.id.dividerMdp);

        etEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // Le EditText a le focus, changer la couleur du textHint
                    dividerEmail.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    // Le EditText n'a pas le focus, changer la couleur du textHint à sa couleur d'origine
                    dividerEmail.setBackgroundColor(getResources().getColor(R.color.lightGray));
                }
            }
        });
        etLastName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // Le EditText a le focus, changer la couleur du textHint
                    dividerLastName.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    // Le EditText n'a pas le focus, changer la couleur du textHint à sa couleur d'origine
                    dividerLastName.setBackgroundColor(getResources().getColor(R.color.lightGray));
                }
            }
        });
        etFirstName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // Le EditText a le focus, changer la couleur du textHint
                    dividerFirstName.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    // Le EditText n'a pas le focus, changer la couleur du textHint à sa couleur d'origine
                    dividerFirstName.setBackgroundColor(getResources().getColor(R.color.lightGray));
                }
            }
        });
        etMdp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // Le EditText a le focus, changer la couleur du textHint
                    dividerMdp.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    // Le EditText n'a pas le focus, changer la couleur du textHint à sa couleur d'origine
                    dividerMdp.setBackgroundColor(getResources().getColor(R.color.lightGray));
                }
            }
        });
        etPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // Le EditText a le focus, changer la couleur du textHint
                    dividerPhone.setBackgroundColor(getResources().getColor(R.color.orange));
                } else {
                    // Le EditText n'a pas le focus, changer la couleur du textHint à sa couleur d'origine
                    dividerPhone.setBackgroundColor(getResources().getColor(R.color.lightGray));
                }
            }
        });

        return view;
    }
}