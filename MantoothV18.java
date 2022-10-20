import java.util.*;
public class MantoothV18
{
    public static void main(String args[])
    {
        Scanner numbers = new Scanner(System.in);
        String message = CodeWordHelper.getMessage();
        System.out.println("Enter an integer");
        int n=numbers.nextInt();
        String[][] array = toArray(message,n);
        display(array);
        code(array);
        code(array);

    }
    public static String[][] toArray(String m, int n)
    {   
        int r = m.length()/n;
        if(m.length()%n!=0)
        {
          r++;  
        }
        int l = 0;
        String [][] thing = new String[r][n];
        for(int row = 0; row<thing.length; row++)
        {
          for(int col = 0; col<thing[0].length; col++)
          {
              if(l+1<=m.length())
              {thing[row][col] = m.substring(l, l+1);
              l++;}
              else
              {
                  thing[row][col]=" ";
              }
          }
        }
        return thing;
    }
    public static void display(String[][] arr)
    { 
        for(int r=0; r<arr.length; r++)
        {
          for(int c=0; c<arr[0].length; c++)
          {
              System.out.print(arr[r][c]);
          }
          System.out.print("\n");
        }
    }
    public static void code(String[][] arr)
    {
        System.out.println("\n--------------\nSwap\n\n");
        String temp = "";
        for(int r = 0; r<arr.length; r++)
        {
            for(int c = 0; c<arr[0].length-1; c+=2)
            {
               temp = arr[r][c];
               arr[r][c] = arr[r][c+1];
               arr[r][c+1] = temp;
            }
        }
        display(arr);
    }
}
class CodeWordHelper
{
    public static String getMessage()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("This is a secret message");
        list.add("This is not a secret message");
        list.add("The condor flies at midnight");
        list.add("The eagle has landed");
        list.add("Mine is in the repair shop");
        list.add("That is not the code word");
        list.add("A warped barrel is a fool's frustration");
        list.add("Drink more Ovaltine");
        list.add("The field mouse is fast, the owl sees at night");
        list.add("Water the marigolds");
        list.add("Supercalifragilisticexpialidocious");
        list.add("The forests of Timber sure have changed");
        list.add("Could I borrow a match");
        list.add("The red fox trots quietly at midnight");
        return list.get((int)(Math.random()*list.size()));
    }
}
