package com.example.sesamefrontend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class PasswordRecupFragment extends Fragment {

    EditText etMdp, etMdpConfirm;
    View dividerMdp, dividerMdpConfirm;
    public PasswordRecupFragment() {
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
        View view = inflater.inflate(R.layout.fragment_password_recup, container, false);

        etMdp = view.findViewById(R.id.etMdp);
        etMdpConfirm = view.findViewById(R.id.etMdpConfirm);
        dividerMdp = view.findViewById(R.id.dividerMdp);
        dividerMdpConfirm = view.findViewById(R.id.dividerMdpConfirm);

        etMdp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    dividerMdp.setBackgroundColor(getResources().getColor(R.color.orange));
                }else{
                    dividerMdp.setBackgroundColor(getResources().getColor(R.color.lightGray));
                }
            }
        });

        etMdpConfirm.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    dividerMdpConfirm.setBackgroundColor(getResources().getColor(R.color.orange));
                }else{
                    dividerMdpConfirm.setBackgroundColor(getResources().getColor(R.color.lightGray));
                }
            }
        });

        return view;
    }
}