import java.util.*;
public class MantoothV20
{
    static ArrayList<String>strings = new ArrayList<String>();
    public static void main(String [] args)
    {
        System.out.print("\n\n\n");
        fill();
        display();
    }
    public static void fill()
    {
       int rand = (int)(Math.random()*21+10); 
       for(int r = 0; r<rand; r++)
       {
           String s = "";
           int random = (int)(Math.random()*21+5);
           for(int c = 0; c< random; c++)
           {
               int character = (int)(Math.random()*26+65);
               char cha = (char)(character);
               s += cha;
           }
           strings.add(s);
       }
    }
    public static void display()
    {
        int max = 0;
        for(int i = 0; i<strings.size(); i++)
        {
            //this doesn't run and needs to be debugged
            if(strings.get(i).length()>max)
            {
               max = strings.get(i).length(); 
            }
        }
        int a = max+2;
        for(int b = 0; b<a+2; b++)
        {
            System.out.print("*");
        }
        System.out.print("\n");
        System.out.print("*");
        for(int c = 0; c<a; c++)
        {
            System.out.print(" ");
        }
        System.out.print("*");
        System.out.print("\n");
        for(int y = 0; y<strings.size(); y++)
        {
            System.out.print("*");
            if(strings.get(y).length()%2==0)
            {
                int s = (a - strings.get(y).length())/2;
                for(int i = 0; i<s; i++)
                {
                    System.out.print(" ");
                }
                System.out.print(strings.get(y));
                for(int i = 0; i<s; i++)
                {
                    System.out.print(" ");
                }
            }
            else
            {
                int s1 = (a - strings.get(y).length())/2;
                int s2 = (a - strings.get(y).length())/2+1;
                for(int i = 0; i<s1; i++)
                {
                    System.out.print(" ");
                }
                System.out.print(strings.get(y));
                for(int i = 0; i<s2; i++)
                {
                    System.out.print(" ");
                }
            }
            System.out.print("*");
            System.out.print("\n");
        }
        System.out.print("*");
        for(int e = 0; e<a; e++)
        {
            System.out.print(" ");
        }
        System.out.print("*");
        System.out.print("\n");
        for(int d = 0; d<a+2; d++)
        {
            System.out.print("*");
        }
    }
}