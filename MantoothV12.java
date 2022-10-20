import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
public class  MantoothV12 extends Canvas
{   private static Student [][]students;
    /**Sets up the GUI window
     *Do not alter this code*/
    JFrame frame = new JFrame("Lab 12");
    static Graphics g;
    public void windowSetup()
    {
        Dimension size = new Dimension(1200,800);frame.setPreferredSize(size);frame.setMinimumSize(size);
        frame.setLocationRelativeTo(null);frame.add(this);frame.setVisible(true);
    }
    public void draw()
    {
        BufferStrategy buffer = this.getBufferStrategy();
        if(buffer==null){this.createBufferStrategy(3);return;}
        g = buffer.getDrawGraphics();drawDesks();g.dispose();buffer.show();
        try{Thread.sleep(10);}catch(Exception e){}
    }
    public MantoothV12()
    {
        fillDesks();
        windowSetup();
        while(true)    draw();
    }
    public static void main(String[] args){new MantoothV12();}
    public void drawDesks()
    {
       for(int r = 0; r<students.length; r++){
           for(int c = 0; c<students[0].length; c++){
                /*Changes the Font to 30 point Arial*/
                g.setFont(new Font("Courier New",0,30));
                /*Displays a single rectangle on the screen with the following parameters
                *(x start, y start, width, height)*/
                g.setColor(Color.black);
                g.drawRect(180*c+50,90*r+50,150,75);
                if(students[r][c].getAvg()<80){
                    g.setColor(Color.yellow);
                    g.fillRect(180*c+51, 90*r+51, 149, 74);
                    g.setColor(Color.black);
                }
                /*Displays a String on the screen with the following parameters
                *(String to display, x value, y value)*/
                g.drawString(""+students[r][c].getID(),85+c*180,80+r*90);
                g.drawString(""+students[r][c].getAvg(),100+c*180, 120+r*90);
           }
       }
    }
    public void fillDesks()
    {
    students = new Student[(int)(Math.random()*6+2)][(int)(Math.random()*5+1)];
    for(int r = 0; r<students.length; r++)
        for(int c = 0; c<students[0].length; c++)
            students[r][c] = new Student();
    }
}
class Student
{
    private int id,t1,t2,t3,avg;
    public Student()
    {
        id = (int)(Math.random()*8999+1000);
        t1 = (int)(Math.random()*41+60);
        t2 = (int)(Math.random()*41+60);
        t3 = (int)(Math.random()*41+60);
        avg = getAvg();
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
}