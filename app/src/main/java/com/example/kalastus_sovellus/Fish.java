package com.example.kalastus_sovellus;

import java.io.Serializable;

public class Fish implements Serializable {
    double weight;
    String species;
    String lake;
    double length;
    String decision;

    public Fish(double weight, String species, String lake, double length, String decision) {
        this.weight = weight;
        this.species = species;
        this.lake = lake;
        this.length = length;
        this.decision = decision;

    }


    public double getWeight() {
        return weight;
    }

    public String getSpecies() {
        return species;
    }

    public String getLake() {
        return lake;
    }

    public double getLength() {
        return length;
    }

    public String getDecision() {
        return decision;
    }
}


