package com.example.kalastus_sovellus;

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
















}
