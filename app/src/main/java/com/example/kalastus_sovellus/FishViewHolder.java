package com.example.kalastus_sovellus;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FishViewHolder extends RecyclerView.ViewHolder {

    TextView species, lake, weight, length, decision;
    public FishViewHolder(@NonNull View itemView) {
        super(itemView);

        species = itemView.findViewById(R.id.txtSpecies);
        lake = itemView.findViewById(R.id.txtLake);
        weight = itemView.findViewById(R.id.txtWeight);
        length = itemView.findViewById(R.id.txtLength);
        decision = itemView.findViewById(R.id.txtDecision);

    }

}
