package ru.etu.gr9372.leonov.game;
import java.util.Scanner;

import ru.etu.gr9372.leonov.controller.ConsoleController;
import ru.etu.gr9372.leonov.controller.Controller;
import ru.etu.gr9372.leonov.controller.UIController;
import ru.etu.gr9372.leonov.model.GameModel;
import ru.etu.gr9372.leonov.view.ConsoleView;
import ru.etu.gr9372.leonov.view.SwingView;
import ru.etu.gr9372.leonov.view.View;


public class Run {

	public static void main(String[] args) {
		View gameView = null;
		Controller controller = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите число строк:");
		int rows = scanner.nextInt();
		System.out.println("Введите число столбцов:");
		int cols = scanner.nextInt();
		GameModel gameModel = new GameModel(rows, cols);
		System.out.println("Какой тип интерфейса? Swing/Console");
		String answer = scanner.next();
		
		if (answer.equals("Swing")) {
			controller = new UIController();
			gameModel.initController(controller);
			gameView = new SwingView();
			gameView.initController(controller);
			controller.initModel(gameModel);
			controller.initView(gameView);
		} else {
			controller = new ConsoleController();
			gameModel.initController(controller);
			gameView = new ConsoleView();
			gameView.initController(controller);
			controller.initModel(gameModel);
			controller.initView(gameView);
		}
		
		controller.startGame();
	}

}
