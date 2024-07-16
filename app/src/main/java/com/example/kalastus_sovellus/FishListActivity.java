package com.example.kalastus_sovellus;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class FishListActivity extends AppCompatActivity {
    private Storage storage;
    private RecyclerView recyclerView;
    private FishListAdapter adapter;
    private ArrayList<Fish> fishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recyclerview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        storage = Storage.getInstance();
        fishes = new ArrayList<>(storage.getFishes());

        recyclerView = findViewById(R.id.rvFishes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FishListAdapter(getApplicationContext(), fishes); // Initialize adapter with fishes list
        recyclerView.setAdapter(adapter);

        Button btnSortNewest = findViewById(R.id.btnSortByNewest);
        Button btnSortBiggest = findViewById(R.id.btnSortBySize);

        btnSortBiggest.setOnClickListener(v -> sortFishListByBiggest());
        btnSortNewest.setOnClickListener(v -> displayFishListByOrder());

    }


    private void displayFishListByOrder()   {

        fishes = new ArrayList<>(storage.getFishes());
        Collections.reverse(fishes);
        adapter.updateFishes(fishes);

    }

    public void sortFishListByBiggest()     {
        Collections.sort(fishes, new Comparator<Fish>() {
            @Override
            public int compare(Fish fish1, Fish fish2) {
                return Double.compare(fish2.getWeight(), fish1.getWeight());
            }
        });
        adapter.updateFishes(fishes);
    }



}