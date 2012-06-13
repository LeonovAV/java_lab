package ru.etu.gr9372.leonov.model;

public class Cell {
	private int minesCount;
	private boolean mineState;
	private int cellState;
	
	public static final int CELL_CLOSE = 0;
	public static final int CELL_OPEN = 1;
	public static final int CELL_TICK = 2;
	
	public static final int CELL_LMB = 1;
	public static final int CELL_RMB = 2;

	public static final int C_OPEN = 1;
	public static final int C_TICK = 2;
	public static final int C_PAUSE = 3;
	public static final int C_NEW = 4;
	public static final int C_EXIT = 5;
	
	public Cell() {
		minesCount = 0;
		mineState = false;
		cellState = Cell.CELL_CLOSE;
	}
	
	public int getMinesCount() {
		return minesCount;
	}
	
	public void setMinesCount(int minesCount) {
		this.minesCount = minesCount;
	}
	
	public boolean isMineState() {
		return mineState;
	}
	
	public void setMineState(boolean mineState) {
		this.mineState = mineState;
	}
	
	public int getCellState() {
		return cellState;
	}
	
	public void setCellState(int cellState) {
		this.cellState = cellState;
	}
	
}
