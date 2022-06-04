package com.unipi.mpardanhs.animals;

import com.unipi.mpardanhs.Animal;

public class Chicken extends Animal {
    private int eggsLayedToday;
    @Override
    public void makeSound() {
        System.out.println("CLUCK CLUCK");
    }

    public Chicken(String name, String species, float maxWeight, int maxAge, String favoriteFood, int eggsLayedToday) {
        super(name, species, maxWeight, maxAge, favoriteFood);
        this.eggsLayedToday = eggsLayedToday;
    }

    public int getEggsLayedToday() {
        return eggsLayedToday;
    }

    public void setEggsLayedToday(int eggsLayedToday) {
        this.eggsLayedToday = eggsLayedToday;
    }

    // Prosthetoyme sthn hdh yparxoysa toString ths klashs Animal ta extra xarakthristika ths kotas
    @Override
    public String toString() {
        return super.toString() +
                "eggsLayedToday=" + eggsLayedToday +
                '}';
    }
}
