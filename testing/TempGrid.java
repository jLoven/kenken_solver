package testing;

import grid.GroupOfFields;
import grid.ImageBackground;
import grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class TempGrid {

	public static void addGroup(Location[] locations, int goal, String operation, ArrayList<GroupOfFields> listOfGroups) {
		GroupOfFields group = new GroupOfFields();
		group.setGroupedFields(locations);
		group.setColorOfCollection(ImageBackground.generateRandomColor(new Color(255, 255, 255)));
		group.setGoal(goal);
		group.setOperation(operation);
		listOfGroups.add(group);
	}
	
	public static ArrayList<GroupOfFields> makeTempListOfConnectedFields() {
		ArrayList<GroupOfFields> listOfGroups = new ArrayList<GroupOfFields>();
		
		Location[] locationList1 = {new Location(0, 0), new Location(0, 1), new Location(1, 0)};
		addGroup(locationList1, 80, GroupOfFields.MULTIPLY, listOfGroups);
		
		Location[] locationList2 = {new Location(2, 0)};
		addGroup(locationList2, 3, GroupOfFields.NONE, listOfGroups);
		
		Location[] locationList3 = {new Location(3, 0), new Location(4, 0)};
		addGroup(locationList3, 5, GroupOfFields.SUBTRACT, listOfGroups);
		
		Location[] locationList4 = {new Location(5, 0), new Location(5, 1)};
		addGroup(locationList4, 2, GroupOfFields.DIVIDE, listOfGroups);
		
		Location[] locationList5 = {new Location(1, 1), new Location(2, 1)};
		addGroup(locationList5, 11, GroupOfFields.ADD, listOfGroups);
		
		Location[] locationList6 = {new Location(3, 1), new Location(4, 1)};
		addGroup(locationList6, 1, GroupOfFields.SUBTRACT, listOfGroups);
		
		Location[] locationList7 = {new Location(0, 2), new Location(0, 3), new Location(1, 3)};
		addGroup(locationList7, 9, GroupOfFields.MULTIPLY, listOfGroups);
		
		Location[] locationList17 = {new Location(1, 2)};
		addGroup(locationList17, 2, GroupOfFields.NONE, listOfGroups);
		
		Location[] locationList8 = {new Location(2, 2), new Location(3, 2)};
		addGroup(locationList8, 3, GroupOfFields.SUBTRACT, listOfGroups);
		
		Location[] locationList9 = {new Location(4, 2), new Location(5, 2)};
		addGroup(locationList9, 30, GroupOfFields.MULTIPLY, listOfGroups);
		
		Location[] locationList10 = {new Location(2, 3), new Location(3, 3)};
		addGroup(locationList10, 11, GroupOfFields.ADD, listOfGroups);
		
		Location[] locationList11 = {new Location(4, 3), new Location(5, 3)};
		addGroup(locationList11, 2, GroupOfFields.DIVIDE, listOfGroups);
		
		Location[] locationList12 = {new Location(0, 4)};
		addGroup(locationList12, 6, GroupOfFields.NONE, listOfGroups);
		
		Location[] locationList13 = {new Location(1, 4), new Location(2, 4), new Location(2, 5)};
		addGroup(locationList13, 8, GroupOfFields.MULTIPLY, listOfGroups);
		
		Location[] locationList14 = {new Location(3, 4), new Location(4, 4), new Location(3, 5)};
		addGroup(locationList14, 13, GroupOfFields.ADD, listOfGroups);
		
		Location[] locationList15 = {new Location(5, 4), new Location(5, 5)};
		addGroup(locationList15, 8, GroupOfFields.ADD, listOfGroups);
		
		Location[] locationList16 = {new Location(4, 5)};
		addGroup(locationList16, 1, GroupOfFields.NONE, listOfGroups);
		
		Location[] locationList18 = {new Location(0, 5), new Location(1, 5)};
		addGroup(locationList18, 10, GroupOfFields.MULTIPLY, listOfGroups);
		
		return listOfGroups;
	}	
}