package grid;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class GroupOfFields {

	public static final String DIVIDE = "divide";
	public static final String MULTIPLY = "multiply";
	public static final String ADD = "add";
	public static final String SUBTRACT = "subtract";
	public static final String NONE = "none";

	private Location[] groupedFields;
	private Color colorOfCollection = null;
	private int goal;
	private String operation;

	public static GroupOfFields getGroupGivenLocation(Location location, ArrayList<GroupOfFields> arrayOfGroups) {
		for (GroupOfFields g : arrayOfGroups) {
			Location[] currentLocationList = g.getGroupedFields();
			if (location.isInsideList(currentLocationList)) {
				return g;
			}
		}
		System.out.println("Something went wrong in GroupOfFields");
		return null;
	}

	public void setGroupedFields(Location[] locationList) {
		this.groupedFields = locationList;
	}

	public Location[] getGroupedFields() {
		return this.groupedFields;
	}

	public void setColorOfCollection(Color color) {
		this.colorOfCollection = color;
	}

	public Color getColorOfCollection() {
		return this.colorOfCollection;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public int getGoal() {
		return this.goal;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOperation() {
		return this.operation;
	}

	public String getGoalAndOperation() {
		String s = this.goal + "";
		switch(this.operation) {
		case ADD: s = s + "\u002B";
		break;
		case SUBTRACT: s = s + "\uFE63";
		break;
		case DIVIDE: s = s + "\u00F7";
		break;
		case MULTIPLY: s = s + "\u00D7";
		break;
		case NONE: s = s + "";
		break;
		}
		return s;
	}

	//  Just for testing:
	public static String getRandomOperation() {
		String[] possibilities = {ADD, SUBTRACT, MULTIPLY, DIVIDE};
		int i = new Random().nextInt(possibilities.length);
		String random = (possibilities[i]);
		return random;
	}

	public static FieldData[] getFieldsInGroup(GroupOfFields group, FieldData[][] listOfFields) {
		Location[] listOfLocations = group.getGroupedFields();
		FieldData[] fieldsInGroup = new FieldData[listOfLocations.length];
		//  need to get fields from these locations
		for (int k = 0; k < listOfLocations.length; k++) {
			Location l = listOfLocations[k];
			outerLoop: for (int i = 0; i < listOfFields.length; i++) {
				for (int j = 0; j < listOfFields.length; j++) {
					FieldData field = listOfFields[i][j];
					Location loc = field.getLocation();
					if (loc.isEquivalentTo(l)) {
						fieldsInGroup[k] = field;
						break outerLoop;
					}
				}
			}
		}
		return fieldsInGroup;
	}
}
