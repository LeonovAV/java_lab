package ru.etu.gr9372.leonov.view;
import ru.etu.gr9372.leonov.controller.Controller;
import ru.etu.gr9372.leonov.model.Cell;


public class ConsoleView implements View {
	
	private Controller controller;
	private Cell[][] cellField;
	private int rows;
	private int cols;
	
	@Override
	public void initController(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void notifyView(Cell[][] cellField, int rows, int cols) {
		this.cellField = cellField;
		this.rows = rows;
		this.cols = cols;
		refreshGame();
	}

	@Override
	public void notifyController(int oper, int curRow, int curCol) {
	}
	
	@Override
	public void refreshGame() {
		drawGame(cellField, rows, cols);
	}

	@Override
	public void drawGame(Cell[][] cellField, int rows, int cols) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				switch (cellField[i][j].getCellState()) {
				case Cell.CELL_OPEN:
					if (cellField[i][j].isMineState()) {
						System.out.print(" * ");
					} else {
						System.out.print(" " + cellField[i][j].getMinesCount() + " ");
					}
					break;
				case Cell.CELL_CLOSE:
					System.out.print(" # ");
					break;
				case Cell.CELL_TICK:
					System.out.print(" ! ");
				}
			}
			System.out.println();
		}
	}

	@Override
	public void pausedGame() {
		System.out.println("Игра приостановлена. Для продолжения нажмите 1");
	}

	@Override
	public void loseGame() {
		System.out.println("Вы проиграли! Время игры: " + controller.getGameTime() + " сек.");
	}

	@Override
	public void winGame() {
		System.out.println("Вы победили! Время игры: " + controller.getGameTime() + " сек.");
	}

}
