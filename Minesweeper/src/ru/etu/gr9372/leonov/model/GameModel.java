package ru.etu.gr9372.leonov.model;

import java.util.Random;

import ru.etu.gr9372.leonov.controller.Controller;


public class GameModel {
	
	private Controller gameController;
	private Cell[][] cellField;
	private int rows;
	private int cols;
	private int gameTime;
	
	public GameModel(int rows, int cols) {
		cellField = new Cell[rows][cols];
		this.rows = rows;
		this.cols = cols;
		this.gameTime = 0;
		initField();
	}
	
	public void initController(Controller controller) {
		this.gameController = controller;
	}
	
	public void changeProperty(int oper, int curRow, int curCol) {
		switch(oper) {
		case Cell.CELL_LMB:
			if (tapCell(curRow, curCol) == false) {
				gameOver();
				initField();
			}
			break;
		case Cell.CELL_RMB:
			tickCell(curRow, curCol);
			break;
		case Cell.C_NEW:
			initField();
			break;
		}
		if (finishGame()) {
			gameController.winGame();
			initField();
		}
		notifyController();
	}

	public void notifyController() {
		gameController.updateProperty(cellField, rows, cols);
	}
	
	private void initField() {
		int minesCount = (int)(rows * cols * 0.16);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				cellField[i][j] = new Cell();
			}
		}
		
		Random random = new Random();
		for (int i = 0; i < minesCount; i++) {
			int mineCol, mineRow;
			do {
				mineRow = random.nextInt(rows);
				mineCol = random.nextInt(cols);
			} while (checkMineInCell(mineRow, mineCol));
			cellField[mineRow][mineCol].setMineState(true);
		}
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (!cellField[i][j].isMineState()) {
					int minesAround = 0;
					for (int k = -1; k < 2; k++) {
						if (checkMineInCell(i + k, j - 1)) {
							minesAround++;
						}
						if (checkMineInCell(i + k, j + 1)) {
							minesAround++;
						}
						if (checkMineInCell(i + k, j) && (i + k) != i) {
							minesAround++;
						}
					}
					cellField[i][j].setMinesCount(minesAround);
				}
			}
		}
	}
	
	public boolean checkMineInCell(int curRow, int curCol) {
		if (curRow < 0 || curRow >= rows || curCol < 0 || curCol >= cols) {
			return false;
		}
		return  cellField[curRow][curCol].isMineState();
	}
	
	public void tickCell(int curRow, int curCol) {	
		switch(cellField[curRow][curCol].getCellState()) {
		case Cell.CELL_CLOSE:
			cellField[curRow][curCol].setCellState(Cell.CELL_TICK);
			break;
		case Cell.CELL_TICK:
			cellField[curRow][curCol].setCellState(Cell.CELL_CLOSE);
			break;
		}
	}
	
	private void gameOver() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (cellField[i][j].isMineState()) {
					cellField[i][j].setCellState(Cell.CELL_OPEN);
				}
			}
		}
		gameController.loseGame();
	}
	
	private void openAround(int curRow, int curCol) {
		int minI, minJ, maxI, maxJ;
		
		minI = (curRow <= 0 ? 0 : curRow - 1);
		minJ = (curCol <= 0 ? 0 : curCol - 1);
		maxI = (curRow >= rows - 1 ? rows : curRow + 2);
		maxJ = (curCol >= cols - 1 ? cols : curCol + 2);
	
		for (int i = minI; i < maxI; i++) {
			for (int j = minJ; j < maxJ; j++) {
				if ((checkMineInCell(i, j) == false)&&(cellField[i][j].getCellState() == Cell.CELL_CLOSE)) {
					cellField[curRow][curCol].setCellState(Cell.CELL_OPEN);
					if (cellField[curRow][curCol].getMinesCount() == 0) {
						openAround(i, j);
					}
				}
			}
		}
		
	}
	
	public boolean tapCell(int curRow, int curCol) {
		if (cellField[curRow][curCol].getCellState() == Cell.CELL_CLOSE || 
				cellField[curRow][curCol].getCellState() == Cell.CELL_TICK) {
			if (cellField[curRow][curCol].getMinesCount() == 0) {
				openAround(curRow, curCol);
			}
			if (cellField[curRow][curCol].isMineState()) {
				return false;
			}
		}
		cellField[curRow][curCol].setCellState(Cell.CELL_OPEN);
		return true;
	}
	
	public boolean finishGame() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) { 
				if ((!cellField[i][j].isMineState()) && (cellField[i][j].getCellState() != Cell.CELL_OPEN)) {
					return false;
				}
			}
		}
		return true;
	}

	public int getGameTime() {
		return gameTime;
	}

	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}
	
	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}
	
	public Cell[][] getCellField() {
		return cellField;
	}
	
}
