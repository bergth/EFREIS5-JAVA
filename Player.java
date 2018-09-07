public class Player
{
    // name of the player
    String name;

    // result of upper and lower section
    int[] upper_section = {0,0,0,0,0,0};
    int[] lower_section = {0,0,0,0,0,0,0};
    String[] upper_section_name = {
        "Aces",
        "Twos",
        "Threes",
        "Fours",
        "Fives",
        "Sixes"
    };
    String[] lower_section_name = {
        "3 of kind",
        "4 of king",
        "Full House",
        "Sm.Straight",
        "Lg.Straight",
        "YAHTZEE",
        "Chance"
    };

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

        System.out.printf("┌─────────────────────────┐\n");
        System.out.printf("│ UPPER SECTION           │\n");
        System.out.printf("├──────────────────┬──────┤\n");
        
        for(int i = 0; i < upper_section.length; i++)
        {
            System.out.printf("│ %2d.  %11s ",i+1,upper_section_name[i]);
            if(choice_possible_upper[0] == -1)
                System.out.printf("│ %4d │",upper_section[i]);
            else
                System.out.printf("│      │");
            if(choice_possible_upper[i] > 0)
                System.out.print(" <- " + choice_possible_upper[i]);
            System.out.println("");
        }
        
        System.out.printf("├──────────────────┼──────┤\n");
        System.out.printf("│ TOTAL SCORE      │ %4d │\n",total_upper);
        System.out.printf("│ BONUS (> 63)     │ %4d │\n",bonus_upper);
        System.out.printf("│ TOTAL UPPER      │ %4d │\n",total_upper_bonus);
        System.out.printf("├──────────────────┴──────┤\n");
        System.out.printf("│ LOWER SECTION           │\n");
        System.out.printf("├──────────────────┬──────┤\n");
        
        for(int i = 0; i < lower_section.length; i++)
        {
            System.out.printf("│ %2d.  %11s ",i+7,lower_section_name[i]);
            if(choice_possible_lower[0] == -1)
                System.out.printf("│ %4d │",lower_section[i]);
            else
                System.out.printf("│      │");
            if(choice_possible_lower[i] > 0)
                System.out.print(" <- " + choice_possible_lower[i]);
            System.out.println("");
        }
        
        System.out.printf("├──────────────────┼──────┤\n");
        System.out.printf("│ each bonus       │ %4d │\n",each_bonus);
        System.out.printf("│ score 100 bonus  │ %4d │\n",score_100);
        System.out.printf("├──────────────────┼──────┤\n");
        System.out.printf("│ GRAND TOTAL      │ %4d │\n",grand_total);
        System.out.printf("└──────────────────┴──────┘\n");

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