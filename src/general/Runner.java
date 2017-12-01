package general;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import graphics.FieldRenderer;

public class Runner extends Canvas implements Runnable{
	
	boolean gameRunning;
	private BufferedImage back;
	Field field;
	
	public Runner()
	{
		field = new Field(800,600);
	}
	
	public void run()
	{
		long lastFpsTime = 0;
		int fps = 0;
		long lastLoopTime = System.nanoTime();
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;   
		
		// keep looping round til the game ends
		while (gameRunning)
		{
			// work out how long its been since the last update, this
			// will be used to calculate how far the entities should
			// move this loop
			long now = System.nanoTime();
			long updateLength = now - lastLoopTime;
			lastLoopTime = now;
			double delta = updateLength / ((double)OPTIMAL_TIME);
			
			// update the frame counter
			lastFpsTime += updateLength;
			fps++;
			
			// update our FPS counter if a second has passed since
			// we last recorded
			if (lastFpsTime >= 1000000000)
			{
			   System.out.println("(FPS: "+fps+")");
			   lastFpsTime = 0;
			   fps = 0;
			}
			
			// update the game logic
			tick();
			
			// draw everyting
			repaint();
			
			// we want each frame to take 10 milliseconds, to do this
			// we've recorded when we started the frame. We add 10 milliseconds
			// to this and then factor in the current time to give 
			// us our final value to wait for
			// remember this is in ms, whereas our lastLoopTime etc. vars are in ns.
			try{
				Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
			}catch(Exception ex){ex.printStackTrace();}
		}
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}
	
	public void tick()
	{
		
	}
	
	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		
		new FieldRenderer().render(0, 600, 0, 800, field, graphToBack);
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
}
