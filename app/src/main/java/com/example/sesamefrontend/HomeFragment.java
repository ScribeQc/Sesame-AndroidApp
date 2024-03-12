package com.example.sesamefrontend;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sesamefrontend.classes.AdapterListHomePage;
import com.example.sesamefrontend.classes.Pet;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements AdapterListHomePage.InterfacePet {

    View view;
    RecyclerView rvHomePage;
    ImageView ibHomeLock;
    TextView tvMsg;
    boolean isLocked = true;
    public static List<Pet> listPet = new ArrayList<>();
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        if (listPet.size() > 0) {
            listPet.clear();
        }
        listPet.add(new Pet("Rex", "Rexou", "Chien", "ic_dog", "123456", true));
        listPet.add(new Pet("Mina", "Minou", "Chat", "ic_dog", "789456", false));
        Log.d("ListPet", listPet.toString());
        rvHomePage = view.findViewById(R.id.rvHomePage);
        rvHomePage.setHasFixedSize(true);
        rvHomePage.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        AdapterListHomePage adapterList = new AdapterListHomePage(listPet, this);
        rvHomePage.setAdapter(adapterList);

        ibHomeLock = view.findViewById(R.id.ibHomeLock);
        tvMsg = view.findViewById(R.id.tvMsg);

        ibHomeLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLocked) {
                    ibHomeLock.setImageResource(R.drawable.close);
                    tvMsg.setText("La porte est verrouillée");

                } else {
                    ibHomeLock.setImageResource(R.drawable.open);
                    tvMsg.setText("La porte est déverrouillée");
                }
                isLocked = !isLocked;
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void gestionClick(int position, Pet pet) {
        Toast.makeText(getContext(), "Click on " + pet.getName(), Toast.LENGTH_SHORT).show();
    }
}