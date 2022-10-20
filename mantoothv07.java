import java.util.*;
import java.io.File;
import java.io.IOException;

class mantoothv07
{
   public static void main(String[]args)throws IOException
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
      for(int i = 0; i<arr.length; i++)
      {
      temp += arr[i];
      temp +=" ";
      }
      return temp;
   }
   
   public void add(E thing)
   {
      Object[] temp = new Object[arr.length+1];
      for(int i = 0; i<arr.length; i++)
      {
         temp[i] = arr[i];
      } 
      temp[arr.length] = thing;
      arr = temp;
   }
   
   public E remove()
   {
      Object[] temp = new Object[arr.length-1];
      E thing = (E)(arr[0]);
      for(int i = 0; i<temp.length; i++)
      {
         temp[i] = arr[i+1]; 
      }
      arr = temp;
      return thing;
   }
   
   public E first()
   {
      if(arr.length>0)
         return (E)(arr[0]);
      return null;
   }
   
   public boolean empty()
   {
      if(arr.length == 0)
         return true;
      return false;
   }
} 