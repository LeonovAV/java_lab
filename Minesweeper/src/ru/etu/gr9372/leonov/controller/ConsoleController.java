package ru.etu.gr9372.leonov.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Timer;

import ru.etu.gr9372.leonov.model.Cell;
import ru.etu.gr9372.leonov.model.GameModel;
import ru.etu.gr9372.leonov.view.View;


public class ConsoleController implements Controller {
	
	private GameModel gameModel;
	private View consoleView;
	private Timer timer;
	
	@Override
	public void initModel(GameModel gameModel) {
		this.gameModel = gameModel;
	}

	@Override
	public void initView(View view) {
		this.consoleView = view;
	}
	
	@Override
	public void propertyChanged(int oper, int curRow, int curCol) {
		gameModel.changeProperty(oper, curRow, curCol);
	}

	@Override
	public void updateProperty(Cell[][] cellField, int rows, int cols) {
		consoleView.notifyView(cellField, rows, cols);
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
		consoleView.drawGame(gameModel.getCellField(), gameModel.getRows(), gameModel.getCols());
		playGame();
	}

	@Override
	public void pausedGame() {
		timer.stop();
		consoleView.pausedGame();
		Scanner scanner = new Scanner(System.in);
		int start = scanner.nextInt();
		if (start == 1) {
			timer.start();
		}
	}
	
	@Override
	public void loseGame() {
		consoleView.loseGame();
		restartTimer();
	}

	@Override
	public void winGame() {
		consoleView.winGame();
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
	
	private void playGame() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1 - Открыть; 2 - Отметить; 3 - Пауза; 4 - Новая игра; 5 - Выход;");
		int oper = scanner.nextInt();
		switch (oper) {
		case Cell.C_OPEN:
			getRCandOper(Cell.C_OPEN);
			playGame();
			break;
		case Cell.C_TICK:
			getRCandOper(Cell.C_TICK);
			playGame();
			break;
		case Cell.C_PAUSE:
			pausedGame();
			playGame();
			break;
		case Cell.C_NEW:
			propertyChanged(Cell.C_NEW, -1, -1);
			playGame();
			break;
		case Cell.C_EXIT:
			break;
		}
	}
	
	private void getRCandOper(int oper) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Строка: ");
		int curRow = scanner.nextInt();
		System.out.println("Колонка: ");
		int curCol = scanner.nextInt();
		propertyChanged(oper, curRow - 1, curCol - 1);
	}
	
}