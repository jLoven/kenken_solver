package solver;

import grid.FieldData;
import grid.GroupOfFields;

import java.util.ArrayList;

public class GroupChecker {

	public static boolean isGroupFull(FieldData[] fields) {
		ArrayList<Integer> valid = new ArrayList<Integer>();
		valid.add(1); valid.add(2); valid.add(3); valid.add(4); valid.add(5); valid.add(6);
		for (FieldData f : fields) {
			f.setNumberFromFieldData();
			if (!valid.contains(f.getNumber())) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkGroupValidity(FieldData[][] listOfFields, GroupOfFields group) {
		int goal = group.getGoal();
		String operation = group.getOperation();
		FieldData[] fields = GroupOfFields.getFieldsInGroup(group, listOfFields);
		if (isGroupFull(fields)) {
			if (operation.equalsIgnoreCase("divide") || operation.equalsIgnoreCase("subtract")) {
				double first = (double) fields[0].getNumber();
				double second = (double) fields[1].getNumber();
				boolean a = false;
				boolean b = false;
				if (operation.equalsIgnoreCase("divide")) {
					a = first / second == (double) goal;
					b = second / first == (double) goal;
				} else {
					a = first - second == (double) goal;
					b = second - first == (double) goal;
				}
				if (a || b) {
					return true;
				} else {
					return false;
				}
			} else if (operation.equalsIgnoreCase("add") || operation.equalsIgnoreCase("multiply")) {
				int i = 0;
				if (operation.equalsIgnoreCase("multiply")) {
					i = 1;
				}
				for (FieldData f : fields) {
					int current = f.getNumber();
					if (operation.equalsIgnoreCase("add")) {
						i = i + current;
					} else {
						i = i * current;
					}
				}
				if (i == goal) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
}