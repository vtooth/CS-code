//Shuffle the cards
import java.util.*;
public class MantoothV11
{
  static int val = 0;
  static ArrayList<card>deck = new ArrayList<card>();
  static ArrayList<card>hand = new ArrayList<card>();
  static ArrayList<card>player = new ArrayList<card>();
    public static void main(String [] args)
  {
    int choice = 0;
    Scanner input = new Scanner(System.in);
    while(choice !=7)
    {
        menu();
        reset("H");
        reset("S");
        reset("C");
        reset("D");
        choice = input.nextInt();
        if(choice == 1)
        {
            display();
        }
        if(choice == 2)
        {
           reset();
        }
        if(choice == 3)
        {
            sort();
        }
        if(choice == 4)
        {
            delete();
        }
        if(choice==5)
        {
            shuffle();
        }
        if(choice==6)
        {
            pull();
        }
    }
  }
  public static void menu()
  {
    System.out.println("\n1) Display the cards");
    System.out.println("2) Reset the deck");
    System.out.println("3) Sort the deck");
    System.out.println("4) Delete a suit");
    System.out.println("5) Shuffle the deck");
    System.out.println("6) Pull a card");
    System.out.println("7) Exit");
    System.out.print("Pick an option\t");
  }
  public static void display()
  {
      System.out.println("\nThe deck has "+deck.size()+" cards in it  :");
      for(int spot = 0; spot<deck.size(); spot++)
         {
             System.out.print(" "+deck.get(spot)+" ");
         }
      System.out.println("\nThe player has "+player.size()+" cards   :");
      for(int spot = 0; spot<player.size(); spot++)
          System.out.println(" "+player.get(spot)+" ");
      System.out.println("Total value = "+val);
      
  }
  public static void reset()
  {
      int y = hand.size();
      for(int spot = 0; spot<y; spot++)
          hand.remove(0);
      reset("H");
      reset("S");
      reset("C");
      reset("D");
      int x = deck.size();
      for(int spot = 0; spot<x; spot++)
          deck.remove(0);
      Scanner input = new Scanner(System.in);
      System.out.print("How many cards do you want in the deck?");
      int amount = input.nextInt();
      while(amount>52 || amount<0)
      {
          System.out.print("\nHow many cards do you want in the deck");
          amount = input.nextInt();
      }
      System.out.println("The deck has "+amount+" cards in it   :");
      for(int spot = 0; spot<amount; spot++)
      {
        int r = (int)(Math.random()*hand.size());
        deck.add(spot, hand.remove(r));
      }
      display();
  }
  public static void reset(String s)
  {
      for(int spot = 1; spot<=13; spot++)
    {
        if(spot == 1)
            hand.add(spot-1, new card("A", s, 11));            
        else
        if(spot == 11)
            hand.add(spot-1, new card("J", s, 10));
        else
        if(spot == 12)
            hand.add(spot-1, new card("Q", s, 10));
        else
        if(spot == 13)
            hand.add(spot-1, new card("K", s, 10));
        else
            hand.add(spot-1, new card(""+spot, s, spot));
    }
  }
  public static void sort()
  {
      for (int j = 0; j < deck.size()-1; j++)
      {
          int m = j;
          for(int k = j+1; k<deck.size(); k++)
          {
              if(deck.get(k).value() < deck.get(m).value())
              {
                  m = k;
              }
          }
          card temp = deck.get(j);
          deck.set(j, deck.get(m));
          deck.set(m, temp);
      }
  }
  public static void delete()
  {
      System.out.println("1) Hearts H");
      System.out.println("2) Diamonds D");
      System.out.println("3) Clubs C");
      System.out.println("4) Spades S");
      Scanner input = new Scanner(System.in);
      int c = input.nextInt();
      if(c == 1)
      {
          for(int spot = deck.size()-1; spot>=0; spot--)
              {
                  if(deck.get(spot).getSuit() == "H")
                  {
                     deck.remove(spot); 
                  }
              }
      }
      if(c == 2)
      {
          for(int spot = deck.size()-1; spot>=0; spot--)
              {
                  if(deck.get(spot).getSuit() == "D")
                  {
                     deck.remove(spot); 
                  }
              }
      }
      if(c==3)
      {
          for(int spot = deck.size()-1; spot>=0; spot--)
              {
                  if(deck.get(spot).getSuit() == "C")
                  {
                     deck.remove(spot); 
                  }
              }
      }
      if(c==4)
      {
          for(int spot = deck.size()-1; spot>=0; spot--)
              {
                  if(deck.get(spot).getSuit() == "S")
                  {
                     deck.remove(spot); 
                  }
              }
      }
  }
  public static void shuffle()
  {
      for(int spot = 0; spot<deck.size(); spot++)
      {
          int r = (int)(Math.random()*deck.size());
          card temp1 = deck.get(spot);
          card temp2 = deck.get(r);
          deck.set(spot, temp2);
          deck.set(r, temp1);
      }
  }
  public static void pull()
  {
      int r = (int)(Math.random()*deck.size());
      card temp = deck.get(r);
      deck.remove(r);
      int index = 0;
      System.out.print(" "+temp);
      if(player.size()==0)
      {
        player.add(0, temp);
      }
      else
      {
       while(index<player.size()&&temp.value()<player.get(index).value())
           index++;
       player.add(index, temp);
       val+=player.get(index).value();  
      }
      }
  } 
class card
{
    private String name, suit;
    private int value;
    public card(String n, String s, int v)
    {
        value = v;
        name = n;
        suit = s;
    }
    public String toString()
    {
        return name + suit;
    }
    public String getSuit()
    {
        return suit;
    } 
    public int value()
    {
        return value;
    }
}