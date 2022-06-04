package com.unipi.mpardanhs.animals;

import com.unipi.mpardanhs.Animal;

public class Monkey extends Animal {
    private int bananasEatenToday;

    public Monkey(String name, String species, float maxWeight, int maxAge, String favoriteFood, int bananasEatenToday) {
        super(name, species, maxWeight, maxAge, favoriteFood);
        this.bananasEatenToday = bananasEatenToday;
    }

    public int getBananasEatenToday() {
        return bananasEatenToday;
    }

    public void setBananasEatenToday(int bananasEatenToday) {
        this.bananasEatenToday = bananasEatenToday;
    }

    @Override
    public void makeSound() {
        System.out.println("GIBBER GIBBER");
    }

    // Prosthetoyme sthn hdh yparxoysa toString ths klashs Animal ta extra xarakthristika ths maimoys
    @Override
    public String toString() {
        return super.toString() +
                "bananasEatenToday=" + bananasEatenToday +
                '}';
    }
}
