package grid;

import java.awt.Color;

import javax.swing.JTextField;

public class FieldData {

	//  store info about which fields are connected
	//  draw grid based on this
	//  also each field should be its own class and store info about what can go in each field?
	private JTextField field;
	private Integer number;
	private Location ownLocation;
	private Color colorOfCollection;
	private Location[] listOfConnectedFields;
	
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
		this.colorOfCollection = color;
	}
	
	public void setListOfConnectedFields(Location[] list) {
		this.listOfConnectedFields = list;
	}
	
	public Location[] getListOfConnectedFields() {
		return this.listOfConnectedFields;
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
