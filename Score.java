import java.util.Arrays;

public class Score
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
        int[] dices_result = {1,1,1,1,1};
    
        // bonuses 
        int each_bonus = 0;
        int score_100 = 0;
    
        // Information about the possible choice for a round after the roll of dices
        // -1 = already set, 0 = no choice possible, > 0 = score possible if chosen
        int[] choice_possible_upper = {0,0,0,0,0,0};
        int[] choice_possible_lower = {0,0,0,0,0,0,0};
    
    
        /**
         * Print the actual array of results with sugestion of choices
         * 
         */

        public void get_dices_result(int[] val)
        {
            dices_result = val;
        }

        public void print_result()
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
    
            int grand_total = total_lower + total_upper_bonus;
    
            System.out.printf("+-------------------------+\n");
            System.out.printf("| UPPER SECTION           |\n");
            System.out.printf("+-------------------------+\n");
            
            for(int i = 0; i < upper_section.length; i++)
            {
                System.out.printf("| %2d.  %11s ",i+1,upper_section_name[i]);
                if(choice_possible_upper[i] == -1)
                    System.out.printf("| %4d |",upper_section[i]);
                else
                    System.out.printf("|      |");
                if(choice_possible_upper[i] > 0)
                    System.out.print(" <- " + choice_possible_upper[i]);
                System.out.println("");
            }
            
            System.out.printf("+------------------+------+\n");
            System.out.printf("| TOTAL SCORE      | %4d |\n",total_upper);
            System.out.printf("| BONUS (> 63)     | %4d |\n",bonus_upper);
            System.out.printf("| TOTAL UPPER      | %4d |\n",total_upper_bonus);
            System.out.printf("+------------------+------+\n");
            System.out.printf("| LOWER SECTION           |\n");
            System.out.printf("+------------------+------+\n");
            
            for(int i = 0; i < lower_section.length; i++)
            {
                System.out.printf("| %2d.  %11s ",i+7,lower_section_name[i]);
                if(choice_possible_lower[i] == -1)
                    System.out.printf("| %4d |",lower_section[i]);
                else
                    System.out.printf("|      |");
                if(choice_possible_lower[i] > 0)
                    System.out.print(" <- " + choice_possible_lower[i]);
                System.out.println("");
            }
            
            System.out.printf("+------------------+------+\n");
            System.out.printf("| each bonus       | %4d |\n",each_bonus);
            System.out.printf("| score 100 bonus  | %4d |\n",score_100);
            System.out.printf("+------------------+------+\n");
            System.out.printf("| GRAND TOTAL      | %4d |\n",grand_total);
            System.out.printf("+------------------+------+\n");
    
        }    



        private void find_upper_choices()
        {
            for(int i = 0; i < dices_result.length; i++)
            {
                int curr = dices_result[i];
                if(choice_possible_upper[curr-1] != -1)
                {
                    choice_possible_upper[curr-1] += curr;
                }
            }
        }
    
        /**
         * Find by reading 'dice_result' and filling 'choice_possible_upper'
         * if a user can do a 3 or 4 of a king, full house or Yahtzee
         */
        public void find_kind()
        {
            int[] nb = {0,0,0,0,0,0};
            int res = 0;
            for(int i = 0; i < dices_result.length; i++)
            {
                nb[dices_result[i]-1] += 1;
                res += dices_result[i];
            }
    
            int max = 0;
            int index_max = 0;
            for(int i = 0; i < nb.length; i++)
            {
                if(nb[i] > max)
                {
                    max = nb[i];
                    index_max = i;
                }
            }
    
            if(max == 3)
            {
                boolean full_house = false;
                if(choice_possible_lower[2] != -1)
                {
                    for(int i = 0; i < nb.length; i++)
                    {
                        if(i != index_max && nb[i] == 2)
                        {
                            full_house = true;
                        }
                    }
                    if(full_house)
                    {
                        choice_possible_lower[2] = 25;
                    }
                }
                if(choice_possible_lower[0] != -1)
                    choice_possible_lower[0] = res;
            }
            
            if(max == 4 && choice_possible_lower[1] != -1)
            {
                choice_possible_lower[1] = res;
            }
    
            if(max == 5 && choice_possible_lower[5] != -1)
            {
                choice_possible_lower[5] = 50;
            }
        }
        
    
    
        /**
         * Find by reading 'dice_result' and filling 'choice_possible_upper'
         * if a user can do a small or large Straight
         */
        public void find_straight()
        {
    
            int compt = 1;
            if(choice_possible_lower[3] != -1 || choice_possible_lower[4] != -1)
            {
                int max = 0;
    
                for(int i = 0; i < dices_result.length - 1; i++)
                {
                    if(dices_result[i] == dices_result[i+1] - 1)
                    {
                        compt += 1;
                    }
                    else if(dices_result[i] != dices_result[i+1])
                    {
                        if(compt > max)
                        {
                            max = compt;
                            compt = 1;
                        }
                    }
                }
                if(compt > max)
                    max = compt;
    
                if(max >= 5 && choice_possible_lower[4] != -1)
                    choice_possible_lower[4] = 40;
    
                if(max >= 4 && choice_possible_lower[3] != -1)
                    choice_possible_lower[3] = 30;
            }
        }
    
    
        /**
         * Find by reading 'dice_result' and filling 'choice_possible_lower'
         * if a user can do a chance
         */
        public void find_chance()
        {
            if(choice_possible_lower[6] != -1)
            {
                int res = 0;
                for(int i = 0; i < dices_result.length; i++)
                {
                    res += dices_result[i];
                }
                choice_possible_lower[6] = res;
            }
        }
    
        void find_choice()
        {
            Arrays.sort(dices_result);
            find_upper_choices();
            find_kind();
            find_straight();
            find_chance();
        }
    
        void set_choice(int choix)
        {
            if(choix >= 0 && choix <= 13)
            {
                if(choix <= 6)
                {
                    if(choice_possible_upper[choix-1] != -1)
                    {
                        upper_section[choix-1] = choice_possible_upper[choix-1];
                        choice_possible_upper[choix-1] = -1;
                    }
                }
                else
                {
                    if(choice_possible_lower[choix-7] != -1)
                    {
                        lower_section[choix-7] = choice_possible_lower[choix-7];
                        choice_possible_lower[choix-7] = -1;
                    }
                }
            }
        }
    

        public void clean_arrays()
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
    

        /**
        * @return true if the player fills all the arrays.
        */

        public boolean is_end()
        {
            int i;
            for (i = 0; i < 6; i++) { //Look if all choices of upper part are empty or not
                if (choice_possible_upper[i] != -1)
                    return false;
            }
            for (i = 0; i < 7; i++) { //Look if all choices of lower part are empty or not
                if (choice_possible_lower[i] != -1)
                    return false;
            }
        return true;
        }

        /**
        * 
        * @return the grand total score (to be used at the end of a game)
        */
        public int get_result()
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

            return total_lower + total_upper_bonus;
        }

        public int[] get_choice_upper()
        {
            return choice_possible_upper;
        }

        public int[] get_choice_lower()
        {
            return choice_possible_lower;
        }
}

