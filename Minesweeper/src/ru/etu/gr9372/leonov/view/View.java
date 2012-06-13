package ru.etu.gr9372.leonov.view;
import ru.etu.gr9372.leonov.controller.Controller;
import ru.etu.gr9372.leonov.model.Cell;


public interface View {
	public void initController(Controller controller);
	public void notifyView(Cell[][] cellField, int rows, int cols);
	public void notifyController(int oper, int curRow, int curCol);
	public void refreshGame();
	public void drawGame(Cell[][] cellField, int rows, int cols);
	public void pausedGame();
	public void loseGame();
	public void winGame();
}
