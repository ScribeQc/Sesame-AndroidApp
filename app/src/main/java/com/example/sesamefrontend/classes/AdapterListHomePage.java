package com.example.sesamefrontend.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sesamefrontend.R;

import java.util.List;

public class AdapterListHomePage extends RecyclerView.Adapter{



    public interface InterfacePet{
        public void gestionClick(int position, Pet pet);
    }

    InterfacePet interfacePet;
    List<Pet> list;

    public AdapterListHomePage(List<Pet> list, InterfacePet interfacePet)
    {
        this.list = list;
        this.interfacePet = interfacePet;
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.home_pet_layout,parent,false);
        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Pet p = list.get(position);
        MonViewHolder monViewHolder = (MonViewHolder) holder;
        monViewHolder.tvStatus.setText(p.getStatus() ? R.string.Inside : R.string.Outside);

        //string Img Pet
        //monViewHolder.ibPet.setImageResource(p.getImg().toString());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public void ajouterPet(Pet pet)
    {
        list.add(pet);
        notifyItemInserted(list.size() - 1);
    }
    public void supprimerPet(int position)
    {
        list.remove(position);
        notifyItemRemoved(position);
    }

    public class MonViewHolder extends RecyclerView.ViewHolder{

        TextView tvStatus;
        ImageButton ibPet;

        public MonViewHolder(@NonNull View itemView) {
            super(itemView);

            tvStatus = itemView.findViewById(R.id.tvStatus);
            /*ibPet = itemView.findViewById(R.id.ivPetPhoto);


            ibPet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    interfacePet.gestionClick(getLayoutPosition(), list.get(getLayoutPosition()));

                }
            });*/

            tvStatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    interfacePet.gestionClick(getLayoutPosition(), list.get(getLayoutPosition()));

                }
            });
        }
    }
}
