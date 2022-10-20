import java.util.*;
public class MantoothV08
{
    public static void main(String[] args)
    {
        card[]deck = new card[52];
        deck[0] = new card("H", "A");
        deck[1] = new card("H", "2");
        deck[2] = new card("H", "3");
        deck[3] = new card("H", "4");
        deck[4] = new card("H", "5");
        deck[5] = new card("H", "6");
        deck[6] = new card("H", "7");
        deck[7] = new card("H", "8");
        deck[8] = new card("H", "9");
        deck[9] = new card("H", "10");
        deck[10] = new card("H", "J");
        deck[11] = new card("H", "Q");
        deck[12] = new card("H", "K");
        deck[13] = new card("D", "A");
        deck[14] = new card("D", "2");
        deck[15] = new card("D", "3");
        deck[16] = new card("D", "4");
        deck[17] = new card("D", "5");
        deck[18] = new card("D", "6");
        deck[19] = new card("D", "7");
        deck[20] = new card("D", "8");
        deck[21] = new card("D", "9");
        deck[22] = new card("D", "10");
        deck[23] = new card("D", "J");
        deck[24] = new card("D", "Q");
        deck[25] = new card("D", "K");
        deck[26] = new card("S", "A");
        deck[27] = new card("S", "2");
        deck[28] = new card("S", "3");
        deck[29] = new card("S", "4");
        deck[30] = new card("S", "5");
        deck[31] = new card("S", "6");
        deck[32] = new card("S", "7");
        deck[33] = new card("S", "8");
        deck[34] = new card("S", "9");
        deck[35] = new card("S", "10");
        deck[36] = new card("S", "J");
        deck[37] = new card("S", "Q");
        deck[38] = new card("C", "K");
        deck[39] = new card("C", "A");
        deck[40] = new card("C", "2");
        deck[41] = new card("C", "3");
        deck[42] = new card("C", "4");
        deck[43] = new card("C", "5");
        deck[44] = new card("C", "6");
        deck[45] = new card("C", "7");
        deck[46] = new card("C", "8");
        deck[47] = new card("C", "9");
        deck[48] = new card("C", "10");
        deck[49] = new card("C", "J");
        deck[50] = new card("C", "Q");
        deck[51] = new card("C", "K");
        Scanner numbers = new Scanner(System.in);
        int choice = 0;
        int points = 0;
        while(choice!=4)
        {
            System.out.println("1.) Display the player's points");
            System.out.println("2.) Pull a card from the deck");
            System.out.println("3.) Reset");
            System.out.println("4.) Exit");
            System.out.println("Pick an option (1-4)");
            choice = numbers.nextInt();
            if(choice == 1)
                System.out.print("Total Points: "+points+"\n");   
            if(choice == 2)
            {int r = (int)(Math.random()*52+0);
                if(deck[r] != null)
                {
                    if(deck[r]!=null)
                        {deck[r].pull();
                        points+=deck[r].getpoints();
                        deck[r] = null;}
                }
            }
            if(choice == 3)
               {deck[0] = new card("H", "A");
                deck[1] = new card("H", "2");
                deck[2] = new card("H", "3");
                deck[3] = new card("H", "4");
                deck[4] = new card("H", "5");
                deck[5] = new card("H", "6");
                deck[6] = new card("H", "7");
                deck[7] = new card("H", "8");
                deck[8] = new card("H", "9");
                deck[9] = new card("H", "10");
                deck[10] = new card("H", "J");
                deck[11] = new card("H", "Q");
                deck[12] = new card("H", "K");
                deck[13] = new card("D", "A");
                deck[14] = new card("D", "2");
                deck[15] = new card("D", "3");
                deck[16] = new card("D", "4");
                deck[17] = new card("D", "5");
                deck[18] = new card("D", "6");
                deck[19] = new card("D", "7");
                deck[20] = new card("D", "8");
                deck[21] = new card("D", "9");
                deck[22] = new card("D", "10");
                deck[23] = new card("D", "J");
                deck[24] = new card("D", "Q");
                deck[25] = new card("D", "K");
                deck[26] = new card("S", "A");
                deck[27] = new card("S", "2");
                deck[28] = new card("S", "3");
                deck[29] = new card("S", "4");
                deck[30] = new card("S", "5");
                deck[31] = new card("S", "6");
                deck[32] = new card("S", "7");
                deck[33] = new card("S", "8");
                deck[34] = new card("S", "9");
                deck[35] = new card("S", "10");
                deck[36] = new card("S", "J");
                deck[37] = new card("S", "Q");
                deck[38] = new card("C", "K");
                deck[39] = new card("C", "A");
                deck[40] = new card("C", "2");
                deck[41] = new card("C", "3");
                deck[42] = new card("C", "4");
                deck[43] = new card("C", "5");
                deck[44] = new card("C", "6");
                deck[45] = new card("C", "7");
                deck[46] = new card("C", "8");
                deck[47] = new card("C", "9");
                deck[48] = new card("C", "10");
                deck[49] = new card("C", "J");
                deck[50] = new card("C", "Q");
                deck[51] = new card("C", "K");
                points = 0;
            }
        }
    }
}
class card
{
    private int points;
    private String suit, name;
    public card(String s, String n)
    {
        suit = s;
        name = n;
        if(name.equals ("A"))
            points = 11;
        if(name.equals( "2"))
            points = 2;
        if(name.equals( "3"))
            points = 3;
        if(name.equals("4"))
            points = 4;
        if(name.equals( "5"))
            points = 5;
        if(name.equals( "6"))
            points = 6;
        if(name.equals( "7"))
            points = 7;
        if(name.equals( "8"))
            points = 8;
        if(name.equals("9"))
            points = 9;
        if(name.equals( "10")|| name.equals( "J" )|| name.equals("Q" )|| name.equals("K"))
            points = 10;
    }
    public void pull()
    {
       System.out.println("Card Pulled: "+name+""+suit+"\n");
    }
    public int getpoints()
    {
        return points;
    }
}
