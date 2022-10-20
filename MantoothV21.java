import java.util.*;
public class MantoothV21
{
    public static void main(String [] args)
    {
       Scanner numbers = new Scanner(System.in);
       String text = numbers.nextLine();
       for(int i = 0; i<text.length(); i++)
       {
           String s = text.substring(i,i+1);
           String x = s;
           if(s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u"))
           {
               while(x.equals(s))
               {
                   int rand = (int)(Math.random()*5+1);
                   if(rand == 1)
                   {
                       x = "a";
                   }
                   if(rand == 2)
                   {
                       x = "e";
                   }
                   if(rand == 3)
                   {
                       x = "i";
                   }
                   if(rand == 4)
                   {
                       x = "o";
                   }
                   if(rand == 5)
                   {
                       x = "u";
                   }
               }
           }
           if(s.equals("A") || s.equals("E") || s.equals("I") || s.equals("O") || s.equals("U"))
           {
               while(x.equals(s))
               {
                   int rand = (int)(Math.random()*5+1);
                   if(rand == 1)
                   {
                       x = "A";
                   }
                   if(rand == 2)
                   {
                       x = "E";
                   }
                   if(rand == 3)
                   {
                       x = "I";
                   }
                   if(rand == 4)
                   {
                       x = "O";
                   }
                   if(rand == 5)
                   {
                       x = "U";
                   }
               }
           }
           System.out.print(x);
       }
       System.out.println("\n");
    }
}