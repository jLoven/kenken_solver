package grid;

import java.awt.Color;

import javax.swing.JTextField;

public class FieldCollections {

	//  store info about which fields are connected
	//  draw grid based on this
	//  also each field should be its own class and store info about what can go in each field?
	private JTextField field;
	private Color colorOfCollection;
	private Location[] listOfConnectedFields;
	
	public void setField(JTextField field) {
		this.field = field;
	}
	
	public JTextField getField() {
		return this.field;
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
	public int i;
	public int j;
	
	public Location(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
