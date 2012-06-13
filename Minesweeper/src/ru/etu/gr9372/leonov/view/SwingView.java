package ru.etu.gr9372.leonov.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ru.etu.gr9372.leonov.controller.Controller;
import ru.etu.gr9372.leonov.model.Cell;


public class SwingView implements View {
	
	private Controller controller;
	private MinesweeperFrame frame;
	
	@Override
	public void initController(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void notifyView(Cell[][] cellField, int rows, int cols) {
		frame.setCellField(cellField);
		frame.setRows(rows);
		frame.setCols(cols);
		refreshGame();
	}

	@Override
	public void notifyController(int oper, int curRow, int curCol) {
		controller.propertyChanged(oper, curRow, curCol);
	}

	@Override
	public void refreshGame() {
		frame.refreshBoard();
		frame.repaint();
		frame.revalidate();
	}
	
	@Override
	public void drawGame(Cell[][] cellField, int rows, int cols) {
		frame = new MinesweeperFrame(rows, cols, cellField, this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@Override
	public void pausedGame() {
		JOptionPane.showMessageDialog(frame, "Игра приостановлена. Для продолжения нажмите ОК");
	}

	@Override
	public void loseGame() {
		JOptionPane.showMessageDialog(frame, "Вы проиграли! Время игры: " + controller.getGameTime() + " сек.");
	}

	@Override
	public void winGame() {
		JOptionPane.showMessageDialog(frame, "Вы победили! Время игры: " + controller.getGameTime() + " сек.");
	}
	
	public void notifyControllerTimer() {
		controller.pausedGame();
	}
	
}
