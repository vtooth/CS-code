import java.util.*;
import java.net.*;
import java.io.*;
public class MantoothV26
{

   static ArrayList<Words>ListofWords = new ArrayList<Words>();
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
      ArrayList<String> linesOfText = new ArrayList<String>();
		linesOfText=readText(linesOfText);
		linesOfText=formatText(linesOfText);
      fill(linesOfText);
      sort(); 
      for(int i = 0; i<ListofWords.size(); i++)
      {
         if(ListofWords.get(i).getWord().equals(""))
         {
            ListofWords.remove(i);
         }
      }
      int totalwords = countWords(linesOfText);
      int uniquewords = ListofWords.size();
      double avg = AverageLength();
      System.out.println("This text : ");
      System.out.println("Contains "+totalwords+" words and "+uniquewords+" unique words");
      System.out.println("Each word has an average length of "+avg+" letters");
      System.out.println("The top fifteen most common words are : ");
      topFifteen();
      System.out.println("What word would you like to find?");
      String word = input.nextLine();
      int amount = occurances(word);
      System.out.print("The word \""+word+"\" was found "+amount+" times");
   }
   public static void fill(ArrayList<String> Lines)
   {
      for(int i = 0; i<Lines.size(); i++)
      {
         String [] arr = Lines.get(i).split(" ");
         for(int s = 0; s<arr.length; s++)
         {
            arr[s] = arr[s].toLowerCase();
            if(inside(arr[s]) == -1)
                  {ListofWords.add(new Words(arr[s]));}
            else
               {ListofWords.get(inside(arr[s])).increment();}
         }
            
      }
   }
   
   
   public static int inside(String word)
   {
      for(int i =0; i<ListofWords.size(); i++)
      {
         if(ListofWords.get(i).getWord().equals(word))
            return i;
      }
      return -1;
   }
   
   public static void sort()
   {
      for(int j = 1; j< ListofWords.size(); j++)
      {
      Words temp = ListofWords.get(j);
      int possibleIndex = j;
      while(possibleIndex > 0 && temp.getRepeats() < ListofWords.get(possibleIndex - 1).getRepeats())
      {
         ListofWords.set(possibleIndex, ListofWords.get(possibleIndex-1));
         possibleIndex--;
      }
      ListofWords.set(possibleIndex, temp);
      }
   }
   
   public static int countWords(ArrayList<String> text)
   {
      int count = 0;
      for(int i = 0; i<ListofWords.size(); i++)
      {
         count += ListofWords.get(i).getRepeats();
      }
      return count;
   }
   
   public static double AverageLength()
   {
      double sum = 0;
      double amount = 0;
      for(int i = 0; i<ListofWords.size(); i++)
      {
         sum +=(ListofWords.get(i).getWord().length()*ListofWords.get(i).getRepeats());
         amount +=ListofWords.get(i).getRepeats();
      }
      if(amount>0)
      {double total = sum/amount;
      total *=100;
      total = (int)(total);
      total /=100.0;
      return total;}
      return 0; 
   }
   
   public static void topFifteen()
   {
      for(int i = ListofWords.size()-1; i>=ListofWords.size()-16; i--)
      {
         System.out.println(ListofWords.get(i).getWord()+" : "+ListofWords.get(i).getRepeats());
      }
   }
   public static int occurances(String word)
   {
      for(int i = 0; i < ListofWords.size(); i++)
      {
         if(ListofWords.get(i).getWord().equals(word))
            return ListofWords.get(i).getRepeats();
      }
      return 0;
   }
   
	/*Reads a .txt file from the internet and stores each line as
	 *a String in an ArrayList.
	 *If there is a problem reading the file from the internet:
	 *	1.) comment out the line with the first "String website"
	 *	2.) take the comments off of the line after that
	 *  3.) have the pride.txt file in the same folder as the .java file
	*/
	public static ArrayList<String> readText(ArrayList<String> text)
	{
		String website = "http://archive.org/stream/TheEpicofGilgamesh_201606/eog_djvu.txt";
		//String website = "";
		try{URL url = new URL(website);Scanner s = new Scanner(url.openStream());while(s.hasNext())text.add(s.nextLine());}
		catch(Exception e){try{Scanner s = new Scanner(new File("pride.txt"));while(s.hasNext())text.add(s.nextLine());}catch(Exception ex){}}
		return text;
	}
	/*Removes the extra html formatting associated with the file.
	 *Removes everything except for letters and spaces from the text.
	*/
	public static ArrayList<String> formatText(ArrayList<String> text)
	{	for(int line =0;line<text.size();line++)
		{	String s = text.get(line);
			if(s.contains("The Epic Of Gilgamesh")&&!s.contains("<"))
			{	for(int a=line-1;a>=0;a--)text.remove(a);break;}}
		for(int line =0;line<text.size();line++)
		{	String s = text.get(line);
			text.set(line,text.get(line).replaceAll("[^a-zA-Z ]",""));
			if(s.contains("</pre>"))for(int a=line-5;a<text.size();text.remove(a));}
		return text;
	}
   }
   
   class Words
   {
    private String word;
    private int repeats; 
    public Words(String w)
    {
    word = w;
    repeats = 1;
    }  
    public void increment()
    {
      repeats ++;
    }
    public String getWord()
    {  
      return word;
    }
    public int getRepeats()
    {
      return repeats;
    }
   }
+