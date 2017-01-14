package grid;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;

import testing.JTextFieldHintUI;

public class JTextFieldWithHint extends BasicTextFieldUI implements FocusListener {  
    private String hint;
    private Color  hintColor;

    public JTextFieldWithHint(String hint, Color hintColor) {
        this.hint = hint;
        this.hintColor = hintColor;
    }

    private void repaint() {
        if (getComponent() != null) {
            getComponent().repaint();
        }
    }

    @Override
    protected void paintSafely(Graphics g) {
        // Render the default text field UI
        super.paintSafely(g);
        // Render the hint text
        JTextComponent component = getComponent();
        Font font = new Font("SansSerif", Font.BOLD, 10);
        if (component.getText().length() == 0 && !component.hasFocus()) {
            g.setColor(hintColor);
            component.setFont(font);
            g.drawString(hint, g.getClipBounds().x + 15, g.getClipBounds().y + 13);
        }
    }

    public void focusGained(FocusEvent e) {
    	JTextComponent component = getComponent();
    	Font font = new Font("SansSerif", Font.BOLD, 20);
        component.setFont(font);
        //repaint();
    }

    public void focusLost(FocusEvent e) {
    	JTextComponent component = getComponent();
        repaint();
    }

    public void installListeners() {
        super.installListeners();
        getComponent().addFocusListener(this);
    }

    @Override
    public void uninstallListeners() {
        super.uninstallListeners();
        getComponent().removeFocusListener(this);
    }
    
   /*public static void main(String[] args) {
    	JFrame frame = new JFrame();
		frame.setLocation(400, 200);
		frame.setSize(50*8, 50*9);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	
    	JTextField field = new JTextField();
    	field.setBounds(50, 50, 50, 50);
    	JTextField field1 = new JTextField();
    	field1.setBounds(50 + 50, 50 + 50, 50, 50);
    	//
		Font font = new Font("SansSerif", Font.BOLD, 20);
		field.setFont(font);
		field1.setFont(font);
		field.setHorizontalAlignment(JTextField.CENTER);
		field1.setHorizontalAlignment(JTextField.CENTER);
		field.setBackground(new Color(255, 50, 255));
		field1.setBackground(new Color(255, 150, 255));
    	frame.add(field);
    	frame.add(field1);
    	JButton check = new JButton("check answers");
    	check.setBounds(50*8/2 - 150 / 2, 50*8 - 50 + 10, 150, 50);
    	frame.add(check);
    	
    	frame.setVisible(true);
    	field.setUI(new JTextFieldWithHint("11+", Color.black));
    	field1.setUI(new JTextFieldWithHint("1-", Color.black));
    	
    	
    }*/
}