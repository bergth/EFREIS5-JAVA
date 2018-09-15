import java.util.Random;

public class Computer extends Player
{
    int[] dices_result = {0,0,0,0,0};
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
        keep = choose_dices();
        for(int i = 0; i < 5; i++)
        {
            if(!keep[i])
            {
                dices_result[i] = rand.nextInt(5 + 1) + 1;
            }
        }
        print_dices(dices_result);
        keep = choose_dices();
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


    private boolean[] choose_dices()
    {
        Random rand = new Random();
        boolean[] keep = {false,false,false,false,false};
        for(int i = 0; i < 5; i++)
        {
            if(rand.nextInt(2) == 1)
            {
                keep[i] = true;
            }
        }

        System.out.print("I choose: ");
        for(int i = 0; i < 5; i++)
        {
            System.out.print(i+" ");
        }
        System.out.println("");
        return keep;
    }

    protected void ask_choice()
    {
        int[] choice_possible_upper = pscore.get_choice_upper();
        int[] choice_possible_lower = pscore.get_choice_lower();

        int id_max = 0;
        int max = -2;
        boolean lower = false;
        for(int i = 0; i < 6; i++)
        {
            if(choice_possible_upper[i] > max)
            {
                max = choice_possible_upper[i];
                id_max = i;
            }
        }

        for(int i = 0; i < 7; i++)
        {
            if(choice_possible_lower[i] > max)
            {
                lower = true;
                max = choice_possible_lower[i];
                id_max = i;
            }
        }

        int val = -2;
        if(lower)
        {
            val = id_max + 7;
        }
        else
        {
            val = id_max + 1;
        }
        System.out.println("I chose: " + val);
        pscore.set_choice(val);
    }

}

