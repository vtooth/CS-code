import java.util.*;
import java.io.File;
import java.io.IOException;
public class mantoothv02
{
   public static void main(String[]args)throws IOException
   {
      Scanner s = new Scanner(new File("numbers.txt"));
      while(s.hasNext()) 
      {
         String line = s.nextLine();
         int base = Integer.parseInt(line.substring(0,line.indexOf(" ")));
         String num = line.substring(line.indexOf(" ")+1);  
         System.out.println(num+" in base "+base+" equals:");
         System.out.println("Base 2\t:\t"+Base2(base, num));
         System.out.println("Base 8\t:\t"+Base8(base, num));
         System.out.println("Base 10\t:\t"+Base10(base, num));
         System.out.println("Base 16\t:\t"+Base16(base, num));
      }
   }
   
   public static String Base2(int b,String n)
   {
    int num = Base10(b, n);
    if(num == 0)
    {
    return "0";
    }
    String a = "";
    while(num>0)
    {
    a = num%2 + a;
    num /=2;
    }
    return a;
   }
   public static String Base8(int b,String n)
   {
    int num = Base10(b, n);
    if(num == 0)
    {
    return "0";
    }
    String a = "";
    while(num>0)
    {
    a = num%8 + a;
    num /=8;
    }
    return a;
   }
   public static int Base10(int b ,String n)
   { 
      int a = 0;
      if(b == 10)
      {
         a = Integer.parseInt(n);
         return a;
      }
      
      if(b < 10)
      {
         int num = Integer.parseInt(n);
         int val = 1;
         while(num>0)
         {
            a += (num%10)*val;
            num /= 10;
            val *= b;  
         }
      }
      if(b >10)
      {
      String next ="";
      int val = 1;
      while(n.length()>0)
      {
      next = n.substring(n.length()-1);
      n = n.substring(0, n.length()-1);
      if(next.equals("a")||next.equals("A"))
         a+=10*val;
      else
      if(next.equals("b")||next.equals("B"))
         a+=11*val;
      else
      if(next.equals("c")||next.equals("C"))
         a+=12*val;
      else
      if(next.equals("d")||next.equals("D"))
         a+=13*val;
      else
      if(next.equals("e")||next.equals("E"))
         a+=14*val;
      else
      if(next.equals("f")||next.equals("F"))
         a+=15*val;
      else
      {
         int ne = Integer.parseInt(next);
         a+=ne*val;
      }
      val*=b;
      }
      
      }
      return a;
   }
   public static String Base16(int b,String n)
   {
      int num = Base10(b, n);
    if(num == 0)
    {
    return "0";
    }
    String a = "";
    while(num>0)
    {
    String c = ""+num%16;
    if(c.equals("10"))
    {
    c = "A";
    }
    if(c.equals("11"))
    {
    c = "B";
    }
    if(c.equals("12"))
    {
    c = "C";
    }
    if(c.equals("13"))
    {
    c = "D";
    }
    if(c.equals("14"))
    {
    c = "E";
    }
    if(c.equals("15"))
    {
    c = "F";
    }
    a = c + a;
    num /=16;
    }
    return a;
   }  
}

