import java.util.*;
public class MantoothV14
{
    /*Do not alter any existing code*/
    static ArrayList<Quote> quoteList = new ArrayList<Quote>();
       public static void populateList()
    {
        quoteList.add(new Quote("Grace Hopper","To me programming is more than an important practical art. It is also a gigantic undertaking in the foundations of knowledge."));
        quoteList.add(new Quote("Edsger Dysktra","The question of whether a computer can think is no more interesting than the question of whether a submarine can swim."));
        quoteList.add(new Quote("Ada Lovelace","I never am really satisfied that I understand anything; because, understand it well as I may, my comprehension can only be an infinitesimal fraction of all I want to understand about the many connections and relations which occur to me, how the matter in question was first thought of or arrived atů"));
        quoteList.add(new Quote("Alan Turing","One day [people] will take their computers for walks in the park and tell each other, \"My little computer said such a funny thing this morning\"."));
    }
       public static void main(String args[])
    {
        populateList();
        menu();
    }
    /*Complete the menu method*/
        public static void menu()
    {
        int choice=0;
        while(choice!=3)
        {
            System.out.println("1) Display all quotes");
            System.out.println("2) Display a random quote");
            System.out.println("3) Exit");
            System.out.print("Select an option\t");
            Scanner input = new Scanner(System.in);
            choice=input.nextInt();
            if(choice==1)
            {
                for(int s = 0; s<quoteList.size(); s++)
                {
                    drawQuote(quoteList.get(s).thing(),quoteList.get(s).name());
                }
            }
            if(choice==2)
            {
                int r = (int)(Math.random()*quoteList.size());
                drawQuote(quoteList.get(r).thing(),quoteList.get(r).name());
            }
        }
       }
    public static void drawQuote(String quote, String author)
    {
        System.out.println("============================================================");
        int q = quote.length();
        int c = 0;
        while(q>56)
        {
            int space=0;
            for(int spot = c+54; !quote.substring(spot, spot+1).equals(" ") && spot>=c; spot--)
            {
                space=spot;
            }
            if(quote.substring(c+54, c+55).equals(" "))
                space=c+54;
            System.out.print("| "+quote.substring(c, space));
            for(int s = 0; s<56-(space-c);s++)
            {
                System.out.print(" "); 
            }
            System.out.print(" |\n");
            q -= (space-c);
            c = space;
            } 
        System.out.print("| "+quote.substring(c));
        for(int b = 0; b<56-quote.substring(c).length(); b++)
            System.out.print(" ");
        System.out.print(" |\n");
        System.out.print("| ");
        for(int s = 0; s<56-author.length(); s++)
            System.out.print(" ");
        System.out.print(author+" |\n");
        System.out.println("============================================================");
    }
}
class Quote
{
    private String que, quien;
    public Quote(String whom, String what){
        quien = whom;
        que = what;
    }
    public  String name()
    {
        return quien;
    }
    public  String thing()
    {
        return que;
    }
}