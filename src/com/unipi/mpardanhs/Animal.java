package com.unipi.mpardanhs;

import java.io.Serializable;
import java.util.UUID;

public abstract class Animal implements IMakeSound, Serializable {
    private final UUID uuid=UUID.randomUUID(); // Xrhsimopoioyme ws kwdiko ena stathero uuid
    private String name;
    private String species;
    private float maxWeight;
    private float maxAge;
    private String favoriteFood;

    public Animal(){}

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public float getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public Animal( String name, String species, float maxWeight, int maxAge, String favoriteFood) {
        this.name = name;
        this.species = species;
        this.maxWeight = maxWeight;
        this.maxAge = maxAge;
        this.favoriteFood = favoriteFood;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" {" +
                "id='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", maxWeight=" + maxWeight +
                ", maxAge=" + maxAge +
                ", favoriteFood='" + favoriteFood + '\'' +
                ", ";
    }

}
