import java.awt.*;//Canvas, Dimension
import javax.swing.JFrame;//JFrame
import java.awt.image.BufferStrategy;
import javax.imageio.*;
import java.awt.event.*;


public class Pong extends Canvas implements Runnable
{
	static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
   public Ball bouncer = new Ball();
   public RBar R = new RBar();
   public LBar L = new LBar();
   public Keyboard kevin = new Keyboard();
   
	public Pong()//Constructor
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
      bouncer.draw(g);
      R.draw(g);
      L.draw(g);
      System.out.print("hi");
      bouncer.Ltouch(L);
      bouncer.Rtouch(R);
		g.dispose();
		bs.show();
	}
	public void tick()
	{

	}

	public static void main(String args[])
	{
		new Pong();
	}
}
class Window extends Canvas
{
	public Window(int w, int h, String t, Pong game)
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
   
   class Ball
{
   public int x,y,w,h,xd,yd;
   static Image ball;
   String d;
   public Ball()
   {
      x = 315;
      y = (int)(Math.random()*181+150);
      h = 10;
      w = 10;
      d = "right";
      xd = 2;
      while(yd == 0||yd==1 || yd==-1)
      {yd = (int)(Math.random()*7-3);}
      try{ball=ImageIO.read(getClass().getResource("Pong-Ball.png"));} catch(Exception e){}
   }
   public void draw(Graphics g)
   {
      g.drawImage(ball,x,y,w,h,null);
      move();
   }
   public void move()
   {
    x+=xd;
    if(y<0 || y>450)
    {
      yd = -yd;
    }
    y+=yd;
    if(x>660||x<-20)
    {
      x = 320;
      if(d.equals("right"))
      {
        xd = -2;
        d = "left"; 
      }
      else
         {xd = 2;
         d = "right";}
      yd = (int)(Math.random()*5-2);
      while(yd == 0||yd==1 || yd==-1)
      {yd = (int)(Math.random()*7-3);}
      LBar.Reset();
      RBar.Reset();
    } 
   }
   public void Ltouch(LBar other)
   {
      if(this.x+this.w>other.x && this.y+this.h>other.y && this.y<other.y+other.h && this.x<other.x+other.w)
      {
         this.xd *=-1;
      }
   }
   public void Rtouch(RBar other)
   {
      if(this.x+this.w>other.x && this.y+this.h>other.y && this.y<other.y+other.h && this.x<other.x+other.w)
      {
         this.xd *=-1;
      }
   }
   
}
   class LBar
{
   static Image Bar1;
   public static int x,y,h,w;
   public LBar()
   {
   x = 40;
   y = 180;
   h = 120;
   w = 12;
   try{Bar1=ImageIO.read(getClass().getResource("Left-Barrier.png"));} catch(Exception e){}
   }
   public void draw(Graphics g)
   {
      g.drawImage(Bar1,x,y,w,h,null);
      move();
   }
   public void move()
   {
      if(Keyboard.w) y-=3;
      if(Keyboard.s) y+=3;
   }
   public static void Reset()
   {
   x = 40;
   y = 180;
   }
}

class RBar
{
   static Image Bar2;
   public static int x,y,h,w;
   public RBar()
   {
   x = 600;
   y = 180;
   h = 120;
   w = 12;
   try{Bar2=ImageIO.read(getClass().getResource("Right-Barrier.png"));} catch(Exception e){}
   }
   public void draw(Graphics g)
   {
      g.drawImage(Bar2,x,y,w,h,null);
      move();
   }
   public void move()
   {
      if(Keyboard.up) y-=3;
      if(Keyboard.down) y+=3;
   }
   public static void Reset()
   {
      x = 600;
      y = 180; 
   }
}


   
   class Keyboard implements KeyListener
{
    private boolean[] keys = new boolean[120];
    public static  boolean up,down,left,right,w,s,a,d,esc;

    public void update()
    {
        up = keys[KeyEvent.VK_UP];
        w = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN];
        s = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT]; 
        a = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT];
        d = keys[KeyEvent.VK_D];
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
 

