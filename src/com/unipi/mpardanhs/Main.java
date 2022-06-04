package com.unipi.mpardanhs;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Dhmioyrgoyme ton zwologiko mas khpo kai arxikopoioyme ta pedia toy meso toy constructor
        Zoo attikoZwologikoParko = new Zoo("Attiko Zwologiko Parko", "At Yalou Spata, Athina 190 04");

        // Diabasma zwwn apo to arxeio animals.txt mesw deserialization
        try {
            FileInputStream fis = new FileInputStream("animals.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            attikoZwologikoParko.setAnimals((ArrayList<Animal>)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Arxh toy programmatos
        System.out.println("Kalwsorisate sto "+ attikoZwologikoParko.name+" !");

        // Xrhsimopoioyme enan atermwn broxo for gia thn emfanish toy menu epilogwn sto xrhsth
        loop: for(;;){
            byte res;
            Scanner s = new Scanner(System.in);
            do {
                System.out.println();
                System.out.println();
                System.out.println("1. Probolh olwn ton diathesimwn zwwn toy zwologikoy mas khpoy.");
                System.out.println("2. Prosthiki neoy zwoy.");
                System.out.println("3. Anazhthsh zwoy basei onomatos.");
                System.out.println("4. Anazhthsh zwoy basei kwdikoy.");
                System.out.println("5. Epeksergasia zwoy basei kwdikoy.");
                System.out.println("6. Diagrafh zwoy basei kwdikoy.");
                System.out.println("7. Eksodos apo thn efarmogh.");
                System.out.print("Dialekste mia apo tis parapanw epiloges: ");
                System.out.println();
                System.out.println();
                res = s.nextByte(); // Epilogh diadikasias apo ton xrhsth
            }while (res < 1 || res > 7);
            switch (res){
                // Analoga me thn epilogh toy xrhsth kaloyme kai thn katallhlh methodo toy zwologikoy khpoy
                case 1:
                    attikoZwologikoParko.provolhDiathesimwnZwwn();
                    break;
                case 2:
                    attikoZwologikoParko.prosthikiNeoyZwoy();
                    break;
                case 3:
                    System.out.println("Dwste to onoma toy zwoy pros anazhthsh: ");
                    attikoZwologikoParko.anazhthshBaseiOnomatos(s.next());
                    break;
                case 4:
                    System.out.println("Dwste to kwdiko toy zwoy pros anazhthsh: ");
                    Animal zwo = attikoZwologikoParko.anazhthshBaseiKwdikoy(s.next());
                    if(zwo != null)System.out.println("Brethike: "+ zwo);
                    else         System.out.println("Den brethike zwo me ayto to kwdiko ston zwologiko khpo!");

                    break;
                case 5:
                    attikoZwologikoParko.epeksergasiaZwoy();
                    break;
                case 6:
                    attikoZwologikoParko.provolhDiathesimwnZwwn();
                    System.out.println("Dwste to kwdiko toy zwoy pros diagrafh: ");
                    // Anazhtoyme to zwo me kwdikoy poy dinei o xrhsths kai an yparxei to diagrafoyme
                    attikoZwologikoParko.diagrafhZwoyBaseiKwdikoy(attikoZwologikoParko.anazhthshBaseiKwdikoy(s.next()));
                    break;
                case 7:
                    System.out.println("Kalh synexeia!");
                    break loop; // Termatismos toy programmatos

            }

        }

        // Apothikeysh zwwn sto arxeio animals.txt mesw serialization
        try {
            FileOutputStream fos = new FileOutputStream("animals.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(attikoZwologikoParko.getAnimals());
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
