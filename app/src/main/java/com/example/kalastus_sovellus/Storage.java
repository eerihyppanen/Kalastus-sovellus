package com.example.kalastus_sovellus;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {

    private ArrayList<Fish> fishes = new ArrayList<>();


    public static Storage storage = null;

    public static Storage getInstance(){
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void addFish(Fish fish){
        fishes.add(fish);
    }

    public ArrayList<Fish> getFishes(){
        return fishes;

    }


    public void saveFishes(Context context)  {
        try {
            try {
                ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("fishes.data", Context.MODE_PRIVATE));
                userWriter.writeObject(fishes);
                userWriter.close();
            } catch (IOException e) {
                System.out.println("virhe kirjoittaessa tiedostoa");
                e.printStackTrace();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }


    }

    public void loadFishes(Context context)  {
        try {
            try {
                ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("fishes.data"));
                fishes = (ArrayList<Fish>) userReader.readObject();
                userReader.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("ei tiedostoja");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }















}
