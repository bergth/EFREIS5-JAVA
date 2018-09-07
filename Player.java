public class Player
{
    // name of the player
    String name;

    // result of upper and lower section
    int[] upper_section = {0,0,0,0,0,0};
    int[] lower_section = {0,0,0,0,0,0,0};

    // result of dices
    int[] dices_result = {0,0,0,0,0};

    // bonuses 
    int each_bonus = 0;
    int score_100 = 0;

    // Information about the possible choice for a round after the roll of dices
    // -1 = already set, 0 = no choice possible, > 0 = score possible if chosen
    int[] choice_possible_upper = {1,1,1,1,1,1};
    int[] choice_possible_lower = {1,1,1,1,1,1,1};


    /**
     * Print the actual array of results with sugestion of choices
     * 
     */
    private void print_result()
    {

        int total_upper = 0;
        for(int i = 0; i < upper_section.length; i++)
        {
            total_upper += upper_section[i];
        }

        int bonus_upper = 0;
        if(total_upper >= 63)
            bonus_upper = 35;

        int total_upper_bonus = total_upper + bonus_upper;

        int total_lower = 0;

        for(int i = 0; i < lower_section.length; i++)
        {
            total_lower += lower_section[i];
        }

        total_lower += each_bonus + score_100;

        int grand_total = total_lower + total_upper;

        System.out.printf("┌─────────────────────────┐");
        System.out.printf("\n│ UPPER SECTION           │");
        System.out.printf("\n├──────────────────┬──────┤");
        System.out.printf("\n│ 1.  Aces         │ %4d │",upper_section[0]);
        if(choice_possible_upper[0] > 0)
            System.out.print(" <- " + choice_possible_upper[0]);
        System.out.printf("\n│ 2.  Twos         │ %4d │",upper_section[1]);
        if(choice_possible_upper[1] > 0)
            System.out.print(" <- " + choice_possible_upper[0]);
        System.out.printf("\n│ 3.  Threes       │ %4d │",upper_section[2]);
        if(choice_possible_upper[2] > 0)
            System.out.print(" <- " + choice_possible_upper[0]);
        System.out.printf("\n│ 4.  Fours        │ %4d │",upper_section[3]);
        if(choice_possible_upper[3] > 0)
            System.out.print(" <- " + choice_possible_upper[0]);
        System.out.printf("\n│ 5.  Fives        │ %4d │",upper_section[4]);
        if(choice_possible_upper[4] > 0)
            System.out.print(" <- " + choice_possible_upper[0]);
        System.out.printf("\n│ 6.  Sixes        │ %4d │",upper_section[5]);
        if(choice_possible_upper[5] > 0)
            System.out.print(" <- " + choice_possible_upper[0]);
        System.out.printf("\n├──────────────────┼──────┤");
        System.out.printf("\n│ TOTAL SCORE      │ %4d │",total_upper);
        System.out.printf("\n│ BONUS (> 63)     │ %4d │",bonus_upper);
        System.out.printf("\n│ TOTAL UPPER      │ %4d │",total_upper_bonus);
        System.out.printf("\n├──────────────────┴──────┤");
        System.out.printf("\n│ LOWER SECTION           │");
        System.out.printf("\n├──────────────────┬──────┤");
        System.out.printf("\n│ 7.  3 of a kind  │ %4d │",lower_section[0]);
        if(choice_possible_lower[0] > 0)
            System.out.print(" <- " + choice_possible_lower[0]);
        System.out.printf("\n│ 8.  4 of a kind  │ %4d │",lower_section[1]);
        if(choice_possible_lower[1] > 0)
            System.out.print(" <- " + choice_possible_lower[1]);
        System.out.printf("\n│ 9.  Full House   │ %4d │",lower_section[2]);
        if(choice_possible_lower[2] > 0)
            System.out.print(" <- " + choice_possible_lower[2]);
        System.out.printf("\n│ 10. Sm. Straight │ %4d │",lower_section[3]);
        if(choice_possible_lower[3] > 0)
            System.out.print(" <- " + choice_possible_lower[3]);
        System.out.printf("\n│ 11. Lg. Straight │ %4d │",lower_section[4]);
        if(choice_possible_lower[4] > 0)
            System.out.print(" <- " + choice_possible_lower[4]);
        System.out.printf("\n│ 12. YAHTZEE      │ %4d │",lower_section[5]);
        if(choice_possible_lower[5] > 0)
            System.out.print(" <- " + choice_possible_lower[5]);
        System.out.printf("\n│ 13. Chance       │ %4d │",lower_section[6]);
        if(choice_possible_lower[6] > 0)
            System.out.print(" <- " + choice_possible_lower[6]);
        System.out.printf("\n├──────────────────┼──────┤");
        System.out.printf("\n│ each bonus       │ %4d │",each_bonus);
        System.out.printf("\n│ score 100 bonus  │ %4d │",score_100);
        System.out.printf("\n├──────────────────┼──────┤");
        System.out.printf("\n│ GRAND TOTAL      │ %4d │",grand_total);
        System.out.printf("\n└──────────────────┴──────┘\n");

    }


    /**
     * 
     * Roll the dices. 
     * Fill 'dice_result' after the 3 rolls
     * 
     */
    public void roll_dices()
    {
        // FIXME
    }

    /**
     * 
     * Read 'dice_result' and fill 'choice_possible_upper'
     * with the possibles choice that a user can do.
     * 
     */
    
    public void find_upper_choices()
    {
        //FIXME
    }

    /**
     * Find by reading 'dice_result' and filling 'choice_possible_upper'
     * if a user can do a 3 or 4 of king, full house or Yahtzee
     */
    public void find_kind_yahtzee_house()
    {
        //FIXME
    }
    
    /**
     * Find by reading 'dice_result' and filling 'choice_possible_upper'
     * if a user can do a small or large Straight
     */
    public void find_straight()
    {
        //FIXME
    }


    /**
     * Find by reading 'dice_result' and filling 'choice_possible_upper'
     * if a user can do a chance
     */
    public void find_chance()
    {
        if(choice_possible_upper[6] != -1)
        {
            int res = 0;
            for(int i = 0; i < dices_result.length; i++)
            {
                res += dices_result[i];
            }
            choice_possible_upper[6] = res;
        }
    }

    /**
     * Ask the choice of the user and make the modification on the array
     * 
     * 
     */
    private void ask_choice()
    {
        //FIXME
    }

 


    /**
     * 
     * Need to be run at the end of a round.
     * Clean choice_possible arrays
     * 
     */
    private void clean_arrays()
    {
        for(int i = 0; i < choice_possible_lower.length; i++)
        {
            if(choice_possible_lower[i] != -1)
                choice_possible_lower[i] = 0;
        }

        for(int i = 0; i < choice_possible_upper.length; i++)
        {
            if(choice_possible_upper[i] != -1)
                choice_possible_upper[i] = 0;
        }
    }

    public void round()
    {
        roll_dices();
        ask_choice();
        print_result();
        clean_arrays();
    }


       /**
     * @return the name of the player
     */
    public String get_name()
    {
        // FIXME
        return name;
    }


    
    /**
     * @return true if the player fill all the arrays.
     */

    public boolean is_end()
    {
        // FIXME
        return false;
    }

    /**
     * 
     * @return the grand total score (to be used at the end of a game)
     */
    public int get_result()
    {
        // FIXME
        return -1;
    }
}