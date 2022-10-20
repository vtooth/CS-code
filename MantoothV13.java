import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
public class MantoothV13 extends Canvas
{
    TestTaker [][] grid;
    /**Sets up the GUI window
     *Do not alter this code*/
    JFrame frame = new JFrame("Lab 13");
    static Graphics g;
    public void windowSetup()
    {
        Dimension size = new Dimension(1200,800);
        frame.setPreferredSize(size);
        frame.setMinimumSize(size);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
    }
    public void draw()
    {
        BufferStrategy buffer = this.getBufferStrategy();
        if(buffer==null){this.createBufferStrategy(3);return;}
        g = buffer.getDrawGraphics();
        drawDesks();
        g.dispose();
        buffer.show();
    }
    public void render(Graphics g){}
    public MantoothV13()
    {
        fillDesks();
        windowSetup();
        while(true)
            draw();
    }
    public static void main(String[] args)
    {
        new MantoothV13();
    }
    /*Display the seating chart */
    public void drawDesks()
    {
        g.setFont(new Font("Courier New",0,30));
        /*Displays a single rectangle on the screen with the following parameters
         *(x start, y start, width, height)*/
        for(int r =0;r<grid.length;r++)
            for(int c=0;c<grid[0].length;c++)
             {
                 g.setColor(Color.black);
                 g.drawRect(c*200+50,r*100+50,150,75);
                /*Displays a String on the screen with the following parameters
                 *(String to display, x value, y value)*/
                 if(grid[r][c]!=null)
                 {
                     g.drawString(""+grid[r][c].getNumber()+" :"+grid[r][c].getID(),c*200+58,r*100+85);
                        g.drawString(""+grid[r][c].getAvg(),c*200+110,r*100+120);
                 }
             }
    }
    public void fillDesks()
    {
        grid =  new TestTaker[6][5];
        ArrayList<TestTaker>list = new ArrayList<TestTaker>();
        for(int s=0; s<30; s++)
        {
            list.add(new TestTaker(s+1));
        }
        for(int r = 0; r<grid.length; r++)
           for(int c = 0; c<grid[0].length; c++)
           {
               int rand = (int)(Math.random()*list.size());
               grid[r][c] = list.get(rand);
               list.remove(rand);
           }
    }
}
class TestTaker
{
    private int id,t1,t2,t3,avg, number;
    public TestTaker(int n)
    {
        id = (int)(Math.random()*8999+1000);
        t1 = (int)(Math.random()*41+60);
        t2 = (int)(Math.random()*41+60);
        t3 = (int)(Math.random()*41+60);
        avg = getAvg();
        number = n;
    }
    public int getAvg()
    {
        return (t1+t2+t3)/3;
    }
    public int getID()
    {
        return id;
    }
    public String toString()
    {
        return id+" : "+"\tTest 1 : "+t1+"\tTest 2 : "+t2+"\tTest 3 : "+t3+"\tAvg : "+getAvg();
    }
    public void addT3()
    {
        t3+=(int)(Math.random()*5+1);
    }
    public int getNumber()
    {
        return number;
    }
}