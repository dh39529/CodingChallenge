package com.challenge.robots;

public class Robot {

	private int xpos;
	private int ypos;
	private String instructions;
	private String directions[] = new String[] {"N", "E", "S", "W"};
	private int directionIndex;
	private boolean isLost;
	
	
	public Robot(int x, int y, String direction) {
		xpos = x;
		ypos = y;
		int index = 0;
		for (String point : directions) {
			if (direction.equals(point)) {
				this.directionIndex = index;
				break;
			}
			index++;
		}
		
	}
	
	public void setInstructions(String instructionSet) {
		instructions = instructionSet;
	}
	
	public String getInstructions() {
		return instructions;
	}
	
	public void setXPos(int x) {
		xpos = x;
	}
	
	public int getXpos() {
		return xpos;
	}
	
	public void setYPos(int y) {
		ypos = y;
	}

	public int getYpos() {
		return ypos;
	}
	
	public void setDirectionIndex(int direction) {
		directionIndex = direction;
	}
	
	public int getDirectionIndex() {
		return directionIndex;
	}
	
	public void setLost() {
		isLost = true;
	}
		
	public boolean isLost() {
		return isLost;
	}
	
	@Override
	public String toString() {
		return xpos + " " + ypos + " " + directions[directionIndex] + (isLost ? " LOST" : "");		
	}
	

}
