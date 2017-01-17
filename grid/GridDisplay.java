package grid;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import solver.FinishedPuzzleChecker;
import solver.GroupChecker;

public class GridDisplay extends JFrame{
	
	//  Make 6 squares by 6 squares. must be colored in and contain text.
	public static JTextField createTextBoxAt(JFrame frame, int xCorner, int yCorner, int xSize, int ySize, int fontSize) {
		JTextField text = new JTextField();
		text.setBounds(xCorner, yCorner, xSize, ySize);
		Font font = new Font("SansSerif", Font.BOLD, fontSize);
		text.setFont(font);
		text.setHorizontalAlignment(JTextField.CENTER);
		frame.add(text);
		return text;
	}

	public static JFrame generateFrame(int xCorner, int yCorner, int xSize, int ySize) {
		JFrame frame = new JFrame();
		frame.setLocation(xCorner, yCorner);
		frame.setSize(xSize, ySize);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		return frame;
	}
	
	//  Just for testing:
	public static ArrayList<GroupOfFields> makeTempListOfConnectedFields() {
		ArrayList<GroupOfFields> listOfGroups = new ArrayList<GroupOfFields>();
		GroupOfFields group = new GroupOfFields();
		Location[] locationList = new Location[3];
		locationList[0] = new Location(0, 1);
		locationList[1] = new Location(1, 1);
		locationList[2] = new Location(1, 0);
		group.setGroupedFields(locationList);
		group.setColorOfCollection(ImageBackground.generateRandomColor(new Color(255, 255, 255)));
		group.setGoal(12);
		group.setOperation("add");
		listOfGroups.add(group);
		
		GroupOfFields group2 = new GroupOfFields();
		Location[] locationList2 = new Location[1];
		locationList2[0] = new Location(0, 0);
		group2.setGroupedFields(locationList2);
		group2.setColorOfCollection(ImageBackground.generateRandomColor(new Color(255, 255, 255)));
		group2.setGoal(6);
		group2.setOperation("none");
		listOfGroups.add(group2);
		
		//  for each other one, make a location list with just that
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				Location current = new Location(i, j);
				if (!current.isInsideList(locationList)) {
					GroupOfFields tempGroup = new GroupOfFields();
					Location[] currentLocationList = {current};
					tempGroup.setGroupedFields(currentLocationList);
					Color color = ImageBackground.generateRandomColor(new Color(255,255,255));
					tempGroup.setColorOfCollection(color);
					int goal = 1 + (int)(Math.random() * ((100 - 1) + 1));
					tempGroup.setGoal(goal);
					tempGroup.setOperation(GroupOfFields.getRandomOperation());					
					listOfGroups.add(tempGroup);
				}
			}
		}
		return listOfGroups;
	}

	public static FieldData[][] makeGridDisplay(final ArrayList<GroupOfFields> groupedLocations) {
		int buttonLength = 150;
		int buttonHeight = 50;
		JFrame frame = generateFrame(400, 200, 50*8, 50*9 + buttonHeight/2);
		final FieldData[][] listOfFields = new FieldData[6][6];
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				FieldData fieldData = new FieldData();
				Location currentLocation = new Location(i, j);
				fieldData.setLocation(currentLocation);
				GroupOfFields group = GroupOfFields.getGroupGivenLocation(currentLocation, groupedLocations);
				Color color = group.getColorOfCollection();
				final BufferedImage image = ImageBackground.createImage(color, group.getGoalAndOperation());
				JTextField field = ImageBackground.addNewLabelToFrame(frame, image, 50 + 50*i, 50 + 50*j, 50, 50);
				listOfFields[i][j] = fieldData;
				fieldData.setField(field);
			}
		}

		JButton check = new JButton("check answers");
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (GroupOfFields group : groupedLocations) {
					boolean b = GroupChecker.checkGroupValidity(listOfFields, group);
					System.out.println("group with " + group.getGoalAndOperation() + " is " + b);
				}
				
				//int[][] numbers = FinishedPuzzleChecker.getNumbers(listOfFields);
				//System.out.println(FinishedPuzzleChecker.checkValid1Through6(numbers));
			}
		};
		check.addActionListener(listener);
		check.setBounds(50*8/2 - buttonLength / 2, 50*8 - buttonHeight + 10, buttonLength, buttonHeight);
		frame.add(check);

		frame.setVisible(true);
		return listOfFields;

	}
	
	public static void main(String[] args) {
		ArrayList<GroupOfFields> groupedLocations = makeTempListOfConnectedFields();
		FieldData[][] list = GridDisplay.makeGridDisplay(groupedLocations);
		
	}

}

