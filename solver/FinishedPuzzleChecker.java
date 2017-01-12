package solver;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextField;

public class FinishedPuzzleChecker {
	
	public static int[][] getNumbers(JTextField[][] list) {
		int[][] numbers = new int[6][6];
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length; j++) {
				String text = list[i][j].getText().trim();
				if (text.length() == 1 && text.matches("[1-6]")) {
					numbers[i][j] = Integer.parseInt(text);
				} else {
					System.out.println("invalid character at " + i + " " + j);
				}
			}
		}
		return numbers;
	}
	
	public static boolean checkFull(int[][] list) {
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length; j++) {
				if (list[i][j] == 0) {
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
	
	/*public static Integer[] toObject(int[] intArray) {

		Integer[] result = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			result[i] = Integer.valueOf(intArray[i]);
		}
		return result;
	}*/
	
	public static Integer[] getColumn(int[][] array, boolean isRow, int index) {
		Integer[] finalArray = new Integer[array.length];
		if (isRow) {
			for (int i = 0; i < array.length; i++) {
				finalArray[i] = Integer.valueOf(array[index][i]);
			}
		} else {
			for (int i = 0; i < array.length; i++) {
				finalArray[i] = Integer.valueOf(array[i][index]);
			}
		}
		return finalArray;
	}
	
	public static boolean checkValid1Through6(int[][] list) {
		if (checkFull(list)) {
			for (int i = 0; i < list.length; i++) {
				Integer[] row = getColumn(list, true, i);
				Integer[] column = getColumn(list, false, i);
				if (!contains1Through6(row) || !contains1Through6(column)) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		final Integer[] valids = {1, 3, 2, 4, 5, 6};
		System.out.println(contains1Through6(valids));
	}
}
