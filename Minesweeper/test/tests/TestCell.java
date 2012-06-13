package tests;

import junit.framework.Assert;

import org.junit.Test;

import ru.etu.gr9372.leonov.model.Cell;

public class TestCell {
	
	@Test
	public void testCellMinesCount() {
		Cell cell = new Cell();
		Assert.assertEquals(0, cell.getMinesCount());
	}
	
	@Test
	public void testCellMineState() {
		Cell cell = new Cell();
		Assert.assertEquals(false, cell.isMineState());
	}
	
	@Test
	public void testCellState() {
		Cell cell = new Cell();
		Assert.assertTrue(cell.getCellState() == Cell.CELL_CLOSE);
	}
	
	@Test
	public void testSetMinesCount() {
		Cell cell = new Cell();
		cell.setMinesCount(3);
		Assert.assertEquals(3, cell.getMinesCount());
	}
	
	@Test
	public void testSetMineState() {
		Cell cell = new Cell();
		cell.setMineState(true);
		Assert.assertEquals(true, cell.isMineState());
	}
	
	@Test
	public void testSetCellState() {
		Cell cell = new Cell();
		cell.setCellState(Cell.CELL_OPEN);
		Assert.assertTrue(cell.getCellState() == Cell.CELL_OPEN);
	}

}
