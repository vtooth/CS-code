import java.awt.*;//Canvas, Dimension
import javax.swing.JFrame;//JFrame
import java.awt.image.BufferStrategy;
import javax.imageio.*;
import java.awt.event.*;


public class GamePt1 extends Canvas implements Runnable
{
	static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private Thing t = new Thing();
   Thing one = new Thing();
   Thing two = new Thing();
   Thing three = new Thing();
   Thing four = new Thing();
   Keyboard kevin = new Keyboard();
   Turtle oink = new Turtle();
   
	public GamePt1()//Constructor
	{
		new Window(WIDTH, HEIGHT, "Game", this);
      addKeyListener(kevin);
        requestFocus();
	}

	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running =true;
	}
	public synchronized void stop()
	{
		try
		{
			thread.join();
			running = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void run()
	{
      
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 /amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames =0;
		while(running)
		{
         try{Thread.sleep(3);}catch(Exception e){}
			long now = System.nanoTime();
			delta+= (now - lastTime) / ns;
			lastTime = now;
			while(delta>=1)
			{
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer+=1000;
				System.out.println("FPS: "+frames);
				frames = 0;
			}


			}
			stop();

	}
	public void render()
	{
		kevin.update();
      BufferStrategy bs = this.getBufferStrategy();
		if(bs==null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0,0,WIDTH,HEIGHT);
		t.draw(g);
      oink.draw(g);
      one.draw(g);
      two.draw(g);
      three.draw(g);
      four.draw(g);
      t.collide(one);
      t.collide(two);
      t.collide(three);
      t.collide(four);
      t.collide(oink);
      one.collide(two);
      one.collide(three);
      one.collide(four);
      one.collide(oink);
      two.collide(three);
      two.collide(four);
      two.collide(oink);
      three.collide(four);
      three.collide(oink);
      four.collide(oink);
		g.dispose();
		bs.show();
	}
	public void tick()
	{

	}

	public static void main(String args[])
	{
		new GamePt1();
	}
}
class Window extends Canvas
{
	public Window(int w, int h, String t, GamePt1 game)
	{
		JFrame frame = new JFrame(t);
		frame.setPreferredSize(new Dimension(w,h));
		frame.setMinimumSize(new Dimension(w,h));
		frame.setMaximumSize(new Dimension(w,h));

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(game);
		frame.setVisible(true);
		game.start();

	}
}
class Thing
{
	int x,y,w,h,xd,yd,r,green,b;
   String d;
   Image asteroid;
	public Thing()
	{
      try{asteroid=ImageIO.read(getClass().getResource("duck.png"));} catch(Exception e){}
      
		x=(int)(Math.random()*620);
		y=(int)(Math.random()*480);
		w=50;
		h=50;
      xd = (int)(Math.random()*11-5);
      yd = (int)(Math.random()*11-5);
      r = (int)(Math.random()*256);
      green = (int)(Math.random()*256);
      b = (int)(Math.random()*256);
	}
	public void draw(Graphics g)
	{
		g.setColor(new Color(r, green, b));
		 g.drawImage(asteroid,(int)x,(int)y,(int)(w),(int)(h),null);
		move();
	}
	public void move()
	{
      if(x<0 || x>630)
      {
         xd = -xd;
      }
      if(y<0 || y>450)
      {
         yd = -yd;
      }
      x += xd;
      y += yd;   
	}
   public void collide(Thing other)
   {
      if(this.x+this.w>other.x && this.y+this.h>other.y && this.y< other.y+other.h && this.x < other.x+other.w)
      {
         this.xd *=-1;
         this.yd *=-1;
         other.xd *=-1;
         other.yd *=-1;
      }
   }
   public void resize(int size)
   {
      h = size;
      w = size;
   }
}   
class Turtle extends Thing
{
   public Turtle()
   {
      try{asteroid=ImageIO.read(getClass().getResource("turtle.png"));} catch(Exception e){}
      super.resize(100);
   }   
   public void move()
   {
   if(Keyboard.up) y-=3;
   if(Keyboard.down) y+=3;
   if(Keyboard.left) x-=3;
   if(Keyboard.right) x+=3;
   }
}

   
   class Keyboard implements KeyListener
{
    private boolean[] keys = new boolean[120];
    public static  boolean up,down,left,right, /*space,*/ esc;

    public void update()
    {
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN]|| keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT]|| keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT]|| keys[KeyEvent.VK_D];
    //    space = keys[KeyEvent.VK_SPACE];
        esc = keys[KeyEvent.VK_ESCAPE];


    }
    public void keyPressed(KeyEvent e)
    {
        keys[e.getKeyCode()] = true;
    }
    public void keyReleased(KeyEvent e)
    {
        keys[e.getKeyCode()] = false;
    }
    public void keyTyped(KeyEvent e)
    {

    }

}
