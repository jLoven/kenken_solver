package grid;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GridDisplay {

	//  Make 6 squares by 6 squares. must be colored in and contain text.
	public static void createTextBoxAt(JFrame frame, int xCorner, int yCorner, int xSize, int ySize, int fontSize) {
		JTextField text = new JTextField();
		text.setBounds(xCorner, yCorner, xSize, ySize);
		Font font = new Font("SansSerif", Font.BOLD, fontSize);
		text.setFont(font);
		text.setHorizontalAlignment(JTextField.CENTER);

		frame.add(text);
	}
	
	public static JFrame generateFrame(int xCorner, int yCorner, int xSize, int ySize) {
		JFrame frame = new JFrame();
		frame.setLocation(xCorner, yCorner);
		frame.setSize(xSize, ySize);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}
	
	public static JFrame makeGridDisplay() {
		int buttonLength = 150;
		int buttonHeight = 50;
		JFrame frame = generateFrame(400, 200, 50*8, 50*9 + buttonHeight/2);
		JButton check = new JButton("check answers");
		frame.add(check);
		
		check.setBounds(50*8/2 - buttonLength / 2, 50*8 - buttonHeight + 10, buttonLength, buttonHeight);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				createTextBoxAt(frame, 50 + 50*i, 50 + 50*j, 50, 50, 20);
			}
		}
		frame.setVisible(true);
		return frame;
		
	}
	
	public static void main(String[] args) {
		makeGridDisplay();
	}
	
}

