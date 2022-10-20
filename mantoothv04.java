import java.util.*;
import java.io.File;
import java.io.IOException;
public class mantoothv04
{
   public static void main(String [] args)throws IOException
   {
   Scanner s = new Scanner(new File("words.txt"));
   DataStructure<String> words = new DataStructure<String>();
   while(s.hasNext())
   {
   words.add(s.nextLine());
   }
   }
}
class DataStructure <E>
{
   private Object[]arr = new Object[0];
   public String toString()
   {
      String temp = "";
      for(int i = arr.length-1; i>=0; i--)
      {
          temp += arr[i]+" ";
      }
      return temp;
   }
   
   public void add(E thing)
   {
   Object[]temp = new Object[arr.length+1];
   for(int i = 0; i<arr.length; i++)
   {
   temp[i] = arr[i];
   }
   temp[temp.length-1] = thing;
   arr = temp;
   }
   
   public E removeEnd()
   {
   E thing = (E)arr[arr.length-1];
   Object[]temp = new Object[arr.length-1];
   for(int i = 0; i<temp.length; i++)
   {
   temp[i] = arr[i];
   }
   arr = temp;
   return thing ;
   }
   
   public E end()
   {
     return (E)arr[arr.length-1];
   }
   
   public void distance(E thing)
   {
      int index = -1;
      for(int i = 0; i<arr.length; i++)
      {
         if(arr[i].equals(thing))
         {
         index = i;
         }
      }
      if(index !=-1)
         System.out.println(arr.length - (index+1));
      else
      System.out.println(""+thing+" isn't in the list");
   }
   
   public boolean empty()
   {
      if(arr.length == 0)
         return true;
      return false;
   }
    
}