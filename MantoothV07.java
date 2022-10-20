import java.util.*;
public class MantoothV07
{
    public static void main(String args[])
    {
        rolling();
    }
    public static int Money()
    {
        Scanner numbers = new Scanner(System.in);
        int dollars;
        System.out.println("How many dollars do you have?");
        dollars = numbers.nextInt();
        return dollars;
    }
    public static int rollDice()
    {
        int Die1, Die2, Sum;
        Die1 = (int)(Math.random()*6+1);
        Die2 = (int)(Math.random()*6+1);
        Sum = Die1+Die2;
        return Sum;
    }
    public static void rolling()
    {
        int dollars = Money();
        int Rollnum = 0;
        int maxmoney = dollars;
        int maxroll = 0;
        while(dollars > 0)
        {
            int sum = rollDice();
            if(sum == 7)
                dollars+=4;
            if(sum !=7)
                dollars--;
            if(maxmoney < dollars)
            {
                maxmoney = dollars;
                maxroll = Rollnum;
            }
            Rollnum ++;
        }
        System.out.println("You are broke after "+Rollnum+" rolls");
        System.out.println("You should have quit after "+maxroll+" rolls, when you had "+maxmoney+" dollars");
        System.out.println("Press any key to continue...");
    }
}