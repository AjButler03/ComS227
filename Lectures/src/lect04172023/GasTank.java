package lect04172023;

public class GasTank {
	private int level;

	public int getLevel() {
		return level;
	}

	public void setLevel(int lev) {
		level = lev;
	}
	
	public void useFuel(int amount) {
		level -= amount;
	}
}
