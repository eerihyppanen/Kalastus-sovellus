package com.example.kalastus_sovellus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        context = this;
    }

    public void fishAdd(View view)  {

        EditText editSpecies = findViewById(R.id.editSpecies);
        EditText editLake = findViewById(R.id.editLake);
        EditText editWeight = findViewById(R.id.editWeight);
        EditText editLength = findViewById(R.id.editLength);
        String species = editSpecies.getText().toString();
        String lake = editLake.getText().toString();
        String weightString = editWeight.getText().toString();
        String lengthString = editLength.getText().toString();

        double weight = Double.parseDouble(weightString);
        double length = Double.parseDouble(lengthString);


        RadioGroup rgDecisionTpe = findViewById(R.id.RGDecision);
        RadioButton selectedRadioButton = findViewById(rgDecisionTpe.getCheckedRadioButtonId());


        if (selectedRadioButton != null) {
            String decision = (String) selectedRadioButton.getTag();


            Fish fish = new Fish(weight, species, lake, length, decision);
            Storage.getInstance().addFish(fish);

        }

    }

    public void switchToListFishes(View view)    {
        Intent intent = new Intent(this, FishListActivity.class);
        startActivity(intent);
    }


}