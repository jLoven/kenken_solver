package grid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ImageBackground {
	
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
	
	public static BufferedImage createImage(Color color, String goal) {
		BufferedImage bufferedImage = new BufferedImage(48, 48,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(color);
		graphics.fillRect(0, 0, 48, 48);
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("SansSerif", Font.BOLD, 9));
		graphics.drawString(goal, 5, 14);
		return bufferedImage;
	}
	
	public static JTextField addNewLabelToFrame(JFrame frame, BufferedImage image, int x, int y, int sizeX, int sizeY) {
		JTextField field = new JTextField();
    	JLabel label = new JLabel(new ImageIcon(image));
    	label.setLayout(new BorderLayout());
    	field.setBounds(x, y, sizeX, sizeY);
    	Font font = new Font("SansSerif", Font.BOLD, 20);
		field.setFont(font);
		field.setHorizontalAlignment(JTextField.CENTER);
		field.setBackground(new Color(0, 0, 0, 0));
		label.add(field);
		label.setBounds(x, y, sizeX, sizeY);
		frame.add(label);
		return field;
	}
}
