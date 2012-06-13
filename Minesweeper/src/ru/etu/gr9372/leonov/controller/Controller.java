package ru.etu.gr9372.leonov.controller;
import ru.etu.gr9372.leonov.model.Cell;
import ru.etu.gr9372.leonov.model.GameModel;
import ru.etu.gr9372.leonov.view.View;


public interface Controller {
	public void initModel(GameModel gameModel);
	public void initView(View view);
	public void propertyChanged(int oper, int curRow, int curCol);
	public void updateProperty(Cell[][] cellField, int rows, int cols);
	public void pausedGame();
	public void startGame();
	public void loseGame();
	public void winGame();
	public int getGameTime();
	public void setGameTime(int gameTime);
}
