import java.util.Scanner;

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
        System.out.println("");
        System.out.println("");
    }

    private static void run_game(int nb_player)
    {
        Player[] players = new Player[nb_player];
        for(int i = 0; i < players.length; i++)
        {
            players[i] = new Player();
        }

        boolean game_end = false;
        while(!game_end)
        {
            for(int i = 0; i < players.length && !game_end; i++)
            {
                System.out.println("#####################################");
                System.out.printf("*-------------------*\n");
                System.out.printf("| Player n° %2d !    |\n",i+1);
                System.out.printf("*-------------------*\n");
                players[i].round();
                if(players[i].is_end())
                {
                    game_end = true;
                }
            }
        }

        System.out.println("Game end !\n");
        System.out.println("Result:");
        int max = 0;
        int id_max = 0;
        for(int i = 0; i < players.length; i++)
        {
            int result = players[i].get_result();
            System.out.printf("Player %2d: %d\n",i + 1,result);
            if(result > max)
            {
                max = result;
                id_max = i;
            }
        }

        System.out.println("\nPlayer " + (id_max+1) + " win !");
    }


    public static void main(String[] args) {
        System.out.println("Hello ! Yahtzee !");
        print_logo();
        int nb = 0;
        Scanner scan = new Scanner(System.in);
        while(nb <= 0)
        {
            System.out.println("Choose number of players (1 to n):");
            try
            {
                nb = scan.nextInt();
            }catch(Exception e)
            {
                nb = 0;
                scan.nextLine();
            }
        }
        run_game(nb);
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
