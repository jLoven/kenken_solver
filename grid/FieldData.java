package grid;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JTextField;

public class FieldData {

	private JTextField field;
	private Integer number;
	private Location ownLocation;

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
	
	public boolean isEquivalentTo(Location location) {
		if (this.getI() == location.getI() && this.getJ() == location.getJ()) {
			return true;
		}
		return false;
	}
	
	public boolean isInsideList(Location[] locations) {
		for (Location l : locations) {
			if (this.isEquivalentTo(l)) {
				return true;
			}
		}
		return false;
	}
	
	public Location[] returnContainerList(ArrayList<Location[]> locationsList) {
		for (Location[] l : locationsList) {
			if (this.isInsideList(l)) {
				return l;
			}
		}
		System.out.println("Something went wrong in Location");
		return null;
	}
}
