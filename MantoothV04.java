import java.util.*;
public class MantoothV04
{
    public static void main (String []args)
    {
        //variables
        double r, h;
        Scanner numbers= new Scanner(System.in);
        System.out.println("Violet Mantooth \nLab 04\n\n");
        System.out.println("Enter the radius");
        r = numbers.nextDouble();
        System.out.println("Enter the height");
        h = numbers.nextDouble();
        double SaCylinder = getSaCylinder(r,h);
        double SaCone = getSaCone(r,h);
        double VCylinder = getVCylinder(r,h);
        double VCone = getVCone(r,h);
        System.out.print("\nThe surface area of the cylinder is ");
        System.out.printf("%5.2f%n", SaCylinder);
        System.out.print("The surface area of the cone is ");
        System.out.printf("%5.2f%n", SaCone);
        System.out.println(" ");
        System.out.print("The volume of the cylinder is ");
        System.out.printf("%5.2f%n", VCylinder);
        System.out.print("The volume of the cone is ");
        System.out.printf("%5.2f%n", VCone);
    }
    public static double getArea(double r)
    {
      double  a = Math.PI*Math.pow(r,2);
      return a;
    }
    public static double getSaCylinder(double r, double h)
    {
      double SaCylinder =  (2*Math.PI*r*h)+(2*getArea(r));
      return SaCylinder;
    }
    public static double getSaCone(double r, double h)
    {
      double l = Math.sqrt(Math.pow(r,2)+Math.pow(h,2));
      double SaCone = (Math.PI*r*l)+(getArea(r));
      return SaCone;
    }
    public static double getVCylinder(double r, double h)
    {
      double VCylinder = getArea(r)*h;
      return VCylinder;
    }
    public static double getVCone(double r, double h)
    {
       double VCone = (getArea(r)/3)*h;
       return VCone;
    }
}