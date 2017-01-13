package grid;

import java.awt.Color;

import javax.swing.JTextField;

public class FieldData {

	private JTextField field;
	private Integer number;
	private Location ownLocation;
	private Color colorOfCollection;
	private FieldData[] listOfConnectedFields;
	private int connectedFieldGoal;
	private String operation;
	
	public void setField(JTextField field) {
		this.field = field;
	}
	
	public JTextField getField() {
		return this.field;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Integer getNumber() {
		return this.number;
	}
	
	public void setNumberFromFieldData() {
		Integer number = 0;
		String text = this.getField().getText().trim();
		if (text.length() == 1 && text.matches("[1-6]")) {
			number = Integer.parseInt(text);
			this.setNumber(number);
		} else {
			this.setNumber(0);
			System.out.println("invalid character at " + this.getLocation().getI() + " " + this.getLocation().getJ());
		}
	}
	
	public void setLocation(Location location) {
		this.ownLocation = location;
	}
	
	public Location getLocation() {
		return this.ownLocation;
	}
	
	public void setColorOfCollection(Color color) {
		for (FieldData f : this.getListOfConnectedFields()) {
			f.colorOfCollection = color;
			f.getField().setBackground(color);
		}
	}
	
	public void setListOfConnectedFields(FieldData[] list) {
		this.listOfConnectedFields = list;
		for (FieldData f : this.getListOfConnectedFields()) {
			f.listOfConnectedFields = list;
		}
	}
	
	public FieldData[] getListOfConnectedFields() {
		return this.listOfConnectedFields;
	}
	
	public void setConnectedFieldGoal() {
		
	}
	
}

class Location {
	private int i;
	private int j;
	
	public Location(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public int getI() {
		return this.i;
	}
	
	public int getJ() {
		return this.j;
	}
	
}
