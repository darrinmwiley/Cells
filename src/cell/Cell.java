package cell;

import general.Team;

public abstract class Cell {

	int health,energy,maxHealth;
	double speed,xpos,ypos,size;
	Team team;
	boolean inPlay;
	
	public Cell(Team t)
	{
		team = t;
		speed = 1;
		size = 20;
	}
	
	public void setHealth(int x)
	{
		health = x;
	}
	
	public void damage(int x)
	{
		health-=x;
	}
	
	public void heal(int x)
	{
		health+=x;
	}
	
	public void setEnergy(int x)
	{
		energy = x;
	}
	
	public double size()
	{
		return size;
	}
	
	public Team getTeam()
	{
		return team;
	}
	
	public double getX()
	{
		return xpos;
	}
	
	public double getY()
	{
		return ypos;
	}
	
	public void setX(double x)
	{
		xpos = x;
	}
	
	public void setY(double x)
	{
		ypos = x;
	}
	//TODO needs many more methods
	
}
