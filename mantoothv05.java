import java.util.*;
import java.io.File;
import java.io.IOException;

public class mantoothv05 {
	public static void main(String[] args) throws IOException
	{
	Scanner s = new Scanner(new File("thanos.txt"));
		while(s.hasNextLine())
		{
			String temp = s.nextLine();
			String temp2 = "";
			for(int i = 0; i<temp.length(); i++)
			{
				if(temp.substring(i, i+1).equals("<")||temp.substring(i, i+1).equals(">")||temp.substring(i, i+1).equals("(")||temp.substring(i, i+1).equals(")")||temp.substring(i, i+1).equals("{")||temp.substring(i, i+1).equals("}")||temp.substring(i, i+1).equals("[")||temp.substring(i, i+1).equals("]"))
				{
               temp2 += temp.substring(i, i+1);
				}
				else
				{
					temp2 +="";
				}
			}
			if(temp2.length()%2!=0)
			{
            System.out.println("incorrect");
			}
			else
			{
				if(possible(temp2))
				{
					System.out.println("correct");
				}
				else
					System.out.println("incorrect");
			}
		}
	}
	
	public static boolean possible(String thing)
	{
	 Stack<String> thingy = new Stack<String>();
    boolean possible = true;
    for(int i = 0; i<thing.length(); i++)
    {
    String temp = thing.substring(i, i+1);
    
    if(temp.equals("<")||temp.equals("(")||temp.equals("{")||temp.equals("["))
    {
    thingy.push(temp);
    
    }
    else
    {
      if(temp.equals(">"))
      {  
         if(thingy.peek().equals("<"))
            {thingy.pop();
            }
         else
            possible = false;
      }
      if(temp.equals("}"))
      {
         if(thingy.peek().equals("{"))
            {thingy.pop();
            }
         else
            possible = false;
      }
      if(temp.equals("]"))
         {if(thingy.peek().equals("["))
            {thingy.pop();
            }
         else
            {possible = false;}}
      if(temp.equals(")"))
         {if(thingy.peek().equals("("))
            {thingy.pop();
            }
         else
            {possible = false;}}
         }  
    }
    return possible;
    } 
	 
	 
}














