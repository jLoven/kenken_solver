package solver;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTextField;

public class FinishedPuzzleChecker {
	
	public static boolean checkFull(JTextField[][] list) {
		boolean isFull = true;
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length; j++) {
				String text = list[i][j].getText().trim();
				if (text.length() != 1 || !text.matches("[1-6]")) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
			
	}
	
}
