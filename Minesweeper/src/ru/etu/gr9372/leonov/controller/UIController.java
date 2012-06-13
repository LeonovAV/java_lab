package ru.etu.gr9372.leonov.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import ru.etu.gr9372.leonov.model.Cell;
import ru.etu.gr9372.leonov.model.GameModel;
import ru.etu.gr9372.leonov.view.View;


public class UIController implements Controller {
	
	private GameModel gameModel;
	private View uiView;
	private Timer timer;
	
	@Override
	public void initModel(GameModel gameModel) {
		this.gameModel = gameModel;
	}

	@Override
	public void initView(View view) {
		this.uiView = view;
	}
	
	@Override
	public void propertyChanged(int oper, int curRow, int curCol) {
		gameModel.changeProperty(oper, curRow, curCol);
	}

	@Override
	public void updateProperty(Cell[][] cellField, int rows, int cols) {
		uiView.notifyView(cellField, rows, cols);
	}
	
	@Override
	public void startGame() {
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameModel.setGameTime(gameModel.getGameTime() + 1);
			}
		});
		timer.start();
		uiView.drawGame(gameModel.getCellField(),gameModel.getRows(), gameModel.getCols());
	}
	
	@Override
	public void pausedGame() {
		timer.stop();
		uiView.pausedGame();
		timer.start();
	}
	
	@Override
	public void loseGame() {
		uiView.loseGame();
		restartTimer();
	}
	
	@Override
	public void winGame() {
		uiView.winGame();
		restartTimer();
	}

	private void restartTimer() {
		timer.restart();
		setGameTime(0);
	}
	
	@Override
	public int getGameTime() {
		return gameModel.getGameTime();
	}
	
	@Override
	public void setGameTime(int gameTime) {
		gameModel.setGameTime(gameTime);
	}
}
