package solver;

import grid.FieldData;
import grid.GroupOfFields;

import java.util.ArrayList;

public class Solver {

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
