package com.unipi.mpardanhs.animals;

import com.unipi.mpardanhs.Animal;

public class Shark extends Animal {
    private int numberOfTeeth;

    public Shark(String name, String species, float maxWeight, int maxAge, String favoriteFood, int numberOfTeeth) {
        super(name, species, maxWeight, maxAge, favoriteFood);
        this.numberOfTeeth = numberOfTeeth;
    }

    public int getNumberOfTeeth() {
        return numberOfTeeth;
    }

    public void setNumberOfTeeth(int numberOfTeeth) {
        this.numberOfTeeth = numberOfTeeth;
    }

    @Override
    public void makeSound() {
        System.out.println("....");
    }

    // Prosthetoyme sthn hdh yparxoysa toString ths klashs Animal ta extra xarakthristika toy arxarxia
    @Override
    public String toString() {
        return super.toString() +
                "numberOfTeeth=" + numberOfTeeth +
                '}';
    }
}
