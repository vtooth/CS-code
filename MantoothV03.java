import java.util.Scanner;
public class MantoothV03
{
    public static void main(String args[])
    {
        Scanner numbers=new Scanner(System.in);
        double leg1;
        double leg2;
        double hypotenuse;
        double radius;
        double area;
        double circumference;
        double volume;
        double largestNumber;
        System.out.println("Violet Mantooth");
        System.out.println("Lab 03");
        System.out.println(" ");
        System.out.println("Enter the first leg of the triangle");
        leg1 = numbers.nextDouble();
        System.out.println("Enter the second leg of the traingle");
        leg2 = numbers.nextDouble();
        hypotenuse = Math.sqrt(Math.pow(leg1,2)+(Math.pow(leg2,2)));
        System.out.print("The hypotenuse of the triangle is");
        System.out.printf("%5.2f%n", hypotenuse);
        System.out.println(" ");
        System.out.println("Enter the radius of the circle");
        radius = numbers.nextDouble();
        area = Math.PI*Math.pow(radius,2);
        circumference = 2*Math.PI*radius;
        volume = 4/3*Math.PI*Math.pow(radius,3);
        System.out.print("The circumference of the circle is ");
        System.out.printf("%5.2f%n", circumference);
        System.out.print("The area of the circle is ");
        System.out.printf("%5.2f%n", area);
        System.out.print("The volume of the sphere is ");
        System.out.printf("%5.2f%n", volume);
        System.out.println("--------------");
        System.out.println("Extra Credit");
        System.out.println(" ");
        largestNumber = Math.max(leg1,Math.max(leg2, radius));
        System.out.println("The largest number entered was "+largestNumber);
        
    }
}

    
        