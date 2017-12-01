package general;

import java.awt.Component;

import javax.swing.JFrame;

public class Launcher extends JFrame{
	
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	public Launcher()
	{
		super("CELLS");
	}
	
	public void start()
	{
		setSize(WIDTH,HEIGHT);
		
		Runner game = new Runner();
		((Component)game).setFocusable(true);
		
		getContentPane().add(game);
		
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Launcher launcher = new Launcher();
		launcher.start();
	}
	
}
