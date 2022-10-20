// Double.parseDouble(s) turns a String into a double. Int.parseInt(s) turns a String into an int
import java.util.*;
public class MantoothV19
{
    public static void main(String [] args)
    {
      radius();
      area();
      chars();
      integer();
      decimal();
      System.out.println("Press any key to continue...");
    }
    public static void radius()
    {
      Scanner numbers = new Scanner(System.in);
      System.out.println("What is the radius? ");
      String radius = numbers.nextLine();
      double r = Double.parseDouble(radius);
      double area = Math.PI*r*r;
      String a = ""+area;
      System.out.println("The area of the circle is "+a);
    }
    public static void area()
    {
        Scanner numbers = new Scanner(System.in);
        System.out.println("What is the length? ");
        String length = numbers.nextLine();
        int l = Integer.parseInt(length);
        System.out.println("What is the width? ");
        String width = numbers.nextLine();
        int w = Integer.parseInt(width);
        int area = l*w;
        String a = ""+area;
        System.out.println("The area of the rectangle is "+a);
    }
    public static void chars()
    {
        Scanner numbers = new Scanner(System.in);
        System.out.println("Enter a character: ");
        String character = numbers.nextLine();
        char c = character.charAt(0);
        int ch = (int)(c);
        double cha = (double)(c);
        System.out.println(c+" equals "+ch+" and "+cha);
    }
    public static void integer()
    {
        Scanner numbers = new Scanner(System.in);
        System.out.println("Enter a whole number: ");
        int integer = numbers.nextInt();
        char i = (char)(integer);
        double in = (double)(integer);
        System.out.println(integer+" equals "+i+" and "+in);
    }
    public static void decimal()
    {
        Scanner numbers = new Scanner(System.in);
        System.out.println("Enter a decimal number: ");
        double decimal = numbers.nextDouble();
        char d = (char)(decimal);
        int de = (int)(decimal);
        System.out.println(decimal+" equals "+d+" and "+de);
    }
}