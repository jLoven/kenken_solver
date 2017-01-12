package testing;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestingLineWithTextField extends JFrame{

	public TestingLineWithTextField() {
		int buttonHeight = 50;
		JPanel j = generateFrame(400, 200, 50*8, 50*9 + buttonHeight/2);
		getContentPane().add(j);
		//frame.add(j);
		
		setSize(50*8, 50*9 + buttonHeight/2);
		setLocation(400, 200);
		
		JButton button =new JButton("press");
        j.add(button);

        JTextField text = new JTextField();
		
		Font font = new Font("SansSerif", Font.BOLD, 20);
		text.setFont(font);
		text.setHorizontalAlignment(JTextField.CENTER);
		text.setBounds(50, 50, 50, 50);
        j.add(text);
        //frame.setVisible(true);
    }
	
	public static JPanel generateFrame(int xCorner, int yCorner, int xSize, int ySize) {
		JPanel frame = new JPanel();
		frame.setLayout(null);
		return frame;
	}

//    public void paint(Graphics g) {
//        super.paint(g);  // fixes the immediate problem.
//        Graphics2D g2 = (Graphics2D) g;
//        Line2D lin = new Line2D.Float(10, 30, 100, 30);
//        g2.draw(lin);
//    }

    public static void main(String []args){
    	TestingLineWithTextField s=new TestingLineWithTextField();
    	s.setVisible(true);
    }
}

