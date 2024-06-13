package com.example.kalastus_sovellus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FishListAdapter extends RecyclerView.Adapter<FishViewHolder> {

    private Context context;
    private ArrayList<Fish> fishes = new ArrayList<>();

    public FishListAdapter(Context context, ArrayList<Fish> fishes) {
        this.context = context;
        this.fishes = fishes;
    }

    @NonNull
    @Override
    public FishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FishViewHolder(LayoutInflater.from(context).inflate(R.layout.fish_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FishViewHolder holder, int position) {
        holder.species.setText(fishes.get(position).getSpecies());
        holder.lake.setText(fishes.get(position).getLake());
        holder.weight.setText(String.valueOf(fishes.get(position).getWeight()));
        holder.length.setText(String.valueOf(fishes.get(position).getLength()));
        holder.decision.setText(fishes.get(position).getDecision());




    }

    @Override
    public int getItemCount() {
        return fishes.size();
    }
}
