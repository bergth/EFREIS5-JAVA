package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int somme = 0;
        Random rand = new Random();
        Dice[] DArray = new Dice[5];
        for (int n = 0; n<DArray.length; n++){
            DArray[n] = new Dice();
            DArray[n].setValue(rand.nextInt((5) + 1) + 1);
            System.out.println("|" + DArray[n].getValue() + "|");
            somme = somme + DArray[n].getValue();
        }
        System.out.println("la somme des dés est : " + somme);
    }
}

/*{
        String condition;
        int dicekeep;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int somme = 0;
        Dice DiceArray[] = new Dice[5];
        for (int n = 0; n<DiceArray.length; n++){
            DiceArray[n] = new Dice();
            DiceArray[n].setValue(rand.nextInt((5) + 1) + 1);
            System.out.println(DiceArray[n].getValue());
            System.out.println(DiceArray[n].isKeep());
            somme = somme + DiceArray[n].getValue();
        }
        System.out.println(somme);
        do {
            do {
                System.out.println("Keep a dice ? :");
                dicekeep = sc.nextInt();
            } while (dicekeep <= 0 || dicekeep >= 6);
            DiceArray[dicekeep - 1].setKeep(true);
            do {
                System.out.println("Keep another dice ? :");
                condition = sc.nextLine();
            }while(condition.equals("yes")  || condition.equals("no") );
        }while (condition.equals("yes"));
    }*/