package com.unipi.mpardanhs.animals;

import com.unipi.mpardanhs.Animal;

public class Lion extends Animal {
    private float teethSize;

    @Override
    public void makeSound() {
        System.out.println("ROARRR!");
    }

    public Lion(String name, String species, float maxWeight, int maxAge, String favoriteFood, float teethSize) {
        super(name, species, maxWeight, maxAge, favoriteFood);
        this.teethSize = teethSize;
    }

    public float getTeethSize() {
        return teethSize;
    }

    public void setTeethSize(float teethSize) {
        this.teethSize = teethSize;
    }

    // Prosthetoyme sthn hdh yparxoysa toString ths klashs Animal ta extra xarakthristika toy liontarioy
    @Override
    public String toString() {
        return super.toString() +
                "teethSize=" + teethSize +
                '}';
    }
}
