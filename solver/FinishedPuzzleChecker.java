package solver;

import grid.FieldData;

import java.util.Arrays;

public class FinishedPuzzleChecker {
	
	public static int[][] getNumbers(FieldData[][] list) {
		int[][] numbers = new int[6][6];
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length; j++) {
				list[i][j].setNumberFromFieldData();
				Integer number = list[i][j].getNumber();
				numbers[i][j] = number;
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
}
