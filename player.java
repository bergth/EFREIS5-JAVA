package com.company;
import java.util.Random;
import java.util.Scanner;

public class player {
    int temp[] = {-1, -1, -1, -1, -1, -1}; // contains the possible score for each box (ones, twos, threes...)
                                            // donc change en fonction des dés
    int array[] = {-1, -1, -1, -1, -1, -1}; // contains the scores sets for each box
    int results[] = {-1,-1,-1,-1,-1};
    int total = 0;
    boolean menu_choice[] = {false,false,false,false,false,false}; // possibles choices of the menu
    Scanner keyboard = new Scanner(System.in);

    public void print(){

        for(int i = 0; i < array.length; i++) { // total of points
            if (array[i] != -1)
                total += array[i];
        }

        if(total > 63)// special rule
            total += 35;

        System.out.printf("UPPER SECTION | Player 1 | Player 2\n");
        System.out.printf("ONES          |");
        condition(temp[0], array[0]);
        System.out.printf("TWOS          |");
        condition(temp[1], array[1]);
        System.out.printf("THREES        |");
        condition(temp[2], array[2]);
        System.out.printf("FOURS         |");
        condition(temp[3], array[3]);
        System.out.printf("FIVES         |");
        condition(temp[4], array[4]);
        System.out.printf("SIXES         |");
        condition(temp[5], array[5]);
        System.out.printf("TOTAL         |%d\n", total);
        System.out.printf("UPPER TOTAL   |%d\n", total);

        int choice = 0;
        int j=0;
        do {
            System.out.println("Wich case do you want to keep? ");
            for(int i=0; i < temp.length; i++){
                if(temp[i]!=-1){
                    System.out.print(i+1); // displays the boxes with possible score
                    menu_choice[i]= true; // each index of this array take the value of each temp index that isn't set to -1
                    j++;
                }
            }
            System.out.println("");

            choice = keyboard.nextInt();

                    if(menu_choice[choice-1]){
                        // mettre ici le truc pour "bloquer" la case avec le score
                }
        }

        while(choice != '0' || !menu_choice[choice]); /* Le choice != menu_choice[] je sais qu'il marche pas mais
        je cherche un truc qui pourrait tester le tableau pour etre sûr que le joueur selectionne un nombre qui lui est
        proposé
        */
    }

    public void condition(int temp, int x){ // temp = value of the possible score by index of the array, x = value already there
        if (x != -1)
            System.out.printf(" %d\n", x); // if a value is already there
        else if(x == -1 && temp !=-1)
            System.out.printf(" \033[31m%d\033\n", temp); // a possible value to choose
        else
            System.out.printf(" X\n"); // no value possible
    }

    private static Dice[] get_dice()
    {
        int i,j;
        Dice[] DArray = new Dice[5];
        int[] ValueArray = new int[5];
        for (i = 0;i<DArray.length;i++){
            DArray[i] = new Dice();
        }
        for (i = 0; i < 3; i++) {
            System.out.println("Round " + (i + 1));
            roll(DArray);
            //table with value of dice
            for (j = 0; j < ValueArray.length; j++) {
                ValueArray[j] = DArray[j].getValue();
            }
        }
        return DArray;
    }

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

    private void fill_arrays()
    {
        Dice[] dices = get_dice();
        for(int i = 0; i < dices.length; i++)
        {
            results[i] = dices[i].getValue();
        }
    }

    private void fill_result()
    {
        for(int i = 1; i <= 6; i++)
        {
            int sum = 0;
            for(int j = 0; j < results.length; j++)
            {
                if(results[j] == i)
                {
                    sum += i;
                }
            }
            if(sum != 0)
            {
                temp[i-1] = sum;
            }
        }
    }

    public void play()
    {
        fill_arrays();
        fill_result();
        print();
    }


}
