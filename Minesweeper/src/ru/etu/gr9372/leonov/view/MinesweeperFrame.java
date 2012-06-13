package ru.etu.gr9372.leonov.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ru.etu.gr9372.leonov.model.Cell;


public class MinesweeperFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private int cols;
	private int rows;
	private Cell[][] cellField;
	private SwingView swingView;
	
	public MinesweeperFrame(int rows, int cols, Cell[][] cellField, SwingView swingView) {
		this.rows = rows;
		this.cols = cols;
		this.cellField = cellField;
		this.swingView = swingView;
		setTitle("Сапер");
		setSize(this.rows * 60, this.cols * 50);
		setLayout(new BorderLayout());
		JPanel board = createBoard();
		add(board, BorderLayout.CENTER);
		JPanel menu = createMenu();
		add(menu, BorderLayout.NORTH);
	}
	
	public void setCellField(Cell[][] cellField) {
		this.cellField = cellField; 
	}
	
	public void setCols(int cols) {
		this.cols = cols;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public void refreshBoard() {
		Container pane = this.getContentPane();
		pane.removeAll();
		JPanel board = createBoard();
		pane.add(board, BorderLayout.CENTER);
		JPanel menu = createMenu();
		pane.add(menu, BorderLayout.NORTH);
	}
	
	private JPanel createBoard() {
		JPanel board = new JPanel();
		board.setLayout(new GridLayout(rows, cols));
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				final int curRow = i;
				final int curCol = j;
				JButton button = null;
				switch(cellField[i][j].getCellState()) {
				case Cell.CELL_OPEN:
					if (cellField[i][j].isMineState()) {
						button = new JButton("*");
					} else {
						if (cellField[i][j].getMinesCount() == 0) {
							button = new JButton();
						} else {
							button = new JButton("" + cellField[i][j].getMinesCount());
						}
					}
					button.setEnabled(false);
					board.add(button);
					break;
				case Cell.CELL_CLOSE:
					button = new JButton();
					button = addListener(button, curRow, curCol);
					board.add(button);
					break;
				case Cell.CELL_TICK:
					button = new JButton("!");
					button = addListener(button, curRow, curCol);
					board.add(button);
					break;
				}
			}
		}
		return board;
	}
	
	private JButton addListener(JButton button, final int curRow, final int curCol) {
		button.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if ((e.getModifiersEx() & InputEvent.BUTTON3_DOWN_MASK) != 0) {
					swingView.notifyController(Cell.CELL_RMB, curRow, curCol);
				} else {
					swingView.notifyController(Cell.CELL_LMB, curRow, curCol);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {				
			}
		});
		return button;
	}
	
	private JPanel createMenu() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		JButton newGameBtn = new JButton("Новая игра");
		newGameBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				swingView.notifyController(Cell.C_NEW, 0, 0);
			}
		});
		panel.add(newGameBtn);
		JButton pauseGameBtn = new JButton("Пауза");
		pauseGameBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				swingView.notifyControllerTimer();
			}
			
		});
		panel.add(pauseGameBtn);
		return panel;
	}
	
}
