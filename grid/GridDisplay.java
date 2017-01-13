package grid;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import solver.FinishedPuzzleChecker;

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

	public static FieldData[][] makeGridDisplay() {
		int buttonLength = 150;
		int buttonHeight = 50;
		JFrame frame = generateFrame(400, 200, 50*8, 50*9 + buttonHeight/2);
		final FieldData[][] listOfFields = new FieldData[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				FieldData fieldData = new FieldData();
				JTextField field = createTextBoxAt(frame, 50 + 50*i, 50 + 50*j, 50, 50, 20);
				Color color = generateRandomColor(new Color(255,255,255));
				field.setBackground(color);
				Location location = new Location(i, j);
				
				fieldData.setField(field);
				fieldData.setColorOfCollection(color);
				fieldData.setLocation(location);
				//  TODO:  Make a list of connected fields here
				fieldData.setListOfConnectedFields(null);
				
				listOfFields[i][j] = fieldData;
			}
		}

		JButton check = new JButton("check answers");
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[][] numbers = FinishedPuzzleChecker.getNumbers(listOfFields);
				System.out.println(FinishedPuzzleChecker.checkValid1Through6(numbers));
			}
		};
		check.addActionListener(listener);
		check.setBounds(50*8/2 - buttonLength / 2, 50*8 - buttonHeight + 10, buttonLength, buttonHeight);
		frame.add(check);

		frame.setVisible(true);
		return listOfFields;

	}
	
	public static Color generateRandomColor(Color mix) {
	    Random random = new Random();
	    int red = random.nextInt(256);
	    int green = random.nextInt(256);
	    int blue = random.nextInt(256);

	    // mix the color
	    if (mix != null) {
	        red = (red + mix.getRed()) / 2;
	        green = (green + mix.getGreen()) / 2;
	        blue = (blue + mix.getBlue()) / 2;
	    }

	    Color color = new Color(red, green, blue);
	    return color;
	}


	public static void main(String[] args) {
		FieldData[][] list = GridDisplay.makeGridDisplay();

	}

}

