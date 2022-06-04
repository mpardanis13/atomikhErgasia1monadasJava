package com.unipi.mpardanhs;

import com.unipi.mpardanhs.animals.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Zoo {
    protected String name;
    private String address;

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    protected ArrayList<Animal> animals; // ArrayList poy periexei ola ta zwa poy yparxoyn ston khpo

    // Constructor zwologikoy khpoy
    public Zoo(String name, String address) {
        this.name = name;
        this.address = address;
        animals = new ArrayList<Animal>();
    }

    // Prosthikh zwoy sth lista
    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void provolhDiathesimwnZwwn(){
        int i = 1;
        for(Animal a: animals) {System.out.println( i + ". " + a);i++;}

    }

    // Methodos gia prosthikh zwoy apo ton xrhsth
    public void  prosthikiNeoyZwoy(){
        byte res;
        do {
            System.out.println();
            System.out.println();
            System.out.println("1. Liontari.");
            System.out.println("2. Pingkoyinos.");
            System.out.println("3. Maimoy.");
            System.out.println("4. Karxarias.");
            System.out.println("5. Kota.");
            System.out.println("Dialekste to zwo poy thelete na eisagete ston zwologiko khpo: ");
            Scanner s2 = new Scanner(System.in);
            res = s2.nextByte();
        }while(res < 1 || res > 5);

        Scanner s = new Scanner(System.in);
        System.out.println("Dwste to onoma toy zwoy: ");
        String name = s.next();
        System.out.println("Dwste thn omotaksia toy zwoy: ");
        String species = s.next();
        System.out.println("Dwste to megisto baros toy zwoy: ");
        float maxWeight = s.nextFloat();
        System.out.println("Dwste to megisth hlikia toy zwoy: ");
        int maxAge = s.nextInt();
        System.out.println("Dwste to agaphmeno faghto toy zwoy: ");
        String favFood = s.next();

        // Analoga me to eidos toy zwoy dexomaste kai to antistoixw attribute
        switch (res) {
            case 1 -> {
                System.out.println("Dwste to megethos twn dontiwn toy liontarioy.");
                int dontiaMhkos = s.nextInt();
                addAnimal(new Lion(name, species, maxWeight, maxAge, favFood, dontiaMhkos));
            }
            case 2 -> {
                System.out.println("Dwste ta psaria poy exei faei shmera o pingkoyinos.");
                int psaria = s.nextInt();
                addAnimal(new Penguin(name, species, maxWeight, maxAge, favFood, psaria));
            }
            case 3 -> {
                System.out.println("Dwste tis bananes poy exei faei shmera h maimoy.");
                int bananes = s.nextInt();
                addAnimal(new Monkey(name, species, maxWeight, maxAge, favFood, bananes));
            }
            case 4 -> {
                System.out.println("Dwste ton arithmo twn dontiwn poy exei o karxarias.");
                int dontia = s.nextInt();
                addAnimal(new Shark(name, species, maxWeight, maxAge, favFood, dontia));
            }
            case 5 -> {
                System.out.println("Dwste ton arithmo twn aygwn poy exei exei kanei shmera h kota.");
                int ayga = s.nextInt();
                addAnimal(new Chicken(name, species, maxWeight, maxAge, favFood, ayga));
            }
        }
    }

    public void anazhthshBaseiOnomatos(String onoma){
        boolean found = false;
        for(Animal a : animals){
            if (Objects.equals(a.getName(), onoma)) {
                System.out.println("Brethike: "+ a);
                found = true;
            }
        }
        if(!found)System.out.println("Den brethike zwo me ayto to onoma ston zwologiko khpo!");
    }

    public Animal anazhthshBaseiKwdikoy(String uuid){
        for(Animal a : animals){
            if (Objects.equals(a.getUuid().toString(),uuid)) {
                return a;
            }
        }
        return null;
    }

    public void epeksergasiaZwoy(){
        provolhDiathesimwnZwwn();
        String res;
        Animal found;
        Scanner s = new Scanner(System.in);
        for(;;){
        do {
            System.out.println("Dwste ton kwdiko toy zwoy poy thelete na epeksergasteite (0 gia telos epeksergasias.): ");
            res = s.next();
            found = anazhthshBaseiKwdikoy(res);
        }while (found == null && !res.equals("0"));

        if (!res.equals("0")){
                System.out.println("Dwste thn epithymiti timh diaforetika pathste '000' gia na pate sto epomeno pedio: ");

                System.out.println("Onoma: ");
                String name = s.next();
                if (!name.equals("000"))found.setName(name);

                System.out.println("Omotaksia: ");
                String species = s.next();
                if (!species.equals("000"))found.setSpecies(species);

                System.out.println("Megisto Baros: ");
                String maxWeight = s.next();
                if (!maxWeight.equals("000"))found.setMaxWeight(Float.parseFloat(maxWeight));

                System.out.println("Megisth hlikia: ");
                String maxAge = s.next();
                if (!maxAge.equals("000"))found.setMaxAge(Integer.parseInt(maxAge));

                System.out.println("Agaphmeno Faghto: ");
                String favFood = s.next();
                if (!favFood.equals("000"))found.setFavoriteFood(favFood);

            // Elegxoyme to eidos toy zwoy wste na epeksergastoyme ta diaforetika pedia
            switch (found.getClass().getSimpleName()) {
                case "Lion" -> {
                    Lion lion = (Lion) found;
                    System.out.println("Megethos dontiwn: ");
                    String teethSize = s.next();
                    if (!teethSize.equals("000")) lion.setTeethSize(Float.parseFloat(teethSize));
                }
                case "Penguin" -> {
                    Penguin penguin = (Penguin) found;
                    System.out.println("Megethos dontiwn: ");
                    String fishEatenToday = s.next();
                    if (!fishEatenToday.equals("000")) penguin.setFishEatenToday(Integer.parseInt(fishEatenToday));
                }
                case "Shark" -> {
                    Shark shark = (Shark) found;
                    System.out.println("Arithmos dontiwn: ");
                    String numberOfTeeth = s.next();
                    if (!numberOfTeeth.equals("000")) shark.setNumberOfTeeth(Integer.parseInt(numberOfTeeth));
                }
                case "Monkey" -> {
                    Monkey monkey = (Monkey) found;
                    System.out.println("Bananes poy egage shmera: ");
                    String bananasEatenToday = s.next();
                    if (!bananasEatenToday.equals("000"))
                        monkey.setBananasEatenToday(Integer.parseInt(bananasEatenToday));
                }
                case "Chicken" -> {
                    Chicken chicken = (Chicken) found;
                    System.out.println("Arithmos aygwn poy ekane shmera: ");
                    String eggsLayedToday = s.next();
                    if (!eggsLayedToday.equals("000")) chicken.setEggsLayedToday(Integer.parseInt(eggsLayedToday));
                }
            }
            System.out.println("Epeksergasia epityxhs!");
            System.out.println();

        }else {
            System.out.println("Telos epeksergasias!");
            break;
        }
    }}
    public void diagrafhZwoyBaseiKwdikoy(Animal a){
        if (a == null){
            System.out.println("Den yparxei zwo me ayton ton kwdiko..");
        }else{
            System.out.println("Diagrafh toy zwoy: " + a);
            animals.remove(a);
        }
    }
}
