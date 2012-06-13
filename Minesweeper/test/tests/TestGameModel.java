package tests;

import junit.framework.Assert;

import org.junit.Test;

import ru.etu.gr9372.leonov.model.Cell;
import ru.etu.gr9372.leonov.model.GameModel;

public class TestGameModel {
	
	@Test
	public void testGameModelCols() {
		GameModel gameModel = new GameModel(0, 10);
		Assert.assertEquals(10, gameModel.getCols());
	}
	
	@Test
	public void testGameModelRows() {
		GameModel gameModel = new GameModel(5, 0);
		Assert.assertEquals(5, gameModel.getRows());
	}
	
	@Test
	public void testGameModelTime() {
		GameModel gameModel = new GameModel(5, 5);
		Assert.assertEquals(0, gameModel.getGameTime());
	}
	
	@Test
	public void testGameModelSetTime() {
		GameModel gameModel = new GameModel(3, 3);
		gameModel.setGameTime(10);
		Assert.assertEquals(10, gameModel.getGameTime());
	}
	
	@Test
	public void testCheckMineInCellTrue() {
		GameModel gameModel = new GameModel(3, 3);
		Cell[][] cellField = gameModel.getCellField();
		cellField[0][0].setMineState(true);
		Assert.assertTrue(gameModel.checkMineInCell(0, 0) == true);
	}
	
	@Test
	public void testCheckMineInCellFalse() {
		GameModel gameModel = new GameModel(3, 3);
		Cell[][] cellField = gameModel.getCellField();
		cellField[0][0].setMineState(false);
		Assert.assertEquals(false, gameModel.checkMineInCell(0, 0));
	}
	
	@Test
	public void testCheckMineInCellCoordsNegative() {
		GameModel gameModel = new GameModel(3, 3);
		Assert.assertEquals(false, gameModel.checkMineInCell(-1, -1));
	}
	
	@Test
	public void testCheckMineInCellBiggerCoords() {
		GameModel gameModel = new GameModel(3, 3);
		Assert.assertEquals(false, gameModel.checkMineInCell(4, 1));
	}
	
	@Test
	public void testTickCellTick() {
		GameModel gameModel = new GameModel(3, 3);
		Cell[][] cellField = gameModel.getCellField();
		cellField[0][0].setCellState(Cell.CELL_CLOSE);
		gameModel.tickCell(0, 0);
		Assert.assertEquals(Cell.CELL_TICK, cellField[0][0].getCellState());
	}
	
	@Test
	public void testTickCellClose() {
		GameModel gameModel = new GameModel(3, 3);
		Cell[][] cellField = gameModel.getCellField();
		cellField[0][0].setCellState(Cell.CELL_TICK);
		gameModel.tickCell(0, 0);
		Assert.assertTrue(cellField[0][0].getCellState() == Cell.CELL_CLOSE);
	}
	
	@Test
	public void testTapCellTrueCloseWithoutMine() {
		GameModel gameModel = new GameModel(3, 3);
		Cell[][] cellField = gameModel.getCellField();
		cellField[0][0].setCellState(Cell.CELL_CLOSE);
		cellField[0][0].setMineState(false);
		Assert.assertTrue(gameModel.tapCell(0, 0) == true);
	}
	
	@Test
	public void testTapCellTrueTickWithoutMine() {
		GameModel gameModel = new GameModel(3, 3);
		Cell[][] cellField = gameModel.getCellField();
		cellField[0][0].setCellState(Cell.CELL_TICK);
		cellField[0][0].setMineState(false);
		Assert.assertTrue(gameModel.tapCell(0, 0) == true);
	}
	
	@Test
	public void testTapCellTrueCloseWithMine() {
		GameModel gameModel = new GameModel(3, 3);
		Cell[][] cellField = gameModel.getCellField();
		cellField[0][0].setCellState(Cell.CELL_CLOSE);
		cellField[0][0].setMineState(true);
		Assert.assertTrue(gameModel.tapCell(0, 0) == false);
	}
	
	@Test
	public void testTapCellTrueTickWithMine() {
		GameModel gameModel = new GameModel(3, 3);
		Cell[][] cellField = gameModel.getCellField();
		cellField[0][0].setCellState(Cell.CELL_TICK);
		cellField[0][0].setMineState(true);
		Assert.assertTrue(gameModel.tapCell(0, 0) == false);
	}
	
	@Test
	public void testFinishGameFalseInit() {
		GameModel gameModel = new GameModel(3, 3);
		Assert.assertTrue(gameModel.finishGame() == false);
	}
	
	@Test
	public void testFinishGameFalseOne() {
		GameModel gameModel = new GameModel(3, 3);
		Cell[][] cellField = gameModel.getCellField();
		cellField[0][0].setCellState(Cell.CELL_OPEN);
		Assert.assertTrue(gameModel.finishGame() == false);
	}
	
	@Test
	public void testFinishGameFalseTwo() {
		GameModel gameModel = new GameModel(3, 3);
		Cell[][] cellField = gameModel.getCellField();
		cellField[0][0].setCellState(Cell.CELL_OPEN);
		cellField[1][1].setCellState(Cell.CELL_OPEN);
		Assert.assertTrue(gameModel.finishGame() == false);
	}
	
	@Test
	public void testFinishGameTrueCloseMine() {
		GameModel gameModel = new GameModel(3, 3);
		Cell[][] cellField = gameModel.getCellField();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (cellField[i][j].isMineState()) {
					cellField[i][j].setCellState(Cell.CELL_CLOSE);
				} else {
					cellField[i][j].setCellState(Cell.CELL_OPEN);
				}
			}
		}
		Assert.assertTrue(gameModel.finishGame() == true);
	}
	
	@Test
	public void testFinishGameTrueTickMine() {
		GameModel gameModel = new GameModel(3, 3);
		Cell[][] cellField = gameModel.getCellField();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (cellField[i][j].isMineState()) {
					cellField[i][j].setCellState(Cell.CELL_TICK);
				} else {
					cellField[i][j].setCellState(Cell.CELL_OPEN);
				}
			}
		}
		Assert.assertTrue(gameModel.finishGame() == true);
	}
}
