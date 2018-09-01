package com.company;
import java.util.Scanner;

public class player {
    int temp[] = {-1, -1, -1, -1, -1, -1}; // je sais pas comment init temp, en gros ça va etre la somme des 1 ou 2 ou 3 en fonction des possibilités
    // donc change en fonction des dés
    int array[] = {-1, -1, -1, -1, -1, -1}; // ones, twos, threes ...
    int total = 0;
    int menu_choice[] = new int[6]; // possibles choices of the menu
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
        System.out.printf("TOTAL         |%d", total);
        System.out.printf("UPPER TOTAL   |%d", total);

        char choice = '0';
        int j=0;
        do {
            System.out.print("Wich case do you want to keep? ");
            for(int i=0; i < temp.length; i++){
                if(temp[i]!=-1){
                    System.out.print(i+1);
                    menu_choice[j]= i+1; // chaque case prend la valeur d'une case de temp qui ne contient pas -1
                    j++;
                }
            }

            choice = keyboard.next().charAt(0);

                for(int i=0; i < menu_choice.length; i++){
                    if(choice == (char) menu_choice[i]){
                        // mettre ici le truc pour "bloquer" la case avec le score
                    }
                }
        }

        while(choice != '0' || choice != (char) menu_choice[]); /* Le choice != menu_choice[] je sais qu'il marche pas mais
        je cherche un truc qui pourrait tester le tableau pour etre sûr que le joueur selectionne un nombre qui lui est
        proposé
        */
    }

    public void condition(int temp, int x){ // temp = valeur des dés a appeler, x = ones / twos / threes...
        if (x != -1)
            System.out.printf("ONES          | %d\n", x);
        else if(x == -1 && temp !=-1)
            System.out.printf("ONES          | \033[31m%d\033\n", temp);
        else
            System.out.printf("ONES          | X\n");
    }
}
