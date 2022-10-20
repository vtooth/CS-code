import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.applet.Applet;
import java.awt.image.*;
import java.util.*;

//For this lab, all programming should be completed in the Mr. Handy class
//make sure that you change the file name "RobcoStarter" in all 3 places

public class MantoothV23 extends Panel  //change RobcoStarter to your file name
{
	Image image;Graphics graphics;
	MrHandy codsworth = new MrHandy();Neighborhood neighborhood = new Neighborhood();
	public static void main(String[] args)
	{
  		Frame f = new Frame();f.addWindowListener(new java.awt.event.WindowAdapter() {
       		public void windowClosing(java.awt.event.WindowEvent e) {System.exit(0);};});
       	//---------------------
  		MantoothV23 window = new MantoothV23();  //change RobcoStarter to your file name (two times on this line)
  		//---------------------
  		window.setSize(1300,475);f.add(window);f.pack();f.setSize(1300,475);f.show();
	}
	public void update(Graphics g)
	{if(image==null){image=createImage(this.getWidth(),this.getHeight());graphics = image.getGraphics();}
		graphics.setColor(getBackground());graphics.fillRect(0,0,this.getWidth(),this.getHeight());
		graphics.setColor(getForeground());paint(graphics);g.drawImage(image,0,0,this);}
	public void paint(Graphics g)
	{neighborhood.draw(g);codsworth.draw(g,neighborhood.getStreet());delay(10);repaint();}
	public static void delay(int n)	{long startDelay = System.currentTimeMillis();long endDelay = 0;while (endDelay - startDelay < n)endDelay = System.currentTimeMillis();	}
}
class MrHandy extends Robco
{
	/*draws the Mr. Handy unit and moves it in its current direction*/
	public void draw(Graphics g, House[] street)
	{
		super.draw(g,street);
	}
	/*finds the next house to cut*/
	public int findNext(House[] street)
	{
		int index = 0;
      int max = 0;
      for(int a = 0; a<street.length; a++)
      {
      if(street[a].getGrass()>max)
      {
      max = street[a].getGrass();
      index = a;
      }
      }
      setNext(index);
      return index;
	}
	/*points the unit in the correct direction for the next house to cut*/
	public void direction(int i)
	{K
   if(getSpot()>getNext())
   {
   setEast(false);    
   }
   else
   if(getSpot()<getNext())
   {
   setEast(true);
   }
   }
}
