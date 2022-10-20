import java.util.*;
public class MantoothV10
{
  static card[]deck = new card[5];
    public static void main(String [] args)
  {
    int choice = 0;
    define();
    Scanner input = new Scanner(System.in);
    while(choice!=5)
      {
          menu();
          choice = input.nextInt();
          if(choice == 1)
          {
            for(int s = 0; s<deck.length; s++)
                deck[s].display();
            System.out.println("\n");
          }
          if(choice == 2)
          {
             arrange();
          }
          if(choice == 3)
          {
            if(order()==false)
            {
                System.out.print("The cards are out of order\n");
                for(int s = 0; s<deck.length; s++)
                    deck[s].display();
                System.out.println("\n");
            }
            if(order()==true)
            {
                System.out.print("The cards are in order\n");
                for(int s = 0; s<deck.length; s++)
                    deck[s].display();
                System.out.println("\n");
            }
          }
          if(choice == 4)
          {
              deck = add();
          }
        }
    }
    public static void menu()
  {
    System.out.println("\n1) Display the cards");
    System.out.println("2) Put the cards in order");
    System.out.println("3) Are they in order?");
    System.out.println("4) Add a new card");
    System.out.println("5) Exit");
    System.out.print("Pick an option (1-4)");
      
  }
  public static card[] add()
  {
      card[]temp = new card[deck.length+1];
      if(order() == true)
      {
          card[]t = new card[1];
          t[0] = new card();
          int Index = deck.length - 1;
          while(Index > 0 && t[0].value() < deck[Index].value())
          {
              temp[Index+1] = deck[Index];
              Index -- ; 
          }
          temp[Index+1] = t[0];
          while(Index >= 0)
            {
                temp[Index] = deck[Index];
                Index--;
            }
      }
      else
      {
          for(int spot=0; spot<temp.length;spot++)
              if(spot == 0)
              {
                temp[spot] = new card();
              }
              else
                  temp[spot] = deck[spot-1];
      }
      return temp;
  }
  public static boolean order()
  {
    for(int i = 0; i<deck.length-1; i++)
        for(int j = i+1; j<deck.length; j++)
            if(deck[j].value()<deck[i].value())
                return false;
    return true;
  }
  public static void arrange()
  {
            for(int i = 0; i < deck.length-1; i++)
            {
                int min = i;
                for(int j = i+1; j < deck.length; j++)
                    if(deck[min].value()>deck[j].value())
                    {
                        min = j;
                    }
                card[]swap = new card[1];
                swap[0] = deck[i];
                deck[i] = deck[min];
                deck[min] = swap[0];
                deck[i].display();
                System.out.println(" is the smallest");
                for(int spot = 0; spot< deck.length; spot++)
                    deck[spot].display();
                System.out.print("\n");
            
          }
  }
  public static void define()
  {
    for(int spot=0; spot<deck.length; spot++)
        deck[spot] = new card();
  }
}
class card
{
    private String suit, name;
    private int value, n, s;
    public card()
    {
        n = (int)(Math.random()*13+1);
        s = (int)(Math.random()*4+1);
        if(s == 1)
           suit = "H";
        if(s == 2)
           suit = "C";
        if(s == 3)
           suit = "S";
        if(s == 4)
           suit = "D";
        if(n == 1)
        {
            name = "A";
            value=11;
        }
        if(n == 2)
           {
            name = "2";
            value=2;   
           }
        if(n == 3)
           {
            name = "3";
            value=3;   
           } 
        if(n == 4)
           {
            name = "4";
            value=4;   
           }
        if(n == 5)
           {
            name = "5";
            value=5;   
           }
        if(n == 6)
           {
            name = "6";
            value=6;   
           }
        if(n == 7)
           {
            name = "7";
            value=7;   
           }
        if(n == 8)
           {
            name = "8";
            value=8;   
           }
        if(n == 9)
           {
            name = "9";
            value=9;   
           }
        if(n == 10)
           {
            name = "10";
            value=10;   
           }
        if(n == 11)
           {
            name = "J";
            value=10;   
           }
        if(n == 12)
           {
            name = "Q";
            value=10;   
           }
        if(n == 13)
           {
            name = "K";
            value=10;   
           }
    }
    public void display()
    {
        System.out.print(name+suit+" ");
    }
    public int value()
    {
        return value;
    }
}