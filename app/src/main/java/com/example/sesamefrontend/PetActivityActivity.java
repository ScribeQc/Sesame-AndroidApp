package com.example.sesamefrontend;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.sesamefrontend.classes.AdapterListActivity;
import com.example.sesamefrontend.classes.PetActivity;

import java.util.ArrayList;
import java.util.List;
//arnaud
public class PetActivityActivity extends AppCompatActivity implements AdapterListActivity.InterfacePetActivity {

    RecyclerView rvPetActivity;
    public static List<PetActivity> listPetActivity = new ArrayList<>();
    public static ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_activity);

        listPetActivity.add(new PetActivity(true, "12h34", "Aujourd'hui", "ic_dog"));
        listPetActivity.add(new PetActivity(false, "17h29", "Hier", "ic_dog"));
        listPetActivity.add(new PetActivity(true, "10h16", "Hier", "ic_dog"));
        listPetActivity.add(new PetActivity(false, "8h44", "Il y a 2 jours", "ic_dog"));
        listPetActivity.add(new PetActivity(true, "9h33", "Il y a 3 jours", "ic_dog"));
        listPetActivity.add(new PetActivity(true, "9h33", "Il y a 3 jours", "ic_dog"));

        rvPetActivity = findViewById(R.id.rvPetActivity);
        Context context = this;

        rvPetActivity.setHasFixedSize(true);
        rvPetActivity.setLayoutManager(new LinearLayoutManager(this));

        AdapterListActivity adapterList = new AdapterListActivity(listPetActivity, this);
        rvPetActivity.setAdapter(adapterList);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if(o.getResultCode() == RESULT_OK)
                        {
                            adapterList.notifyDataSetChanged();
                        }
                    }
                }
        );
    }

    @Override
    public void clickManager(int position, PetActivity petActivity) {
        Intent zoom = new Intent(this, CreateAccountActivity.class);
        zoom.putExtra("isInside", petActivity.isInOrOut());
        zoom.putExtra("date", petActivity.getDate());
        zoom.putExtra("time", petActivity.getTime());
        zoom.putExtra("pet", petActivity.getPet());
        launcher.launch(zoom);
    }
}
