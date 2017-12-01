package general;

import java.util.ArrayList;

import cell.Cell;
import cell.CellSplitter;

public class Field {
	
	int width;
	int height;
	public ArrayList<Cell> cells;
	
	public Field(int wid, int ht){
		
		width = wid;
		height = ht;
		cells = new ArrayList<Cell>();
		cells.add(new CellSplitter(new Team()));
		cells.get(0).setX(200);
		cells.get(0).setY(200);
		
	}
	
}
