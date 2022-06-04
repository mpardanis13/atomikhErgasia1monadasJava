package com.unipi.mpardanhs.animals;

import com.unipi.mpardanhs.Animal;

public class Penguin extends Animal {
    private int fishEatenToday;
    @Override
    public void makeSound() {
        System.out.println("HONK HONK");
    }

    public Penguin(String name, String species, float maxWeight, int maxAge, String favoriteFood, int fishEatenToday) {
        super(name, species, maxWeight, maxAge, favoriteFood);
        this.fishEatenToday = fishEatenToday;
    }

    public int getFishEatenToday() {
        return fishEatenToday;
    }

    // Prosthetoyme sthn hdh yparxoysa toString ths klashs Animal ta extra xarakthristika toy pigkoyinoy
    @Override
    public String toString() {
        return super.toString() +
                "fishEatenToday=" + fishEatenToday +
                '}';
    }

    public void setFishEatenToday(int fishEatenToday) {
        this.fishEatenToday = fishEatenToday;
    }
}
