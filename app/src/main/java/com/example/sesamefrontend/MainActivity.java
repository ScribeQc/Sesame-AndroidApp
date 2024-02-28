package com.example.sesamefrontend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import com.example.sesamefrontend.classes.AdapterListHomePage;
import com.example.sesamefrontend.classes.Pet;

import android.widget.LinearLayout;



public class MainActivity extends AppCompatActivity implements AdapterListHomePage.InterfacePet{

    ImageButton biHome;
    ImageButton biList;
    ImageButton biPets;
    ImageButton biSettings;
    ImageButton biSchedule;

    private LinearLayout linearLayout;



    List<Pet> list = new ArrayList<>();
    RecyclerView rvHomePage;

    //ActivityResultLauncher<Intent> laucher ;

    Context context;
    AdapterListHomePage adapterList;

    FragmentManager fragmentManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        //linearLayout.setVisibility(View.GONE);

        //ligne pour rendre visible la navBar
        //linearLayout.setVisibility(View.VISIBLE);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, new AccueilFragment())
                .commit();


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
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,new AccueilFragment());
            fragmentTransaction.addToBackStack(null); // Permet de revenir en arrière avec le bouton de retour
            fragmentTransaction.commit();

        }

        if (v.getId() == R.id.biList)
        {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,new ListFragment());
            fragmentTransaction.addToBackStack(null); // Permet de revenir en arrière avec le bouton de retour
            fragmentTransaction.commit();

        }

        if (v.getId() == R.id.biSettings)
        {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,new SettingFragment());
            fragmentTransaction.addToBackStack(null); // Permet de revenir en arrière avec le bouton de retour
            fragmentTransaction.commit();

        }

        if (v.getId() == R.id.biPets)
        {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,new PetsFragment());
            fragmentTransaction.addToBackStack(null); // Permet de revenir en arrière avec le bouton de retour
            fragmentTransaction.commit();

        }

        if (v.getId() == R.id.biSchedule)
        {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,new LockScheduleFragment());
            fragmentTransaction.addToBackStack(null); // Permet de revenir en arrière avec le bouton de retour
            fragmentTransaction.commit();
        }

        if (v.getId() == R.id.biAddSchedule)
        {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,new CreateScheduleFragment());
            fragmentTransaction.addToBackStack(null); // Permet de revenir en arrière avec le bouton de retour
            fragmentTransaction.commit();

        }

        if (v.getId() == R.id.ibAddPet)
        {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,new AddPetsFragment());
            fragmentTransaction.addToBackStack(null); // Permet de revenir en arrière avec le bouton de retour
            fragmentTransaction.commit();
        }

        if (v.getId() == R.id.bProfilSetting)
        {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout,new ProfilFragment());
            fragmentTransaction.addToBackStack(null); // Permet de revenir en arrière avec le bouton de retour
            fragmentTransaction.commit();
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