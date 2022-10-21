import java.util.*;
import java.io.File;
import java.io.IOException;
public class mantoothv08
{
   public static void main(String[]args)throws IOException
   {
      Scanner s = new Scanner(new File("emails.txt"));
      while(s.hasNextLine())
      {
         String thing = s.nextLine();
         if(check(thing))
            System.out.println(thing+" is valid");
         else
            System.out.println(thing+" is invalid");
      }
   }
   
   public static boolean check(String thing)
   {
      return thing.matches("[^@^\\s]+@\\w+\\.[^@^\\s]*");
   }
}