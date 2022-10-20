import java.util.*;
import java.io.File;
import java.io.IOException;
public class mantoothv03
{
   public static void main(String[]args)throws IOException
   {
      Scanner s = new Scanner(new File("morenumbers.txt"));
      while(s.hasNext()) 
      {
         String line = s.nextLine();
         int basef = Integer.parseInt(line.substring(0,line.indexOf(" ")));
         line = line.substring(line.indexOf(" ")+1);
         String num = line.substring(0, line.indexOf(" "));
         line = line.substring(line.indexOf(" ")+1);
         if(line.equals(" 3"))
         line = "3";
         int baset = Integer.parseInt(line.substring(0));
         if(possible(basef, num))
         {if(baset == 10)
         System.out.println(num+" in base "+basef+" is equal to "+Base10(basef, num)+" in base "+baset);
         if(baset < 10)
         System.out.println(num+" in base "+basef+" is equal to "+Baselow(basef, num, baset)+" in base "+baset);
         if(baset > 10)
         System.out.println(num+" in base "+basef+" is equal to "+Basehigh(basef, num, baset)+" in base "+baset);}
         else
         System.out.println(num+" is invalid in base "+basef); 
      }
   }
   public static boolean possible(int bf, String n)
   {
   for(int i = 0; i<n.length(); i++)
   {
      String s = n.substring(i, i+1);
      if(s.equals("A")|| s.equals("a"))
      {
      s = "10";
      }
      if(s.equals("B")|| s.equals("b"))
      {
      s = "11";
      }
      if(s.equals("C")|| s.equals("c"))
      {
      s = "12";
      }
      if(s.equals("D")|| s.equals("d"))
      {
      s = "13";
      }
      if(s.equals("E")|| s.equals("e"))
      {
      s = "14";
      }
      if(s.equals("F")|| s.equals("f"))
      {
      s = "15";
      }
      if(Integer.parseInt(s)>=bf)
         return false;
      }
      return true;
   }
   public static String Baselow(int bf,String n,int bt)
   {
    int num = Base10(bf, n);
    if(num == 0)
    {
    return "0";
    }
    String a = "";
    while(num>0)
    {
    a = num%bt + a;
    num /=bt;
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
   public static String Basehigh(int bf,String n, int bt)
   {
      int num = Base10(bf, n);
    if(num == 0)
    {
    return "0";
    }
    String a = "";
    while(num>0)
    {
    String c = ""+num%bt;
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
    num /=bt;
    }
    return a;
   }  
}

