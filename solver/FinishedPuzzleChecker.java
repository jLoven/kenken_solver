package solver;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;

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
	
	public static boolean contains1Through6(Integer[] array) {
		final Integer[] valids = {1, 2, 3, 4, 5, 6};
		return Arrays.asList(array).containsAll(Arrays.asList(valids));
	}
	
	public static boolean checkValid1Through6(JTextField[][] list) {
		if (checkFull(list)) {
			// check each row contains one instance each of 1-6
			for (int i = 0; i < list.length; i++) {
				//  grab each column and check contains
			}
			
			
			
			return true;
		} else {
			return false;
		}
	}
	
	public static Integer[] toObject(int[] intArray) {

		Integer[] result = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			result[i] = Integer.valueOf(intArray[i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		final int[] valids = {1, 3, 2, 4, 5, 6};
		System.out.println(contains1Through6(toObject(valids)));
	}
	
}
