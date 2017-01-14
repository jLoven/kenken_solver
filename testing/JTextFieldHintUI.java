package testing;

//  Code taken from https://blogs.sequoiainc.com/java-swing-hint-text-on-a-jtextfield/

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

public class JTextFieldHintUI extends BasicTextFieldUI implements FocusListener {  
    private String hint;
    private Color  hintColor;

    public JTextFieldHintUI(String hint, Color hintColor) {
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
        if (component.getText().length() == 0 && !component.hasFocus()) {
            g.setColor(hintColor);
            int padding = (component.getHeight() - component.getFont().getSize()) / 2;
            int inset = 3;
            g.drawString(hint, inset, component.getHeight() - padding - inset);
        }
    }

    public void focusGained(FocusEvent e) {
        repaint();
    }

    public void focusLost(FocusEvent e) {
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
    
    public static void main(String[] args) {
    	JFrame frame = new JFrame();
		frame.setLocation(400, 200);
		frame.setSize(50*8, 50*9);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	
    	JTextField field = new JTextField();
    	field.setBounds(50, 50, 50, 50);
    	//
		Font font = new Font("SansSerif", Font.BOLD, 20);
		field.setFont(font);
		field.setHorizontalAlignment(JTextField.CENTER);
		field.setBackground(new Color(255, 50, 255));
    	frame.add(field);
    	JButton check = new JButton("check answers");
    	check.setBounds(50*8/2 - 150 / 2, 50*8 - 50 + 10, 150, 50);
    	frame.add(check);
    	
    	frame.setVisible(true);
    	field.setUI(new JTextFieldHintUI("This is a hint...", Color.gray));
    	
    	
    }
}
