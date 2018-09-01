package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i,j;
        Dice[] DArray = new Dice[5];
        int[] ValueArray = new int[5];
        for (i = 0;i<DArray.length;i++){
            DArray[i] = new Dice();
        }
        for (i = 0; i < 3; i++){
            System.out.println("Round " + (i+1));
            roll(DArray);
            //table with value of dice
            for (j = 0; j<ValueArray.length; j++){
                ValueArray[j] = DArray[j].getValue();
            }
        }

    }

    //Roll Dice
    private static void roll(Dice[] DiceArray){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int n;
        String KeepIt;
        for (n = 0; n<DiceArray.length; n++){
            //check if we keep the dice or not
            if (!DiceArray[n].isKeep()){
                DiceArray[n].setValue(rand.nextInt((5) + 1) + 1);
            }
            System.out.println("|" + DiceArray[n].getValue() + "|");
        }
        for (n = 0; n<DiceArray.length; n++){
            do {
                System.out.println("Do you want to keep the dice n°" + (n+1) +" |" + DiceArray[n].getValue() + "| ? (y/n)");
                KeepIt = sc.nextLine();
            }while(!KeepIt.equals("y") && !KeepIt.equals("n"));
            if (KeepIt.equals("y"))
                DiceArray[n].setKeep(true);
            else
                DiceArray[n].setKeep(false);
        }
    }
}

