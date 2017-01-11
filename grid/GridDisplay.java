package grid;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import solver.FinishedPuzzleChecker;

public class GridDisplay {

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}
	
	public static JTextField[][] makeGridDisplay() {
		int buttonLength = 150;
		int buttonHeight = 50;
		JFrame frame = generateFrame(400, 200, 50*8, 50*9 + buttonHeight/2);
		final JTextField[][] listOfFields = new JTextField[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				JTextField field = createTextBoxAt(frame, 50 + 50*i, 50 + 50*j, 50, 50, 20);
				listOfFields[i][j] = field;
			}
		}
		
		JButton check = new JButton("check answers");
		ActionListener listener = new ActionListener() {
			  public void actionPerformed(ActionEvent e)
			  {
			    System.out.println("pressed");
			    System.out.println(FinishedPuzzleChecker.checkFull(listOfFields));
			  }
			};
		check.addActionListener(listener);
		check.setBounds(50*8/2 - buttonLength / 2, 50*8 - buttonHeight + 10, buttonLength, buttonHeight);
		frame.add(check);
		
		frame.setVisible(true);
		return listOfFields;
		
	}
	
	public static void main(String[] args) {
		JTextField[][] list = GridDisplay.makeGridDisplay();
		
	}
	
}

