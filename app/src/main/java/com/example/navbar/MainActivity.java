package com.example.navbar;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import classes.AdapterList;
import classes.Pet;

public class MainActivity extends AppCompatActivity implements AdapterList.InterfacePet{

    ImageButton biHome;
    ImageButton biList;
    ImageButton biPets;
    ImageButton biSettings;



    List<Pet> list = new ArrayList<>();
    RecyclerView rvHomePage;

    //ActivityResultLauncher<Intent> laucher ;

    Context context;
    AdapterList adapterList;

    FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

    // gestion fragment

        biHome = findViewById(R.id.biHome);
        biList = findViewById(R.id.biList);
        biPets = findViewById(R.id.biPets);
        biSettings = findViewById(R.id.biSettings);

        



    // gestion recycle view dog+statut home page
        /*rvHomePage = findViewById(R.id.rvHomePage);
        rvHomePage.setHasFixedSize(true);
        rvHomePage.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        adapterList = new AdapterList(list, this);*/


        list.add(new Pet("Princess", "Beubé", "Chien", "", "", true));
        list.add(new Pet("Bryson", "King", "Chien", "", "", false));

        //rvHomePage.setAdapter(adapterList);

    }
    public void replaceFragment(View v) {

        if (v.getId() == R.id.biHome)
        {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTrasaction = fragmentManager.beginTransaction();
            fragmentTrasaction.replace(R.id.frameLayout,new AccueilFragment());
            fragmentTrasaction.commit();
        }

        if (v.getId() == R.id.biList)
        {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTrasaction = fragmentManager.beginTransaction();
            fragmentTrasaction.replace(R.id.frameLayout,new ListFragment());
            fragmentTrasaction.commit();
        }

        if (v.getId() == R.id.biSettings)
        {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTrasaction = fragmentManager.beginTransaction();
            fragmentTrasaction.replace(R.id.frameLayout,new SettingFragment());
            fragmentTrasaction.commit();
        }

        if (v.getId() == R.id.biPets)
        {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTrasaction = fragmentManager.beginTransaction();
            fragmentTrasaction.replace(R.id.frameLayout,new PetsFragment());
            fragmentTrasaction.commit();
        }

        if (v.getId() == R.id.bProfilSetting)
        {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTrasaction = fragmentManager.beginTransaction();
            fragmentTrasaction.replace(R.id.frameLayout,new ProfilFragment());
            fragmentTrasaction.commit();
        }

    }
    @Override
    public void gestionClick(int position, Pet pet) {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}