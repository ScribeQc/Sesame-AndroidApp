package com.example.sesamefrontend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class LoginFragment extends Fragment {

    View view;
    Button btLogin;
    EditText etEmail;
    EditText etMdp;
    View dividerEmail;
    View dividerMdp;

    public LoginFragment() {
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
        view = inflater.inflate(R.layout.fragment_login, container, false);


        btLogin = view.findViewById(R.id.btLogin);
        etEmail = view.findViewById(R.id.etEmail);
        etMdp = view.findViewById(R.id.etMdp);
        dividerEmail = view.findViewById(R.id.dividerEmail);
        dividerMdp = view.findViewById(R.id.dividerMdp);

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

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remplacer le fragment actuel par un nouveau fragment
                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, new HomeFragment());
                fragmentTransaction.addToBackStack(null); // Permet de revenir en arrière avec le bouton de retour

                fragmentTransaction.commit();
            }
        });
        return view;
    }


}