package graphics;

import java.awt.Graphics;

import cell.Cell;

public class CellRenderer {
	
	public boolean ShouldRender(int top, int bot, int left, int right)
	{
		return true;//TODO make real
	}
	
	public void RenderAt(Cell c,int x, int y, Graphics window)
	{
		int sz = (int)c.size();
		window.setColor(c.getTeam().getColor());
		window.fillOval(x-sz, y-sz, sz*2, sz*2);
		System.out.println("rendering");
	}
	
}
