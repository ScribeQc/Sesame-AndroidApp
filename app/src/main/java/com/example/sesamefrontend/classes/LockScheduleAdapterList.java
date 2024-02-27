package com.example.sesamefrontend.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sesamefrontend.R;

import java.util.List;

public class LockScheduleAdapterList extends RecyclerView.Adapter<LockScheduleAdapterList.ViewHolder> {
    TextView tvDimanche, tvLundi, tvMardi, tvMercredi, tvJeudi, tvVendredi, tvSamedi;
    TextView tvStartTime, tvEndTime;
    public interface InterfaceLockSchedule {
        public void clickManager(int position, LockSchedule lockSchedule);
    }
    InterfaceLockSchedule interfaceLockSchedule;
    List<LockSchedule> listLockSchedule;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.lock_schedule_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        switch (listLockSchedule.get(position).getDayOfWeek()) {
            case "Dimanche":
                vh.tvDimanche.setText(listLockSchedule.get(position).getDayOfWeek());
                break;
            case "Lundi":
                vh.tvLundi.setText(listLockSchedule.get(position).getDayOfWeek());
                break;
            case "Mardi":
                vh.tvMardi.setText(listLockSchedule.get(position).getDayOfWeek());
                break;
            case "Mercredi":
                vh.tvMercredi.setText(listLockSchedule.get(position).getDayOfWeek());
                break;
            case "Jeudi":
                vh.tvJeudi.setText(listLockSchedule.get(position).getDayOfWeek());
                break;
            case "Vendredi":
                vh.tvVendredi.setText(listLockSchedule.get(position).getDayOfWeek());
                break;
            case "Samedi":
                vh.tvSamedi.setText(listLockSchedule.get(position).getDayOfWeek());
                break;
        }
        vh.tvStartTime.setText(listLockSchedule.get(position).getStartTime());
        vh.tvEndTime.setText(listLockSchedule.get(position).getEndTime());
    }

    @Override
    public int getItemCount() {
        return listLockSchedule.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDimanche, tvLundi, tvMardi, tvMercredi, tvJeudi, tvVendredi, tvSamedi;
        TextView tvStartTime, tvEndTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDimanche = itemView.findViewById(R.id.tvDimanche);
            tvLundi = itemView.findViewById(R.id.tvLundi);
            tvMardi = itemView.findViewById(R.id.tvMardi);
            tvMercredi = itemView.findViewById(R.id.tvMercredi);
            tvJeudi = itemView.findViewById(R.id.tvJeudi);
            tvVendredi = itemView.findViewById(R.id.tvVendredi);
            tvSamedi = itemView.findViewById(R.id.tvSamedi);
            tvStartTime = itemView.findViewById(R.id.tvStartTime);
            tvEndTime = itemView.findViewById(R.id.tvEndTime);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    interfaceLockSchedule.clickManager(getAdapterPosition(), listLockSchedule.get(getAdapterPosition()));
                }
            });
        }
    }
}
