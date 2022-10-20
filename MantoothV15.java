import java.util.*;
public class MantoothV15
{
    public static void main(String args [])
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number");
        int number = input.nextInt();
        factors(number);
    }
    public static void factors(int num)
    {
        int x = 2;
        while(x<num)
        {
            if(num %x == 0)
            {
                System.out.print(x+"\t");
                num /=x;
                x = num;
                factors(num);
            }
            else
            {
                x++;
                if(x == num)
                System.out.println(x+"\n");
            }
        }
    }
}