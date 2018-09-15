import java.util.Random;
import java.util.Scanner;



public class Player
{

    Score pscore = new Score();

    public void print_dices(int[] dices_result)
    {
        System.out.println("+---+---+---+---+---+");
        System.out.printf("| %1d | %1d | %1d | %1d | %1d |\n",dices_result[0],dices_result[1],dices_result[2],dices_result[3],dices_result[4]);
        System.out.println("+---+---+---+---+---+");
        System.out.println("  ^   ^   ^   ^   ^  ");
        System.out.println("  1   2   3   4   5  ");
    }

    /**
     * 
     * Roll the dices. 
     * Fill 'dice_result' after the 3 rolls
     * 
     */
    protected int[] roll_dices()
    {
        int dices_result[] = {0,0,0,0,0};
        int i, j;
        String KeepIt;//Condition to keep or not a Dice
        Scanner sc = new Scanner(System.in);
        Dice DiceArray[] = new Dice[5];//Initialization Array of 5 dices
        Random rand = new Random();
        for (i = 0; i < DiceArray.length; i++)
            DiceArray[i] = new Dice();//Initialization of each dice
        for (int round = 0; round < 2; round++){
            System.out.println("\n---ROLL N°" + (round +1) +"---\n");//Print the actual Roll
            for (i = 0; i < DiceArray.length; i++){
                if (DiceArray[i].isKeep() == false){
                    DiceArray[i].setValue(rand.nextInt(5 + 1) + 1);//Random number between 1 & 6
                    dices_result[i] = DiceArray[i].getValue();
                }
            }
            print_dices(dices_result);
            //Selection for each Dice
            for (j = 0; j < 5; j++){
                do {
                    System.out.println("Do you want to keep the dice n°" + (j+1) +" |" + DiceArray[j].getValue() + "| ? (y/n)");
                    KeepIt = sc.nextLine();
                }while(!KeepIt.equals("y") && !KeepIt.equals("n"));
                if (KeepIt.equals("y"))
                    DiceArray[j].setKeep(true);//User keep the dice
                else
                    DiceArray[j].setKeep(false);
            }
        }
        System.out.println("\n---ROLL N°3---\n");
        for (i = 0; i < DiceArray.length; i++){
            if (DiceArray[i].isKeep() == false){
                DiceArray[i].setValue(rand.nextInt(5 + 1) + 1);
                dices_result[i] = DiceArray[i].getValue();
            }
        }
        
        print_dices(dices_result);
        return dices_result;

    }



    /**
     * 
     * Read 'dice_result' and fill 'choice_possible_upper'
     * with the possibles choice that a user can do.
     * 
     */
    

    /**
     * Ask the choice of the user and make the modification on the array
     * 
     * 
     */
    protected void ask_choice()
    {
        pscore.print_result();
        Scanner scan = new Scanner(System.in);
        int choix = -1;
        boolean choice_made = false;
        do
        {
            System.out.println("What is your choice ?");
            try
            {
                choix = scan.nextInt();
            }catch(Exception e)
            {
                choix = -1;
                scan.nextLine();
            }
            if(choix >= 0 && choix <= 13)
            {
                choice_made = true;

            }
        }while(!choice_made);
        
    }

 


    /**
     * 
     * Need to be run at the end of a round.
     * Clean choice_possible arrays
     * 
     */

    public void round()
    {
        pscore.print_result();
        roll_dices();
        pscore.find_choice();
        pscore.print_result();
        ask_choice();
        pscore.clean_arrays(); 
        pscore.print_result();
    }

    public int get_result()
    {
        return pscore.get_result();
    }

    public boolean is_end()
    {
        return pscore.is_end();
    }

    /**
     * @return the name of the player
     */
    public String get_name()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter your name :");
        String name = keyboard.nextLine();
        return name;
    }

}