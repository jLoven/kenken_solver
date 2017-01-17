package solver;

import grid.FieldData;
import grid.GroupOfFields;

import java.util.ArrayList;

public class GroupChecker {
	
	public static boolean isValidNumber(int number) {
		ArrayList<Integer> valid = new ArrayList<Integer>();
		valid.add(1); valid.add(2); valid.add(3); valid.add(4); valid.add(5); valid.add(6);
		if (!valid.contains(number)) {
			return false;
		}
		return true;
	}

	public static boolean isFieldNumberValid(FieldData field) {
		field.setNumberFromFieldData();
		int number = field.getNumber();
		if (!isValidNumber(number)) {
			return false;
		}
		return true;
	}

	public static boolean isGroupFull(FieldData[] fields) {
		for (FieldData f : fields) {
			if (!isFieldNumberValid(f)) {
				return false;
			}
		}
		return true;
	}

	public static FieldData hasOneLeft(FieldData[] fieldList) {
		int count = 0;
		FieldData remainder = null;
		for (FieldData f : fieldList) {
			if (!isFieldNumberValid(f)) {
				count++;
				remainder = f;
			}
		}
		if (count == 1) {
			return remainder;
		}
		return null;
	}

	public static boolean checkGroupValidity(FieldData[][] listOfFields, GroupOfFields group) {
		int goal = group.getGoal();
		String operation = group.getOperation();
		FieldData[] fields = GroupOfFields.getFieldsInGroup(group, listOfFields);
		if (isGroupFull(fields)) {
			if (operation.equalsIgnoreCase(GroupOfFields.DIVIDE) || operation.equalsIgnoreCase(GroupOfFields.SUBTRACT)) {
				double first = (double) fields[0].getNumber();
				double second = (double) fields[1].getNumber();
				boolean a = false;
				boolean b = false;
				if (operation.equalsIgnoreCase(GroupOfFields.DIVIDE)) {
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
			} else if (operation.equalsIgnoreCase(GroupOfFields.ADD) || operation.equalsIgnoreCase(GroupOfFields.MULTIPLY)) {
				int i = 0;
				if (operation.equalsIgnoreCase(GroupOfFields.MULTIPLY)) {
					i = 1;
				}
				for (FieldData f : fields) {
					int current = f.getNumber();
					if (operation.equalsIgnoreCase(GroupOfFields.ADD)) {
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
			} else if (operation.equalsIgnoreCase(GroupOfFields.NONE)) {
				if (fields[0].getNumber() == goal) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
}