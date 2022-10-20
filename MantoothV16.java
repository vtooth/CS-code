import java.util.*;
public class MantoothV16
{
    public static void main(String [] args)
    {
        double cash = money();
        System.out.println("Bills");
        System.out.println("----------");
        System.out.print("Hundreds:\t");
        System.out.println((int)(cash)/100);
        cash %=100;
        System.out.print("Fifties: \t");
        System.out.println((int)(cash)/50);
        cash %=50;
        System.out.print("Twenties:\t");
        System.out.println((int)(cash)/20);
        cash %=20;
        System.out.print("Tens:    \t");
        System.out.println((int)(cash)/10);
        cash %=10;
        System.out.print("Fives:   \t");
        System.out.println((int)(cash)/5);
        cash %=5;
        System.out.print("Ones:    \t");
        System.out.println((int)(cash)/1);
        cash %=1;
        System.out.println("\n\nCoins");
        System.out.println("----------");
        cash*=100;
        System.out.print("Quarters:\t");
        System.out.println((int)(cash)/25);
        cash%=25;
        System.out.print("Dimes:   \t");
        System.out.println((int)(cash)/10);
        cash%=10;
        System.out.print("Nickles: \t");
        System.out.println((int)(cash)/5);
        cash%=5;
        System.out.print("Pennies: \t");
        System.out.println((int)(cash)/1);
    }
    public static double money()
    {
        Scanner numbers = new Scanner(System.in);
        double dollars;
        System.out.print("\nHow much money\t");
        dollars = numbers.nextDouble();
        System.out.println(dollars+"\n");
        return dollars;
    }
}