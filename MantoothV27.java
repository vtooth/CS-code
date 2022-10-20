import java.util.*;
import java.net.*;
import java.io.*;
public class MantoothV27
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
         for(int w = 0; w<ListofWords.get(i).getRepeats(); w++)
         { System.out.print(ListofWords.get(i).getWord()+", ");}
      
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
      for(int i = 0; i<ListofWords.size(); i++)
      {
         if(ListofWords.get(i).getWord().equals(""))
         {
            ListofWords.remove(i);
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
      for(int i = 1; i < ListofWords.size(); i++)
      {
      int possibleindex = i;
      Words temp =ListofWords.get(i); 
      while(possibleindex > 0 && temp.getWord().compareTo(ListofWords.get(possibleindex - 1).getWord())<0)
      {
         ListofWords.set(possibleindex, ListofWords.get(possibleindex-1));
         possibleindex --; 
      }
         ListofWords.set(possibleindex, temp);
      }
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
    public String toString() { return word; }
   }
