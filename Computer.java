import java.util.Random;

public class Computer extends Player
{

    protected void roll_dices()
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
        print_dices();
        keep = choose_dices();
        for(int i = 0; i < 5; i++)
        {
            if(!keep[i])
            {
                dices_result[i] = rand.nextInt(5 + 1) + 1;
            }
        }
        print_dices();
        keep = choose_dices();
        for(int i = 0; i < 5; i++)
        {
            if(!keep[i])
            {
                dices_result[i] = rand.nextInt(5 + 1) + 1;
            }
        }
        print_dices();
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

        System.out.println(lower+" "+id_max);
        if(!lower)
        {
            upper_section[id_max] = choice_possible_upper[id_max];
            choice_possible_upper[id_max] = -1;
        }
        else
        {
            lower_section[id_max] = choice_possible_lower[id_max];
            choice_possible_lower[id_max] = -1;
        }
    }

}

