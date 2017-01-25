package solver;

import grid.FieldData;
import grid.GroupOfFields;

import java.util.ArrayList;
import java.util.Arrays;

public class Solver {

	private static ArrayList<int[]> solutions = new ArrayList<int[]>();

	public static void main(String[] args) {
		getListOfPermutations(4);
	}

	public static void getListOfPermutations(int choosing) {
		//  Adapted from https://goo.gl/RLkDkV
		int[] possible = {1, 2, 3, 4, 5, 6};
		int multiplier = 1;
		if (choosing > 2) {
			multiplier = 2;
		}
		int[] numbers = new int[possible.length * multiplier];
		for (int i = 0; i < numbers.length; i++) {
			int current = possible[i % possible.length];
			numbers[i] = current;
		}
		int N = numbers.length; 
		int ret = 1;
		for (int k = 0; k < choosing; k++) {
			ret = ret * (N - k) / (k + 1);
		}
		int data[] = new int[choosing];
		combinationUtil(numbers, data, 0, N - 1, 0, choosing);

		//System.out.println(solutions.size());
		for (int i = 0; i < solutions.size(); i++) {
			for (int j = 0; j < solutions.get(i).length; j ++) {
				System.out.print(solutions.get(i)[j]+" ");
			}
			System.out.println("");
		}
	}

	private static boolean containsCorrectDuplicates(int[] array) {
		int counter = 0;
		if (array.length == 1) {
			return true;
		}
		for (int i = 1; i < array.length; i ++) {
			if (array[i] == array[i - 1]) {
				counter ++;
			}
			if (counter > 1) {
				return false;
			}
		}
		return true;
	}

	private static void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {
		if (index == r) {
			int[] temp = new int[data.length];
			for (int j=0; j<r; j++) {
				temp[j] = data[j];
			}
			Arrays.sort(temp);
			boolean there = false;
			for (int[] array : solutions) {
				if (Arrays.equals(array, temp)) {
					there = true;
				}
			}
			if (!there && containsCorrectDuplicates(temp)) {
				solutions.add(temp);
			}
			return;
		}
		for (int i = start; i <= end && end - i + 1 >= r - index; i ++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i+1, end, index+1, r);
		}
	}

	public static void removePossibilityFromRowsAndColumns(FieldData[][] fieldList) {

	}

	public static void populatePossibilitiesOfField(FieldData[] field, GroupOfFields group) {
		//  first get all the possibilities. then check the rows and columns and delete any that are already seen
		int goal = group.getGoal();
		String operation = group.getOperation();
		//  somehow get all permutations of 1-6 that add up to certain number


	}

	public static void fillInLastItemOfGroup(FieldData[] fieldList, GroupOfFields group) {
		int goal = group.getGoal();
		String operation = group.getOperation();
		FieldData last = GroupChecker.hasOneLeft(fieldList); //  grabs latest numbers too
		ArrayList<Integer> possibleFillers = new ArrayList<Integer>();
		switch(operation) {
		case GroupOfFields.ADD:
			int total = 0;
			for (FieldData f: fieldList) {
				if (GroupChecker.isFieldNumberValid(f)) {
					int number = f.getNumber();
					total = total + number;
				}
			}
			if (GroupChecker.isValidNumber(goal - total)) {
				possibleFillers.add(goal - total);
			}
			break;
		case GroupOfFields.SUBTRACT: 
			//  there are only 2 fields
			int number = 0;
			for (FieldData f: fieldList) {
				if (GroupChecker.isFieldNumberValid(f)) {
					number = f.getNumber();
				}
			}
			int added = number + goal;
			int subtracted = number - goal;
			if (GroupChecker.isValidNumber(added)) {
				possibleFillers.add(added);
			}
			if (GroupChecker.isValidNumber(subtracted)) {
				possibleFillers.add(subtracted);
			};
			break;
		case GroupOfFields.DIVIDE: 
			//  there are only 2 fields
			int num = 0;
			for (FieldData f: fieldList) {
				if (GroupChecker.isFieldNumberValid(f)) {
					num = f.getNumber();
				}
			}
			double divide = (double) goal / (double) num;
			if (divide != (int) divide) {
				divide = 0;
			}
			int multiply = goal * num;
			if (GroupChecker.isValidNumber((int) divide)) {
				possibleFillers.add((int) divide);
			}
			if (GroupChecker.isValidNumber(multiply) && !possibleFillers.contains(multiply)) {
				possibleFillers.add(multiply);
			};
			break;
		case GroupOfFields.MULTIPLY:
			int tot = 1;
			for (FieldData f: fieldList) {
				if (GroupChecker.isFieldNumberValid(f)) {
					int numb = f.getNumber();
					tot = tot * numb;
				}
			}
			if (GroupChecker.isValidNumber(goal / tot)) {
				possibleFillers.add(goal / tot);
			}
			break;
		case GroupOfFields.NONE: 
			possibleFillers.add(goal);
			break;
		}
		if (possibleFillers.size() == 1) {
			last.getField().setText(possibleFillers.get(0) + "");
		}


	}

}
