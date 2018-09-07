<<<<<<< HEAD

package com.company;
=======


>>>>>>> a5b6edd51193b5ebbe8bfef550d589811265b6f5

public class Main {

    private static void print_logo()
    {
        System.out.println("                                                                                           ,---,  ");
        System.out.println("                                                                                        ,`--.' |  ");
        System.out.println("                            ,---,       ___                                             |   :  :  ");
        System.out.println("        ,---,             ,--.' |     ,--.'|_                                           '   '  ;  ");
        System.out.println("       /_ ./|             |  |  :     |  | :,'        ,----,                            |   |  |  ");
        System.out.println(" ,---, |  ' :             :  :  :     :  : ' :      .'   .`|                            '   :  ;  ");
        System.out.println("/___/ \\.  : |   ,--.--.   :  |  |,--.;__,'  /    .'   .'  .'   ,---.     ,---.          |   |  '  ");
        System.out.println(" .  \\  \\ ,' '  /       \\  |  :  '   |  |   |   ,---, '   ./   /     \\   /     \\         '   :  |  ");
        System.out.println("  \\  ;  `  ,' .--.  .-. | |  |   /' :__,'| :   ;   | .'  /   /    /  | /    /  |        ;   |  ;  ");
        System.out.println("   \\  \\    '   \\__\\/: . . '  :  | | | '  : |__ `---' /  ;--,.    ' / |.    ' / |        `---'. |  ");
        System.out.println("    '  \\   |   ,\" .--.; | |  |  ' | : |  | '.'|  /  /  / .`|'   ;   /|'   ;   /|         `--..`;  ");
        System.out.println("     \\  ;  ;  /  /  ,.  | |  :  :_:,' ;  :    ;./__;     .' '   |  / |'   |  / |        .--,_     ");
        System.out.println("      :  \\  \\;  :   .'   \\|  | ,'     |  ,   / ;   |  .'    |   :    ||   :    |        |    |`.  ");
        System.out.println("       \\  ' ;|  ,     .-./`--''        ---`-'  `---'         \\   \\  /  \\   \\  /         `-- -`, ; ");
        System.out.println("        `--`  `--`---'                                        `----'    `----'            '---`\"  ");
    }

    public static void main(String[] args) {
        System.out.println("Hello ! Yahtzee !");
        print_logo();
        Player p1 = new Player();
        p1.round();

        System.out.println("Bye ! Yahtzee !");
    }
}


/*CLASSES :
        DICE
        PLAYER
        Resultats
        array upper section / lower
        afficher tableau
        lancer dés
        scores possibles
        Menu scores possibles
        tour
        retour score total
        GAME
*/
