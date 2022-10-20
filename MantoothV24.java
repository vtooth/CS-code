import java.util.*;
public class MantoothV24
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("ENTER A SENTENCE! :");
        String sentence = input.nextLine();
        sentence = sentence.toLowerCase();
        String[] arr = sentence.split(" ");
        System.out.print("\n\nThe monkey says :");
        for(int a = 0; a<arr.length; a++)
        {
            arr[a] = arr[a].replaceAll("[^a-z]","");
            arr[a] = arr[a].replaceAll("a","aaa");
            arr[a] = arr[a].replaceAll("e","eee");
            arr[a] = arr[a].replaceAll("i","iii");
            arr[a] = arr[a].replaceAll("o","ooo");
            arr[a] = arr[a].replaceAll("u","uuu");
            if(isVowel(arr[a].substring(0,1)))
            {
                arr[a] +="wook";
            }
            else
            {
               arr[a] = arr[a].substring(1) + arr[a].substring(0,1) + "eek"; 
            }
            System.out.print(arr[a] + " ");
        }
    }
    public static boolean isVowel(String letter)
    {
        if(letter.equals("a")|| letter.equals("e")||letter.equals("i")||letter.equals("o")||letter.equals("u"))
            return true;
        return false;
    }
}