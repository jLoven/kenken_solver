package grid;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class GroupOfFields {

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

	public String getGoalAndOperation() {
		String s = this.goal + "";
		switch(this.operation) {
		case "add": s = s + "\u002B";
		break;
		case "subtract": s = s + "\uFE63";
		break;
		case "divide": s = s + "\u00F7";
		break;
		case "multiply": s = s + "\u00D7";
		break;
		}
		return s;
	}
	
	//  Just for testing:
	public static String getRandomOperation() {
		String[] possibilities = {"add", "subtract", "multiply", "divide"};
		int i = new Random().nextInt(possibilities.length);
		String random = (possibilities[i]);
		return random;
	}
}
