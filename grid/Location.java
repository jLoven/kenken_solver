package grid;

import java.util.ArrayList;

public class Location {
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
