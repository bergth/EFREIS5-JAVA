import java.util.Random;
import java.util.Arrays;


public class Computer extends Player
{




    protected int[] roll_dices()
    {
        int[] dices_result = {0,0,0,0,0};
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
        //Arrays.sort(dices_result);
        boolean[] keep = {false,false,false,false,false};
        
        keep = strategie(dices_result);

        System.out.print("I choose: ");
        for(int i = 0; i < 5; i++)
        {
            if(keep[i])
                System.out.print((i+1)+" ");
        }
        System.out.println("");
        return keep;
    }


    private int find_max()
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
        return val;
    }



    protected void ask_choice()
    {
        int val = find_max();
        System.out.println("I chose: " + val);
        pscore.set_choice(val);
    }

    private boolean[] strategie(int[] dices)
    {
        int[] choice_possible_upper = pscore.get_choice_upper();
        int[] choice_possible_lower = pscore.get_choice_lower();

        boolean[][] keeps = new boolean[13][];
        int[] res = new int[13];
        for(int i = 0; i < 13; i++)
        {
            keeps[i] = new boolean[5];
            for(int j = 0; j < 5; j++)
            {
                keeps[i][j] = false;
            }
        }

        int max = 0;
        int id_max = 0;
        for(int i = 1; i <= 6; i++)
        {
            if(choice_possible_upper[i - 1] != -1)
            {
                int tmp = keep_upper(dices, i, keeps[i - 1]);
                if(tmp > max)
                {
                    max = tmp;
                    id_max = i;
                }
            }
        }

        int tmp = 0;
        if(choice_possible_lower[0] != -1 && choice_possible_lower[1] != -1)
        {
            tmp = of_king(dices, keeps[6]);
            if(tmp > max)
            {
                max = tmp;
                id_max = 6;
            }
        }

        if(choice_possible_lower[2] != -1)
        {
            tmp = full_house(dices, keeps[7]);
            if(tmp > max)
            {
                max = tmp;
                id_max = 7;
            }
        }
        if(choice_possible_lower[3] != -1)
        {
            tmp = sm_straight(dices, keeps[8]);
            if(tmp > max)
            {
                max = tmp;
                id_max = 8;
            }
        }
        if(choice_possible_lower[4] != -1)
        {
            tmp = lg_straight(dices, keeps[9]);
            if(tmp > max)
            {
                max = tmp;
                id_max = 9;
            }
        }
        if(choice_possible_lower[5] != -1)
        {
            tmp = yahtzee(dices, keeps[10]);
            if(tmp > max)
            {
                max = tmp;
                id_max = 10;
            }
        }

        return keeps[id_max];
    }

    int keep_upper(int[] dices, int n, boolean[] keep)
    {
        keep = new boolean[5];
        int nb_keep = 0;
        for(int i = 0; i < 5; i++)
        {
            if(dices[i] == n)
            {
                nb_keep++;
                keep[i] = true;
            }

        }
        return (n*(nb_keep + 1)) * 2;
    }


    int[] find_max_dices(int[] dices)
    {
        int[] nb = {0,0,0,0,0,0};
        for(int i = 0; i < dices.length; i++)
        {
            nb[dices[i]-1] += 1;
        }

        int max = 0;
        int max2 = 0;
        int index_max = 0;
        int index_max2 = 0;
        for(int i = 0; i < nb.length; i++)
        {
            if(nb[i] > max)
            {
                max = nb[i];
                index_max = i;
            }
        }
        for(int i = 0; i < nb.length; i++)
        {
            if(nb[i] != max && nb[i] >= max2)
            {
                max2 = nb[i];
                index_max2 = i;
            }
        }

        int[] arr = {index_max + 1, max, index_max2 + 1, max2};
        return arr;
    }


    int of_king(int[] dices, boolean[] keep)
    {
        int[] maxs = find_max_dices(dices);
        int max = maxs[1];
        int index_max = maxs[0];
        if(max >= 2)
        {
            int sum = 0;
            int min = 7;
            for(int i = 0; i < 5; i++)
            {
                sum += dices[i];
                if(dices[i] < min)
                {
                    min = dices[i];
                }
                if(dices[i] == index_max)
                {
                    keep[i] = true;
                }
            }
            return sum - min + (index_max);
        }
        else
        {
            return 0;
        }
    }

    int full_house(int[] dices, boolean[] keep)
    {
        int[] maxs = find_max_dices(dices);
        for(int i = 0; i < 5; i++)
        {
            if(dices[i] == maxs[0] || dices[i] == maxs[2])
            {
                keep[i] = true;
            }
        }
        return 25 / (6 - maxs[1] - maxs[3]);
    }

    int sm_straight(int[] dices, boolean[] keep)
    {
        return 0;
    }

    int lg_straight(int[] dices, boolean[] keep)
    {
        return 0;
    }

    int yahtzee(int[] dices, boolean[] keep)
    {
        int[] maxs = find_max_dices(dices);
        int nb_max = maxs[1];
        int val_max = maxs[0];
        for(int i = 0; i < 5; i++)
        {
            if(dices[i] == val_max)
            {
                keep[i] = true;
            }
        }
        return 50 / (6 - nb_max);
    }



}

