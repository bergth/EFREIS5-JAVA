import java.util.Random;
import java.util.Arrays;


public class Computer extends Player
{


    int[] estim_upper = {0,0,0,0,0,0};
    int[] estim_lower = {0,0,0,0,0,0,0};
    int[] dices_result = {0,0,0,0,0};
    boolean[][] keeps;

    protected int[] roll_dices()
    {
        boolean[] keep = {false,false,false,false,false};

        Random rand = new Random();
        for(int i = 0; i < 5; i++)
        {
            if(!keep[i])
            {
                dices_result[i] = rand.nextInt(5 + 1) + 1;
            }
        }
        print_dices(dices_result);
        keep = choose_dices(dices_result);
        for(int i = 0; i < 5; i++)
        {
            if(!keep[i])
            {
                System.out.println("nkeep: "+ (i+1));
                dices_result[i] = rand.nextInt(5 + 1) + 1;
            }
        }
        print_dices(dices_result);
        keep = choose_dices(dices_result);
        for(int i = 0; i < 5; i++)
        {
            if(!keep[i])
            {
                dices_result[i] = rand.nextInt(5 + 1) + 1;
            }
        }
        print_dices(dices_result);
        return dices_result;
    }


    private boolean[] choose_dices(int[] dices_result)
    {
        boolean[] keep = {false,false,false,false,false};
        
        keep = strategie();

        System.out.print("I choose: ");
        for(int i = 0; i < 5; i++)
        {
            if(keep[i] == true)
                System.out.print((i+1)+" ");
        }
        System.out.println("");
        return keep;
    }


    private boolean[] strategie()
    {
        boolean[] keep =  {false, false, false, false, false};
        return keep;
    }


    protected void ask_choice()
    {
        int val = find_max();
        System.out.println("I chose: " + (val));
        pscore.set_choice(val);
    }





}

