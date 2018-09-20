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


    
    private static void run_game(int nb_players, int nb_robots)
    {
        Player[] players = new Player[nb_players + nb_robots];
        for(int i = 0; i < nb_players; i++)
        {
            players[i] = new Player();
        }
        for(int i = 0; i < nb_robots; i++)
        {
            players[nb_players + i] = new Computer();
        }

        boolean game_end = false;
        while(!game_end)
        {

            for(int i = 0; i < players.length; i++)
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
        float sum = 0;
        for(int i = 0; i < players.length; i++)
        {
            int result = players[i].get_result();
            sum += result;
            System.out.printf("Player %2d: %d\n",i + 1,result);
            if(result > max)
            {
                max = result;
                id_max = i;
            }
        }
        System.out.println("\nPlayer " + (id_max+1) + " win !");
        System.out.println("Moy: " + (sum / players.length));
    }


    public static void main(String[] args) {
        System.out.println("Hello ! Yahtzee !");
        print_logo();
        int nb_players = -1;
        int nb_robots = -1;
        boolean input_ok = false;
        Scanner scan = new Scanner(System.in);
        while(!input_ok)
        {
            while(nb_players < 0)
            {
                System.out.println("Choose number of players:");
                try
                {
                    nb_players = scan.nextInt();
                }catch(Exception e)
                {
                    nb_players = -1;
                    scan.nextLine();
                }
            }

            while(nb_robots < 0)
            {
                System.out.println("Choose number of robots:");
                try
                {
                    nb_robots = scan.nextInt();
                }catch(Exception e)
                {
                    nb_robots = -1;
                    scan.nextLine();
                }
            }
            if(nb_players == 0 && nb_robots == 0)
            {
                System.out.println("Please select at least one robot or player\n");
            }
            else
            {
                input_ok = true;
            }
        }
        run_game(nb_players,nb_robots);
        System.out.println("Bye ! Yahtzee !");
    }
}
