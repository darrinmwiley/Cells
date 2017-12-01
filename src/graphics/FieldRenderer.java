package graphics;

import java.awt.Graphics;
import java.util.ArrayList;

import cell.Cell;
import general.Field;

public class FieldRenderer {
	
	public void render(int top, int bot, int left, int right, Field f, Graphics window)
	{
		ArrayList<Cell> cells = f.cells;
		for(Cell c:cells)
		{
			int cx = (int)c.getX();
			int cy = (int)c.getY();
			new CellRenderer().RenderAt(c, cx, cy, window);
		}
	}
	
	//TODO add a shouldRender function
}
