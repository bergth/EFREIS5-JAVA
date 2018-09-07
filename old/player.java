package com.company;
import java.util.Random;
import java.util.Scanner;


public class player {
    // contains the possible score for each box (ones, twos, threes...)
    int temp[] = {-1, -1, -1, -1, -1, -1};
    // contains the scores sets for each box in the upper section
    int array_up[] = {-1, -1, -1, -1, -1, -1};
    // contains the scores sets for each box in the lower section
    int array_down[] = {-1, -1, -1, -1, -1, -1};
    // results of dices
    int results[] = {-1,-1,-1,-1,-1};
    //upper total
    int total_up = 0;
    //lower total
    int total_down = 0;
    //total of upper and lower
    int full_total = 0;
    // possibles choices of the menu; false : the box of the score isn't taken; true : the box is already filled with
    // a score chosen by the user
    boolean menu_choice[] = {false, false, false, false, false, false};
    Scanner keyboard = new Scanner(System.in);

    // Display
    public void print(){


        //Calculate the score of the upper section
        total_up = 0;
        for(int i = 0 ; i < array_up.length ; i++) {
            if (array_up[i] != -1)
                total_up += array_up[i];
        }

        //Special rule for upper section if total > 63
        if(total_up >= 63)
            total_up += 35;

        //Calculate the score of the lower section
        total_down = 0;
        for(int i = 0 ; i < array_down.length ; i++) {
            if (array_down[i] != -1)
                total_down += array_down[i];
        }

        // Display
        System.out.printf("UPPER SECTION | Player 1 | Player 2\n");
        System.out.printf("ONES          | ");
        condition(temp[0], array_up[0]);
        System.out.printf("TWOS          | ");
        condition(temp[1], array_up[1]);
        System.out.printf("THREES        | ");
        condition(temp[2], array_up[2]);
        System.out.printf("FOURS         | ");
        condition(temp[3], array_up[3]);
        System.out.printf("FIVES         | ");
        condition(temp[4], array_up[4]);
        System.out.printf("SIXES         | ");
        condition(temp[5], array_up[5]);
        System.out.printf("TOTAL         | %d\n", total_up);
        System.out.printf("UPPER TOTAL   | %d\n", total_up);
        System.out.printf("3 OF A KIND   | ");
        condition(temp[5], array_down[5]);
        System.out.printf("4 OF A KIND   | ");
        condition(temp[5], array_down[5]);
        System.out.printf("SMALL STRAIGHT| ");
        condition(temp[5], array_down[5]);
        System.out.printf("YAHTZEE       | ");
        condition(temp[5], array_down[5]);
        System.out.printf("CHANCE        | ");
        condition(temp[5], array_down[5]);
        System.out.printf("YAHTZEE BONUS | ");
        condition(temp[5], array_down[5]);
        System.out.printf("LOWER TOTAL   | %d\n", total_down);
        System.out.printf("GRAND TOTAL   | %d\n", full_total);

        //choice input by the user
        int choice = -1;

        do {
            System.out.println("Wich case do you want to keep? ");

            for(int i=0; i < temp.length; i++){

                // test if the place of the array is already taken <=> if the users already put a score in a box
                if(temp[i]!=-1){
                    // each index of this array take the value of each temp index that isn't set to -1
                    menu_choice[i]= true;
                }

                // displays the free boxes with it's possible score
                if(array_up[i] == -1)
                {
                    System.out.print((i+1) + " ");
                }

            }


            System.out.println("");

            //Input the choice of the user
            do {
                if(keyboard.hasNextInt())
                {
                    choice = keyboard.nextInt();
                }
                else {
                    System.out.println("Error input;");
                    keyboard.nextLine();
                }
            }while(choice == -1);


            if(array_up[choice-1] == -1){
                if(!menu_choice[choice-1])
                {
                    array_up[choice - 1] = 0;
                }
                else {
                    array_up[choice - 1] = temp[choice - 1];
                }
                for(int i = 0; i < temp.length; i++)
                {

                    temp[i] = -1;
                }
                break;
            }
        }while(true);

        //while(menu_choice[choice-1] == false || array[choice-1] == -1);
    }

    public void condition(int temp, int x){ // temp = value of the possible score by index of the array, x = value already there
        if (x != -1)
            System.out.printf(" %d\n", x); // if a value is already there
        else if(x == -1 && temp !=-1)
            System.out.printf(" -%d-\n", temp); // a possible value to choose
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
            roll(DArray, i);
            //table with value of dice
            for (j = 0; j < ValueArray.length; j++) {
                ValueArray[j] = DArray[j].getValue();
            }
        }
        return DArray;
    }

    private static void roll(Dice[] DiceArray, int turn){
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
        if (turn != 2){
            for (n = 0; n<DiceArray.length; n++){
                do {
                    System.out.println("Do you want to keep the dice n°" + (n + 1) + " |" + DiceArray[n].getValue() + "| ? (y/n)");
                    KeepIt = sc.nextLine();
                } while (!KeepIt.equals("y") && !KeepIt.equals("n"));
                if (KeepIt.equals("y"))
                    DiceArray[n].setKeep(true);
                else
                    DiceArray[n].setKeep(false);
            }
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
        for (int i = 0; i<6; i++)  {
            fill_arrays();
            fill_result();
            print();
        }
    }
}
