import java.util.*;
import java.io.File;
import java.io.IOException;
public class mantoothv01
{
   public static void main(String[]args) throws IOException
   {
      Scanner s = new Scanner(new File("binary.txt"));
      while(s.hasNext())
      {
      String base2 = s.nextLine();
      int base10 = baseten(base2);
      display(base2, base10);
      }
   }
   public static int baseten(String btw)
   {
   int bt = 0;
   int num = 1;
   while(btw.length()>0)
   {
      String n = btw.substring(btw.length()-1);
      if(n.equals("1"))
      {
         bt+=num;
      }
      num*=2;
      btw = btw.substring(0, btw.length()-1);
   }
   return bt;
   }
   
   public static void display(String basetwo, int baseten)
   {
      System.out.println(basetwo+" in base 2 equals "+baseten+" in base ten.");
   }
}
   