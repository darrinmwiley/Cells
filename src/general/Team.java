package general;

import java.awt.Color;

public class Team {
	
	Color color;
	
	public Team(Color c)
	{
		color = c;
	}
	
	public Team()
	{
		this(Color.CYAN);
	}
	
	public Color getColor()
	{
		return color;
	}
	
}
